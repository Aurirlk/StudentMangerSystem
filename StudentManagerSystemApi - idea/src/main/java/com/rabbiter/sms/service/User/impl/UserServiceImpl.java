package com.rabbiter.sms.service.User.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.rabbiter.sms.dao.User.AdminMapper;
import com.rabbiter.sms.dao.User.StudentMapper;
import com.rabbiter.sms.dao.User.TeacherMapper;
import com.rabbiter.sms.dao.User.UserMapper;
import com.rabbiter.sms.dto.User;
import com.rabbiter.sms.service.User.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Description 登陆用户业务层
 * Author: rabbiter
 * Date2019/10/21 21:09
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private AdminMapper adminMapper;

    @Override
    public User getStudentInfo(Map<String, Object> condition) {
        String keyValue = condition.get("level").toString();
        if (keyValue.equals("0")) {
            return userMapper.getAdminInfo(condition);
        } else if (keyValue.equals("1")) {
            return userMapper.getTeacherInfo(condition);
        } else {
            return userMapper.getStudentInfo(condition);
        }
    }

    @Override
    public boolean update(Map<String, Object> condition) {
        switch (condition.get("level").toString()) {
            case "0":
                condition.put("table", "admin");
                break;
            case "1":
                condition.put("table", "teacher");
                break;
            case "2":
                condition.put("table", "student");
                break;
        }
        Integer num = userMapper.checkPasswordCount(condition);
        if (num != 0) {
            userMapper.update(condition);
        }
        return num != 0;
    }

    @Override
    public List<Object> getTree() {
        // 获取专业
        List<User> studentList = studentMapper.getStudentTree();
        Set<User> studentSet = new HashSet<>(studentList);
        List<Map<String, Object>> professionList = new ArrayList<>();
//  转化为前端树形结构所需的数据格式
        Set<String> proSet = studentList.stream().map(User::getProfession).collect(Collectors.toSet());
        for (String profession : proSet) {
            Map<String, Object> stuProfessionTreeObj = new HashMap<>();

            stuProfessionTreeObj.put("label", profession);
            List<String> gradeList = studentMapper.getGradeByProfession(profession);

            gradeList = new HashSet<>(gradeList).stream().sorted(Comparator.comparing(Integer::new)).collect(Collectors.toList());

            // 转成int，然后再排序
            List<Map<String, Object>> gradeTreeList = new ArrayList<>();
            for (String grade : gradeList) {
                Map<String, Object> gradeTreeMap = new HashMap<>();
                gradeTreeMap.put("label", grade);
                gradeTreeList.add(gradeTreeMap);
            }

            stuProfessionTreeObj.put("children", gradeTreeList);
            professionList.add(stuProfessionTreeObj);
        }

        ArrayList<Object> treeList = new ArrayList<>();
        Map<String, Object> studentObj = new HashMap<>();
        Map<String, Object> teacherObj = new HashMap<>();
        Map<String, Object> adminObj = new HashMap<>();
        studentObj.put("label", "学生");
        studentObj.put("children", professionList);
        teacherObj.put("label", "教师");
        adminObj.put("label", "管理员");
        treeList.add(studentObj);
        treeList.add(teacherObj);
        treeList.add(adminObj);
        return treeList;
    }

    @Override
    public String getToken(User user, long time) {
        if (user == null) {
            return "";
        }
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + time;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
        JWTCreator.Builder builder = JWT.create().withAudience(user.getLevel().toString() + user.getId());
        token = builder.withIssuedAt(start).withExpiresAt(end)
                // 储存id和level
                .sign(Algorithm.HMAC256(user.getPassword())); // 储存password，用于解密
        return token;
    }

    @Override
    public User findUser(Map<String, Object> condition) {
        String id = condition.get("id").toString();
        String level = condition.get("level").toString();
        User user = new User();
        switch (level) {
            case "0":
                user = adminMapper.getUserById(id);
                break;
            case "1":
                user = teacherMapper.getUserById(id);
                break;
            case "2":
                user = studentMapper.getUserById(id);
                break;
        }
        return user;
    }

    @Override
    public boolean getSilent() {
        int value = userMapper.getSilent();
        return value == 1;
    }

    @Override
    public boolean setSilent(Integer state) {
        userMapper.setSilent(state);
        return state == 1;
    }

}

package com.rabbiter.sms.dao.TeacherCourse;

import com.rabbiter.sms.domain.TeacherCourse;
import com.rabbiter.sms.dto.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Description 教师课程Mapper层
 * Author: rabbiter
 * Date: 2020/3/29 15:13
 **/
@Mapper
public interface TeacherCourseMapper {
  /**
   * description: 新增
   * @param teacherCourse
   * @return void
   * @author rabbiter
   * @date 2020/3/4 23:05
   */
  void add(TeacherCourse teacherCourse);

  /**
   * description: 删除
   *
   * @param ids
   * @return void
   * @author rabbiter
   * @date 2019/8/29 14:55
   */
  void delete(@Param("ids") List<Integer> ids);

  /**
   * description: 修改
   *
   * @param teacherCourse
   * @return void
   * @author rabbiter
   * @date 2019/8/29 14:55
   */
  void update(TeacherCourse teacherCourse);

  /**
   * description: 根据教师id获取教师课程信息
   * @param: String
   * return: List<TeacherCourse>
   * Author: rabbiter
   * @Date: 2022/3/29 14:33
   */
  List<TeacherCourse> getCourseListById(@Param("id") String id);
  /**
   * description: 获取教师id和专业获取班级、课程名
   * @param:
   * return:
   * Author: rabbiter
   * @Date: 2022/4/4 20:54
   */
  List<TeacherCourse> getGradeInfoByMap(@Param("condition") Map<String, Object> condition);
  /**
  * description: 根据专业、班级和课程名获取所授课的教师id
  * @param: condition
  * return: String
  * Author: rabbiter
  * @Date: 2022/4/7 16:17
  */
  String getTeacherId(@Param("condition") Map<String, Object> condition);
  /**
  * description: 课程表中获取课程详细信息
  * @param: condition
  * return: TeacherCourse
  * Author: rabbiter
  * @Date: 2022/4/9 17:31
  */
  Course getCourseInfo(@Param("condition") Map<String, Object> condition);
}

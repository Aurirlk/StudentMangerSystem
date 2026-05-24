package com.rabbiter.sms.controller.Timetable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rabbiter.sms.domain.CourseInfo;
import com.rabbiter.sms.domain.WeekCourse;
import com.rabbiter.sms.service.Timetable.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Description  课程表控制层
 * Author: rabbiter
 * Date: 2020/4/7 14:02
 **/
@RestController
@RequestMapping("/api/sms/timetable")
public class TimetableController {
  @Autowired
  private TimetableService timetableService;

  /**
   * 新增、更新课程表
   * @param WeekCourseList 课程表信息
   *
   */
  @PostMapping
  public void add(@RequestBody JSONArray WeekCourseList) {
    List<WeekCourse> list = JSONObject.parseArray(WeekCourseList.toJSONString(), WeekCourse.class);
    timetableService.add(list);
  }

  @GetMapping("/getTimetable")
  public List<WeekCourse> getStudentList (@RequestParam Map<String, Object> condition) {
    return timetableService.getTimetable(condition);
  }

  @GetMapping("/getTimetableByStudent")
  public List<WeekCourse> getTimetableByStudent (@RequestParam Map<String, Object> condition) {
    return timetableService.getTimetableByStudent(condition);
  }
  @GetMapping("/getTimetableByTeacher")
  public List<WeekCourse> getTimetableByTeacher (@RequestParam Map<String, Object> condition) {
    return timetableService.getTimetableByTeacher(condition);
  }
  @PostMapping("/updateCourseInfo")
  public void updateCourseInfo(@RequestBody CourseInfo courseInfo) {
    timetableService.updateCourseInfo(courseInfo);
  }

}

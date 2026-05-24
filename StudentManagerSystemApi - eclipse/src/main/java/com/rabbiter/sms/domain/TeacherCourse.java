package com.rabbiter.sms.domain;

import com.rabbiter.sms.dto.Course;

/**
 * Description 教师课程任命表实体类
 * Author: rabbiter
 * Date: 2020/3/29 15:04
 **/
public class TeacherCourse {
  /**
   * id
   */
  private Integer id;
  /**
   * 教师id
   */
  private String teacherId;
  /**
   * 教师用户名
   */
  private String username;
  /**
   * 课程名
   */
  private String name;
  /**
   * 专业
   */
  private String profession;
  /**
   * 班级
   */
  private String grade;
  /**
   * 学期
   */
  private Integer term;

  /**
   * 课程id
   */
  private String courseId;

  private CourseInfo courseInfo;

  public TeacherCourse(String name, String grade) {
    this.name = name;
    this.grade = grade;
  }

  public TeacherCourse(Integer id, String teacherId, String username, String name, String profession, String grade, Integer term, String courseId) {
    this.id = id;
    this.teacherId = teacherId;
    this.username = username;
    this.name = name;
    this.profession = profession;
    this.grade = grade;
    this.term = term;
    this.courseId = courseId;
  }

  public TeacherCourse(Integer id, String teacherId, String username, String name, String profession, String grade, Integer term, String courseId, CourseInfo courseInfo) {
    this.id = id;
    this.teacherId = teacherId;
    this.username = username;
    this.name = name;
    this.profession = profession;
    this.grade = grade;
    this.term = term;
    this.courseId = courseId;
    this.courseInfo = courseInfo;
  }

  public CourseInfo getCourseInfo() {
    return courseInfo;
  }

  public void setCourseInfo(CourseInfo courseInfo) {
    this.courseInfo = courseInfo;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public Integer getTerm() {
    return term;
  }

  public void setTerm(Integer term) {
    this.term = term;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }
}

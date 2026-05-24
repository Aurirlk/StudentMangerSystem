package com.rabbiter.sms.dto;

/**
 * Description 课程表实体类
 * Author: rabbiter
 * Date: 2020/4/7 13:57
 **/
public class Timetable {
  /**
   * id
   */
  private Integer id;
  /**
   * week id
   */
  private Integer weekId;
  /**
   * 专业
   */
  private String profession;
  /**
   * 班级
   */
  private String grade;
  /**
   * 学年
   */
  private Integer year;
  /**
   * 学期
   */
  private Integer term;

  /**
   * 周数
   */
  private Integer weekNum;

  public Timetable() {
  }

  public Timetable(Integer id, Integer weekId, String profession, String grade, Integer year, Integer term, Integer weekNum) {
    this.id = id;
    this.weekId = weekId;
    this.profession = profession;
    this.grade = grade;
    this.year = year;
    this.term = term;
    this.weekNum = weekNum;
  }

  public Timetable(Integer id, Integer weekId, String profession, String grade, Integer year, Integer term) {
    this.id = id;
    this.weekId = weekId;
    this.profession = profession;
    this.grade = grade;
    this.year = year;
    this.term = term;
  }

  public Integer getWeekNum() {
    return weekNum;
  }

  public void setWeekNum(Integer weekNum) {
    this.weekNum = weekNum;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getWeekId() {
    return weekId;
  }

  public void setWeekId(Integer weekId) {
    this.weekId = weekId;
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

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getTerm() {
    return term;
  }

  public void setTerm(Integer term) {
    this.term = term;
  }

  @Override
  public String toString() {
    return "Timetable{" +
            "id=" + id +
            ", weekId=" + weekId +
            ", profession='" + profession + '\'' +
            ", grade='" + grade + '\'' +
            ", year=" + year +
            ", term=" + term +
            '}';
  }
}

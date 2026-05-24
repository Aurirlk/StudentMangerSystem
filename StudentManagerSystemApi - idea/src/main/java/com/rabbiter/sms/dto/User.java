package com.rabbiter.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description 登陆信息
 * Author: rabbiter
 * Date2019/10/21 20:58
 **/
public class User {
  /**
   * id
   */
  private String id;
  /**
   * 用户名
   */
  private String username;
  /**
   * 密码
   */
  private String password;
  /**
   * 确认密码
   */
  private String passwordAgain;
  /**
   * 真实姓名
   */
  private String realName;
  /**
   * 等级
   */
  private Integer level;
  /**
   * 学校
   */
  private String school;
  /**
   * 入学时间
   */
  private String admissionTime;
  /**
   * 电子邮箱
   */
  private String email;
  /**
   * 专业
   */
  private String profession;
  /**
   * 联系电话
   */
  private String phone;
  /**
   *  性别
   */
  private Integer sex;
  /**
   * 班级
   */
  private String grade;
  /**
   * 创建时间
   */
  private Date createTime;
  /**
   * token
   */
  private String token;
  /**
   * refreshToken
   */
  private String refreshToken;
  /**
   * 默哀模式
   */
  private Integer state;

  public User() {
  }

  public User(String id, String username, String password, String passwordAgain, String realName, Integer level, String school, String admissionTime, String email, String profession, String phone, Integer sex, String grade, Date createTime, String token, String refreshToken, Integer state) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.passwordAgain = passwordAgain;
    this.realName = realName;
    this.level = level;
    this.school = school;
    this.admissionTime = admissionTime;
    this.email = email;
    this.profession = profession;
    this.phone = phone;
    this.sex = sex;
    this.grade = grade;
    this.createTime = createTime;
    this.token = token;
    this.refreshToken = refreshToken;
    this.state = state;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordAgain() {
    return passwordAgain;
  }

  public void setPasswordAgain(String passwordAgain) {
    this.passwordAgain = passwordAgain;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getAdmissionTime() {
    return admissionTime;
  }

  public void setAdmissionTime(String admissionTime) {
    this.admissionTime = admissionTime;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "User{" +
            "id='" + id + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", passwordAgain='" + passwordAgain + '\'' +
            ", realName='" + realName + '\'' +
            ", level=" + level +
            ", school='" + school + '\'' +
            ", admissionTime='" + admissionTime + '\'' +
            ", email='" + email + '\'' +
            ", profession='" + profession + '\'' +
            ", phone='" + phone + '\'' +
            ", sex=" + sex +
            ", grade='" + grade + '\'' +
            ", createTime=" + createTime +
            ", token='" + token + '\'' +
            ", refreshToken='" + refreshToken + '\'' +
            ", state=" + state +
            '}';
  }
}

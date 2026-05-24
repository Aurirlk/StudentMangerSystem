package com.rabbiter.sms.dto;

import java.util.Arrays;

/**
 * Description 树形实体类
 * Author: rabbiter
 * Date: 2020/3/27 22:07
 **/
public class Tree {
  private String name;
  private String [] school;
  private String [] profession;

  public Tree() {
  }

  public Tree(String name, String[] school, String[] profession) {
    this.name = name;
    this.school = school;
    this.profession = profession;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String[] getSchool() {
    return school;
  }

  public void setSchool(String[] school) {
    this.school = school;
  }

  public String[] getProfession() {
    return profession;
  }

  public void setProfession(String[] profession) {
    this.profession = profession;
  }

  @Override
  public String toString() {
    return "Tree{" +
            "name='" + name + '\'' +
            ", school=" + Arrays.toString(school) +
            ", profession=" + Arrays.toString(profession) +
            '}';
  }
}

package com.rabbiter.sms.domain;

/**
 * Description 上传
 * Author: rabbiter
 * Date: 2020/4/29 12:50
 **/
public class Upload {
  /**
   * id
   */
  private Integer id;
  /**
   * 用户 id
   */
  private String userId;
  /**
   * 用户等级
   */
  private Integer level;
  /**
   * 储存地址
   */
  private String url;

  public Upload() {
  }

  public Upload(Integer id, String userId, Integer level, String url) {
    this.id = id;
    this.userId = userId;
    this.level = level;
    this.url = url;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "Upload{" +
            "id=" + id +
            ", userId='" + userId + '\'' +
            ", level=" + level +
            ", url='" + url + '\'' +
            '}';
  }
}

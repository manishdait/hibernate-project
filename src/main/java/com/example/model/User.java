package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {
  @Id
  @Column(name = "u_id")
  private int id;
  private String username;

  @OneToOne
  @JoinColumn(name = "ui_id")
  private UserInfo userInfo;

  public User(int id, String username, UserInfo userInfo) {
    this.id = id;
    this.username = username;
    this.userInfo = userInfo;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserInfo getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + ", userInfo=" + userInfo + "]";
  }
}

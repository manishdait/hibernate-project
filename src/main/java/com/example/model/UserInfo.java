package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {
  @Id
  @Column(name = "ui_id")
  private int id;

  @Column(name = "full_name")
  private String name;
  private String email;

  public UserInfo(int id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmai(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "UserInfo [id=" + id + ", name=" + name + ", email=" + email + "]";
  }
}

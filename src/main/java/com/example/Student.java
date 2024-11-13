package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
  @Id
  private int id;
  private String name;
  private float marks;

  public Student() {}

  public Student(int id, String name, float marks) {
    this.id = id;
    this.name = name;
    this.marks = marks;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public float getMarks() {
    return marks;
  }

  public void setMarks(float marks) {
    this.marks = marks;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
  }
}

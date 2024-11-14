package com.example.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
  @Id
  @Column(name = "course_id")
  private int id;
  private String name;

  @ManyToMany
  private List<People> peoples;

  public Course() {}
  
  public Course(int id, String name, List<People> peoples) {
    this.id = id;
    this.name = name;
    this.peoples = peoples;
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

  public List<People> getPeoples() {
    return peoples;
  }

  public void setPeoples(List<People> peoples) {
    this.peoples = peoples;
  }

  @Override
  public String toString() {
    return "Course [id=" + id + ", name=" + name + ", peoples=" + peoples.size() + "]";
  }
}

package com.example.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "people")
public class People {
  @Id
  @Column(name = "p_id")
  private int id;
  private String name;

  @ManyToMany
  private List<Course> course;

  public People() {}

  public People(int id, String name, List<Course> course) {
    this.id = id;
    this.name = name;
    this.course = course;
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

  public List<Course> getCourse() {
    return course;
  }

  public void setCourse(List<Course> course) {
    this.course = course;
  }

  @Override
  public String toString() {
    return "People [id=" + id + ", name=" + name + ", course=" + course + "]";
  }  
}

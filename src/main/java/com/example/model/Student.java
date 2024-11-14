package com.example.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
  @Id
  @Column(name = "s_id")
  private int id;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "fName", column = @Column(name = "first_name")),
    @AttributeOverride(name = "lName", column = @Column(name = "last_name"))
  })
  private Name name;

  public Student() {}

  public Student(int id, Name name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + "]";
  }
}

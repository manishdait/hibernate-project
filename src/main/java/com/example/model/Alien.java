package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alien")
public class Alien {
  @Id
  @Column(name = "a_id")
  private int id;
  private String name;
  private String tech;

  public Alien() {}

  public Alien(int id, String name, String tech) {
    this.id = id;
    this.name = name;
    this.tech = tech;
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

  public String getTech() {
    return tech;
  }
  
  public void setTech(String tech) {
    this.tech = tech;
  }

  @Override
  public String toString() {
    return "Alien [id=" + id + ", name=" + name + ", tech=" + tech + "]";
  }
}

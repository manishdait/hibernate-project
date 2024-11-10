package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "alien_table")
public class Alien {
  @Id
  private int id;
  
  @Column(name = "alien_name")
  private String name;

  @Transient
  private String secret;

  public Alien() {}

  public Alien(int id, String name) {
    this.id = id;
    this.name = name;
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

  @Override
  public String toString() {
    return "Alien [id=" + id + ", name=" + name + ", secret=" + secret + "]";
  }
}

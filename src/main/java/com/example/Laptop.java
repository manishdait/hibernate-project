package com.example;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
  @Id
  private int id;
  private String lname;

  // @ManyToOne
  // private Alien alien;

  @ManyToMany
  private List<Alien> alien;

  public Laptop() {}

  public Laptop(int id, String lname) {
    this.id = id;
    this.lname = lname;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public List<Alien> getAlien() {
    return alien;
  }

  public void setAlien(List<Alien> alien) {
    this.alien = alien;
  }

  @Override
  public String toString() {
    return "Laptop [id=" + id + ", lname=" + lname + "]";
  }
}

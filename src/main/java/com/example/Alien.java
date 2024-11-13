package com.example;

import java.util.List;

// import jakarta.persistence.AttributeOverride;
// import jakarta.persistence.AttributeOverrides;
// import jakarta.persistence.Embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alien_table")
public class Alien {
  @Id
  private int id;
  
  @Column(name = "alien_name")
  private String name;

  // @Embedded
  // @AttributeOverrides({
  //   @AttributeOverride(name = "buildName", column = @Column(name = "building"))
  // })
  // private Address address;

  // @OneToMany(mappedBy = "alien")
  // private List<Laptop> laptop;

  // @ManyToMany(mappedBy = "alien")
  // private List<Laptop> laptop;

  public Alien() {}

  public Alien(int id, String name) {
    this.id = id;
    this.name = name;
    // this.laptop = laptop;
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

  // public Address getAddress() {
  //   return address;
  // }

  // public void setAddress(Address address) {
  //   this.address = address;
  // }

  // public Laptop getLaptop() {
  //   return laptop;
  // }

  // public void setLaptop(Laptop laptop) {
  //   this.laptop = laptop;
  // }

  // public List<Laptop> getLaptop() {
  //   return laptop;
  // }

  // public void setLaptop(List<Laptop> laptop) {
  //   this.laptop = laptop;
  // }
  
  @Override
  public String toString() {
    return "Alien [id=" + id + ", name=" + name + "]";
  }

}

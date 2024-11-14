package com.example.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @Column(name = "c_id")
  private int id;

  @Column(name = "username")
  private String name;

  @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
  private List<Order> orders;

  public Customer() {}
  
  public Customer(int id, String name, List<Order> orders) {
    this.id = id;
    this.name = name;
    this.orders = orders;
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

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + "]";
  } 
}
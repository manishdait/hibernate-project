package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_order")
public class Order {
  @Id
  @Column(name = "order_id")
  private int id;
  private String item;
  private float price;

  @ManyToOne
  @JoinColumn(name = "c_id")
  private Customer customer;

  public  Order() {}

  public Order(int id, String item, float price) {
    this.id = id;
    this.item = item;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", item=" + item + ", price=" + price + "]";
  }
}

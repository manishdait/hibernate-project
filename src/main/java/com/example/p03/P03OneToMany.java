package com.example.p03;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Customer;
import com.example.model.Order;

public class P03OneToMany {
  public static void main(String[] args) {
    Configuration cfg = new Configuration().configure("hibernate_p03.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();

    session.beginTransaction();

    Order order1 = new Order(101, "Apple", 23.4f);
    Order order2 = new Order(102, "Orange", 10.4f);

    Customer customer = new Customer();
    customer.setId(100);
    customer.setName("Peter Griffin");
    customer.setOrders(new ArrayList<>());

    order1.setCustomer(customer);
    order2.setCustomer(customer);

    customer.getOrders().add(order1);
    customer.getOrders().add(order2);

    session.persist(order1);
    session.persist(order2);
    session.persist(customer);

    session.getTransaction().commit();

    Customer obj = session.get(Customer.class, 100);
    System.out.println(obj);

    //Fetch Lazy fetch when used.
    System.out.println(obj.getOrders());
  }
}

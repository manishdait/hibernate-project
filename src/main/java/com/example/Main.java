package com.example;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
  public static void main(String[] args) {
    Laptop laptop = new Laptop(101, "Dell XPS");
    laptop.setAlien(new ArrayList<>());
    

    Alien alien = new Alien(104, "Peter Griffin", new ArrayList<>());
    alien.getLaptop().add(laptop);
    // laptop.setAlien(alien);
    laptop.getAlien().add(alien);

    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sf = configuration.buildSessionFactory();
    Session session = sf.openSession();

    Transaction tx = session.beginTransaction();
    session.persist(laptop);
    session.persist(alien);
    tx.commit();

    Alien a = session.get(Alien.class, 104);
    System.out.println(a);
  }
}
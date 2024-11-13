package com.example;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
  public static void main(String[] args) {
  //   Laptop laptop = new Laptop(101, "Dell XPS");
  //   laptop.setAlien(new ArrayList<>());
    

    Alien alien1 = new Alien(101, "Peter Griffin");
    Alien alien2 = new Alien(102, "Joe Swanson");
    // alien.getLaptop().add(laptop);
    // laptop.setAlien(alien);
    // laptop.getAlien().add(alien);

    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sf = configuration.buildSessionFactory();

    Session session = sf.openSession();
    session.beginTransaction();
    session.persist(alien1);
    session.persist(alien2);
     session.getTransaction().commit();

    System.out.println("\n\n");

    // Fire query 2 times
    // Session session1 = sf.openSession();
    // session1.beginTransaction();
    // Alien a1 = session1.get(Alien.class, 101);
    // Alien a2 = session1.get(Alien.class, 102);
    // session1.getTransaction().commit();

    // L1 cache use
    // Session session1 = sf.openSession();
    // session1.beginTransaction();
    // Alien a1 = session1.get(Alien.class, 101);
    // Alien a2 = session1.get(Alien.class, 101);
    // session1.getTransaction().commit();

    // Diff session use diff l1 Cache
    Session session1 = sf.openSession();
    session1.beginTransaction();
    Alien a1 = session1.get(Alien.class, 101);
    session1.getTransaction().commit();

    Session session2 = sf.openSession();
    session2.beginTransaction();
    Alien a2 = session2.get(Alien.class, 101);
    session2.getTransaction().commit();

    System.out.println(a1);
    System.out.println(a2);
  }
}
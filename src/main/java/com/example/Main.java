package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
  public static void main(String[] args) {
    Alien alien = new Alien(104, "Peter Griffin");

    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sf = configuration.buildSessionFactory();
    Session session = sf.openSession();

    // Transaction tx = session.beginTransaction();
    // session.persist(alien);
    // tx.commit();

    // Alien obj = session.get(Alien.class, 103);
    // System.out.println(obj);

    Transaction tx = session.beginTransaction();
    session.update(alien);;
    tx.commit();
  }
}
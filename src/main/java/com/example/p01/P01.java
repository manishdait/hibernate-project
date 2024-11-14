package com.example.p01;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.model.Alien;

public class P01 {
  public static void main(String[] args) {
    // If <mapping class="" /> not mention
    // Configuration cfg = new Configuration().configure("hibernate_p01.cfg.xml").addAnnotatedClass(Alien.class);

    Configuration cfg = new Configuration().configure("hibernate_p01.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();

    Random random = new Random();

    // Save Aliens to Db
    Transaction tx = session.beginTransaction();
    for(int i = 0; i < 5; i++) {
      Alien alien = new Alien(100 + i, "Alien:" + i , "Tech" + random.nextInt(10));
      // session.save(alien) Deprecated
      session.persist(alien);
    }
    tx.commit();

    // Get a alien by Id
    Alien obj = session.get(Alien.class, 102);
    System.out.println(obj);

    // Update alien
    obj.setName("Peter");
    session.beginTransaction();
      // session.update(obj); Deprecated
    session.merge(obj);
    session.getTransaction().commit();

    // Delete alien
    Alien obj2 = session.get(Alien.class, 100);
    session.beginTransaction();
    session.remove(obj2);
    session.getTransaction().commit();

    session.close();
  }
}

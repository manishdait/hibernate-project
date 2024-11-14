package com.example.p04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Alien;

public class P04Level1Caching {
  public static void main(String[] args) {
    Configuration cfg = new Configuration().configure("hibernate_p01.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();

    Session session1 = sf.openSession();
    Session session2 = sf.openSession();

    // Query fires one time
    session1.beginTransaction();

    Alien a1 = session1.get(Alien.class, 102);
    System.out.println(a1);

    Alien a2 = session1.get(Alien.class, 102);
    System.out.println(a2);
    
    session1.getTransaction().commit();


    // Query fires 2 time
    session1.beginTransaction();

    Alien a3 = session1.get(Alien.class, 102);
    System.out.println(a3);

    session1.getTransaction().commit();

    session2.beginTransaction();

    Alien a4 = session2.get(Alien.class, 102);
    System.out.println(a4);

    session2.getTransaction().commit();
  }
}

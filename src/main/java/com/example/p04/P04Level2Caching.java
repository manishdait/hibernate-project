package com.example.p04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Alien;

public class P04Level2Caching {
  public static void main(String[] args) {
    // hibernate-core and hibernate-ehcache must be of same version to work;
    Configuration cfg = new Configuration().configure("hibernate_p04.cfg.xml");
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


    // Query fires 1 time
    // Using L2 cache
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

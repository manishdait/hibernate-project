package com.example.p06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Alien;

public class P06 {
  public static void main(String[] args) {
    Configuration cfg = new Configuration().configure("hibernate_p01.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();

    Session session = sf.openSession();

    session.beginTransaction();
    // transient
    Alien alien = new Alien();
    alien.setId(200);
    alien.setName("Stewie");
    alien.setTech("Blockchain");
    // transient

    // persistent
    session.persist(alien);
    alien.setTech("Cloud");

    session.getTransaction().commit();
  }
}

package com.example.p05;

import java.util.List;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.model.Alien;

public class HqlEg {
  public static void main(String[] args) {
    Configuration cfg = new Configuration().configure("hibernate_p01.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Random random = new Random();

    Session session = sf.openSession();

    session.beginTransaction();

    for (int i = 1; i <= 10; i++) {
      Alien alien = new Alien(100 + i, "Name" + i, "Tech" +random.nextInt(100));
      session.persist(alien);
    }

    Query query1 = session.createQuery("from Alien");
    List<Alien> aliens1 = query1.list();
    for (Alien a : aliens1) {
      System.out.println(a);
    }

    Query query2 = session.createQuery("from Alien where id >= 102");
    List<Alien> aliens2 = query2.list();
    for (Alien a : aliens2) {
      System.out.println(a);
    }

    Query query3 = session.createQuery("from Alien where id = 102");
    Alien aliens3 = (Alien)query3.uniqueResult();
    System.out.println(aliens3);

    Query query4 = session.createQuery("from Alien where id = :i");
    query4.setParameter("i", 101);
    Alien alien4 = (Alien)query4.uniqueResult();
    System.out.println(alien4);

    Query query5 = session.createQuery("select name, tech from Alien");
    List<Object[]> alien5 = query5.list();
    for (Object[] a : alien5) {
      for (int i = 0; i < a.length; i++) {
        System.out.print(a[i] +" ");
      }

      System.out.println("\n");
    }

    Query query6 = session.createQuery("select sum(id) from Alien");
    Object sum = query6.uniqueResult();

    System.out.println(sum);

    session.getTransaction().commit();
  }
}

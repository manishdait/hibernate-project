package com.example.p03;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Course;
import com.example.model.People;

public class p03ManyToMany {
  public static void main(String[] args) {
    Configuration cfg = new Configuration().configure("hibernate_p03.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();

    session.beginTransaction();

    Course course1 = new Course();
    course1.setId(1);
    course1.setName("Java");
    course1.setPeoples(new ArrayList<>());

    Course course2 = new Course();
    course2.setId(2);
    course2.setName("SpringBoot");
    course2.setPeoples(new ArrayList<>());

    Course course3 = new Course();
    course3.setId(3);
    course3.setName("Angular");
    course3.setPeoples(new ArrayList<>());

    People p1 = new People();
    p1.setId(101);
    p1.setName("Joe Swanson");
    p1.setCourse(new ArrayList<>());

    People p2 = new People();
    p2.setId(102);
    p2.setName("Glayn Quagmier");
    p2.setCourse(new ArrayList<>());

    p1.getCourse().add(course1);
    p1.getCourse().add(course2);

    p2.getCourse().add(course2);
    p2.getCourse().add(course3);

    course1.getPeoples().add(p1);

    course2.getPeoples().add(p2);
    course2.getPeoples().add(p1);

    course3.getPeoples().add(p2);

    session.persist(course1);
    session.persist(course2);
    session.persist(course3);

    session.persist(p1);
    session.persist(p2);

    session.getTransaction().commit();


    People obj = session.get(People.class, 101);
    System.out.println(obj);
  }
}

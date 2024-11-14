package com.example.p02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Name;
import com.example.model.Student;

public class P02 {
  public static void main(String[] args) {
    Configuration cfg = new Configuration().configure("hibernate_p02.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();

    Student student = new Student();
    student.setId(101);
    student.setName(new Name("Peter" , "Griffin"));

    session.beginTransaction();
    session.persist(student);
    session.getTransaction().commit();

    Student obj = session.get(Student.class, 101);
    System.out.println(obj);
  }
}

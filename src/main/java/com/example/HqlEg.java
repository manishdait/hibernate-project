package com.example;

import java.util.List;

// import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HqlEg {
  public static void main(String[] args) {
    Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    // Random random = new Random();

    Session session = sf.openSession();

    session.beginTransaction();

    // for (int i = 1; i <= 10; i++) {
    //   Student student = new Student(100 + i, "Name" + i, random.nextInt(100));
    //   session.persist(student);
    // }

    // Query query = session.createQuery("from Student");
    // List<Student> students = query.list();
    // for (Student s : students) {
    //   System.out.println(s);
    // }

    // Query query = session.createQuery("from Student where marks >= 35");
    // List<Student> students = query.list();
    // for (Student s : students) {
    //   System.out.println(s);
    // }

    // Query query = session.createQuery("from Student where id = 102");
    // Student student = (Student)query.uniqueResult();
    // System.out.println(student);

    Query query = session.createQuery("from Student where id = :i");
    query.setParameter("i", 101);
    Student student = (Student)query.uniqueResult();
    System.out.println(student);

    // Query query = session.createQuery("select name, marks from Student");
    // List<Object[]> students = query.list();
    // for (Object[] s : students) {
    //   for (int i = 0; i < s.length; i++) {
    //     System.out.print(s[i] +" ");
    //   }

    //   System.out.println("\n");
    // }

    // Query query = session.createQuery("select sum(marks) from Student");
    // Object students = query.uniqueResult();

    // System.out.println(students);

    session.getTransaction().commit();
  }
}

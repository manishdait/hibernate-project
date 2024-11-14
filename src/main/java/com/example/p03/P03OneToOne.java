package com.example.p03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.User;
import com.example.model.UserInfo;

public class P03OneToOne {
  public static void main(String[] args) {
    Configuration cfg = new Configuration().configure("hibernate_p03.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();

    session.beginTransaction();

    UserInfo userInfo = new UserInfo(1, "Brain Griffin", "brain@familyguy.in");
    User user = new User(101, "GRiffinBrain24", userInfo);

    session.persist(userInfo);
    session.persist(user);

    session.getTransaction().commit();

    User obj = session.get(User.class, 101);
    System.out.println(obj); 
  }
}

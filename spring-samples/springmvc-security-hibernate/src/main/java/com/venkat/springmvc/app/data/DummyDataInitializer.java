package com.venkat.springmvc.app.data;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.venkat.springmvc.app.model.User;

public class DummyDataInitializer {
    
    @Autowired
    private EntityManagerFactory emf;

    public void init() {
        
        SessionFactory sessionFactory = emf.unwrap(SessionFactory.class);
        
        Session s = sessionFactory.openSession();
        Transaction trans = s.beginTransaction();
        
        s.persist(new User("user1", "Venkat", "Test1", "venkat1@test.com", 35));
        s.persist(new User("user2", "Venkat", "Test2", "venkat2@test.com", 38));
        s.persist(new User("user3", "Alice", "Turner", "alice@wonderland.com", 28));
        
        trans.commit();

    }

}

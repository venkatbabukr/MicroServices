package com.venkat.springmvc.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.venkat.springmvc.app.model.User;

@Repository
public class UsersRepository {

    @PersistenceContext
    EntityManager em;

    public List<User> getAllUsers() {
        return em.createNamedQuery(User.GET_ALL_USERS, User.class).getResultList();
    }

}

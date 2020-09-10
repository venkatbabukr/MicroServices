package com.venkat.springmvc.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkat.springmvc.app.dao.UsersRepository;
import com.venkat.springmvc.app.model.User;

@Service
public class UsersService {
    
    @Autowired
    private UsersRepository usersRepo;
    
    public List<User> getUsers() {
        return usersRepo.getAllUsers();
    }

}

package com.venkat.springmvc.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.springmvc.app.model.User;
import com.venkat.springmvc.app.services.UsersService;

@RestController
@RequestMapping(path = "/users")
@Validated
public class UsersController {
    
    @Autowired
    private UsersService usersSvc;
    
    @GetMapping
    public List<User> getUsers() {
        return usersSvc.getUsers();
    }

    @PostMapping
    public Boolean addUser(User u) {
        return false;
    }

}

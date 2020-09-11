package com.venkat.springmvc.app.v2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.springmvc.app.services.UsersService;

@RestController
@RequestMapping(path = "/users")
public class UsersController {
    
    @Autowired
    private UsersService usersSvc;

    @GetMapping
    public String hello() {
        return "Hello!";
    }
    
}

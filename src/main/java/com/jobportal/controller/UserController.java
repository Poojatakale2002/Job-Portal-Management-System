package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entity.User;
import com.jobportal.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepo;
    
    //Register
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        System.out.println("Name: "  +user.getName());
        userRepo.save(user);
        return "User Register";
    }
    
    // login
    @PostMapping("/login")
    public String login(@RequestBody User user) {
    User u = userRepo.findByEmailAndPassword
        (user.getEmail(),user.getPassword());
    
    if(u!=null) {
        return "Login Success";
    }else {
        return "Invalid Credentials";
    }
    }
}
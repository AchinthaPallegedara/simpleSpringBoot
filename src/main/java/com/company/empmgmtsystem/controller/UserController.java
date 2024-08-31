package com.company.empmgmtsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.empmgmtsystem.model.Users;
import com.company.empmgmtsystem.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.verify(user);
    }
}

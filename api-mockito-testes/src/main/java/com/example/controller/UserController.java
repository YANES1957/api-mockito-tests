package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    public User getUser(Long id) {
        return userService.getUserById(id);
    }

    public User createUser(User user) {
        return userService.createUser(user);
    }
}

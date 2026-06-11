package com.career.user_service.controller;

import com.career.user_service.entity.User;
import com.career.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(@RequestBody @jakarta.validation.Valid User user) {
    return service.createUser(user);
    }
    
    @GetMapping
    public java.util.List<User> getAllUsers() {
    return service.getAllUsers();
    }

}
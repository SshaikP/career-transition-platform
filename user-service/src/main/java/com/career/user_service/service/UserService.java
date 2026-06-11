package com.career.user_service.service;

import com.career.user_service.entity.User;
import com.career.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        return repository.save(user);
    }
    
    public java.util.List<User> getAllUsers() {
    return repository.findAll();
    }

}
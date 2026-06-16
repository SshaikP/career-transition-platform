package com.career.user_service.service;

import com.career.user_service.dto.UserRequest;
import com.career.user_service.dto.UserResponse;
import com.career.user_service.entity.User;
import com.career.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }    
    
    private String generateUserCode(UserRequest request) {

        // Extract first and last name from email
        String[] parts = request.getEmail().split("@")[0].split("\\.");

        String first = parts.length > 0 ? parts[0] : "x";
        String last = parts.length > 1 ? parts[1] : "x";

        char firstChar = Character.toUpperCase(first.charAt(0));
        String lastNameUpper = last.toUpperCase();

        String baseCode = "CTP" + firstChar + lastNameUpper;

        // Count existing entries
        long count = repository.countByUserCodeStartingWith(baseCode);

        return baseCode + (count + 1);
    }

    public UserResponse createUser(UserRequest request) {

    User user = new User();
    user.setEmail(request.getEmail());
    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());
    user.setUserCode(generateUserCode(request));

    User savedUser = repository.save(user);

    UserResponse response = new UserResponse();
    response.setId(savedUser.getId());
    response.setEmail(savedUser.getEmail());
    response.setUsername(savedUser.getUsername());

    return response;
    }
          
    public java.util.List<UserResponse> getAllUsers() {
    return repository.findAll().stream().map(user -> {
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setEmail(user.getEmail());
        res.setUsername(user.getUsername());
        res.setUserCode(user.getUserCode());
        return res;
        }).toList();
    }

    public UserResponse getUserById(java.util.UUID id) {
        
    User user = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    UserResponse res = new UserResponse();
    res.setId(user.getId());
    res.setEmail(user.getEmail());
    res.setUsername(user.getUsername());
    res.setUserCode(user.getUserCode());
        return res;
    }

    public UserResponse updateUser(java.util.UUID id, UserRequest request) {
    User user = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    user.setEmail(request.getEmail());
    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());

    User updated = repository.save(user);

    UserResponse res = new UserResponse();
    res.setId(updated.getId());
    res.setEmail(updated.getEmail());
    res.setUsername(updated.getUsername());
    res.setUserCode(updated.getUserCode());

    return res;
    }

    public void deleteUser(java.util.UUID id) {
    if (!repository.existsById(id)) {
        throw new RuntimeException("User not found");
    }

    repository.deleteById(id);
    }

} 
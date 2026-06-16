package com.career.user_service.controller;

import com.career.user_service.dto.ApiResponse;
import com.career.user_service.dto.UserRequest;
import com.career.user_service.dto.UserResponse;
import com.career.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // ✅ CREATE USER
    @PostMapping
    public ApiResponse<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
        return new ApiResponse<>("SUCCESS", service.createUser(request));
    }

    // ✅ GET ALL USERS
    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers() {
        return new ApiResponse<>("SUCCESS", service.getAllUsers());
    }

    // ✅ GET USER BY ID
    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable UUID id) {
        return new ApiResponse<>("SUCCESS", service.getUserById(id));
    }

    // ✅ UPDATE USER
    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(
            @PathVariable UUID id,
            @Valid @RequestBody UserRequest request
    ) {
        return new ApiResponse<>("SUCCESS", service.updateUser(id, request));
    }

    // ✅ DELETE USER
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable UUID id) {
        service.deleteUser(id);
        return new ApiResponse<>("SUCCESS", "User deleted successfully");
    }
}

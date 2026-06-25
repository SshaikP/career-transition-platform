package com.career.user_service.controller;

import com.career.user_service.entity.User;
import com.career.user_service.repository.UserRepository;
import com.career.user_service.service.JwtService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepo;
    private final JwtService jwtService;

    public AuthController(UserRepository userRepo, JwtService jwtService) {
        this.userRepo = userRepo;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> req) {

        String username = req.get("username");
        String password = req.get("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        user.setRole("admin".equalsIgnoreCase(username) ? "ADMIN" : "USER");

        userRepo.save(user);

        return ResponseEntity.ok(Map.of("message", "Registered"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {

        User user = userRepo.findByUsername(req.get("username"));

        if (user == null || !user.getPassword().equals(req.get("password"))) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getUsername());

        return ResponseEntity.ok(Map.of("token", token));
    }
}
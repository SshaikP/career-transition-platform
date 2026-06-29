package com.career.user_service.controller;

import com.career.user_service.entity.User;
import com.career.user_service.repository.UserRepository;
import com.career.user_service.service.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
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
        user.setPassword(passwordEncoder.encode(password)); //✅✅✅

        userRepo.save(user);

        return ResponseEntity.ok("Registered");
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {

        String username = req.get("username");
        String password = req.get("password");

        System.out.println("🔍 LOGIN ATTEMPT:");
        System.out.println("Username: " + username);
        System.out.println("Entered Password: " + password);

        User user = userRepo.findByUsername(username);

        if (user == null) {
            System.out.println("❌ User NOT found");
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        System.out.println("Stored Password: " + user.getPassword());

        boolean match = passwordEncoder.matches(password, user.getPassword());

        System.out.println("Password Match: " + match);

        if (!match) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getUsername());

        return ResponseEntity.ok(Map.of("token", token));
    }
}
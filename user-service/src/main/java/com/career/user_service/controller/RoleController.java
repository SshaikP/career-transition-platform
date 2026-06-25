package com.career.user_service.controller;

import com.career.user_service.repository.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleRepository repo;

    public RoleController(RoleRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<String> getRoles() {
        return repo.findAll()
                .stream()
                .map(r -> r.getName())
                .toList();
    }
}
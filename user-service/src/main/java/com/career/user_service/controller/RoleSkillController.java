package com.career.user_service.controller;

import com.career.user_service.repository.RoleSkillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleSkillController {

    private final RoleSkillRepository repo;

    public RoleSkillController(RoleSkillRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{role}/skills")
    public List<String> getSkills(@PathVariable String role) {

        return repo.findByRoleIgnoreCase(role)
                .stream()
                .map(r -> r.getSkill())
                .toList();
    }
}
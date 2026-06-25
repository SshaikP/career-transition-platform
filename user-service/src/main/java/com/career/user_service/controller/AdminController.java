package com.career.user_service.controller;

import com.career.user_service.entity.Role;
import com.career.user_service.entity.RoleSkill;
import com.career.user_service.repository.RoleRepository;
import com.career.user_service.repository.RoleSkillRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final RoleRepository roleRepo;
    private final RoleSkillRepository roleSkillRepo;

    public AdminController(RoleRepository roleRepo, RoleSkillRepository roleSkillRepo) {
        this.roleRepo = roleRepo;
        this.roleSkillRepo = roleSkillRepo;
    }

    @PostMapping("/role")
    public Role addRole(@RequestBody Role role) {
        return roleRepo.save(role);
    }

    @PostMapping("/roleskill")
    public RoleSkill addRoleSkill(@RequestBody RoleSkill roleSkill) {
        return roleSkillRepo.save(roleSkill);
    }
}
package com.career.user_service.controller;

import com.career.user_service.repository.RoleSkillRepository;
import com.career.user_service.entity.RoleSkill;   // ✅ IMPORTANT
import org.springframework.beans.factory.annotation.Autowired;  // ✅ IMPORTANT
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/roleskills")
    @CrossOrigin(origins = "http://localhost:3000")
    public class RoleSkillController {

        @Autowired
        private RoleSkillRepository repo;

        @GetMapping("/{role}")
        public List<RoleSkill> getSkills(@PathVariable String role) {
            return repo.findByRoleIgnoreCase(role);
        }
    }
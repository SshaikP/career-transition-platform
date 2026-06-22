package com.career.user_service.controller;

import com.career.user_service.entity.RoleSkill;
import com.career.user_service.repository.RoleSkillRepository;
import com.career.user_service.service.SkillAnalysisService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analysis")
@CrossOrigin(origins = "http://localhost:3000") // ✅ Safe for local dev
public class SkillAnalysisController {

    private final SkillAnalysisService service;
    private final RoleSkillRepository roleSkillRepository;

    public SkillAnalysisController(SkillAnalysisService service,
                                   RoleSkillRepository roleSkillRepository) {
        this.service = service;
        this.roleSkillRepository = roleSkillRepository;
    }

    // ✅ Basic analysis
    @PostMapping
    public ResponseEntity<Map<String, Object>> analyzeSkills(
            @RequestParam String currentSkills,
            @RequestParam String targetRole
    ) {
        Map<String, Object> result =
                service.analyzeSkills(currentSkills, targetRole);

        return ResponseEntity.ok(result);
    }

    // ✅ Self-learning API
    @PostMapping("/learn")
    public ResponseEntity<String> learnRole(
            @RequestParam String role,
            @RequestParam String skills
    ) {
        List<String> skillList = Arrays.asList(skills.split(","));

        for (String skill : skillList) {
            RoleSkill rs = new RoleSkill();
            rs.setRole(role);
            rs.setSkill(skill.trim());

            roleSkillRepository.save(rs);
        }

        return ResponseEntity.ok("✅ Role learned successfully!");
    }

    // ✅ Personalized analysis (FINAL FIX)
    @PostMapping("/personalized")
    public ResponseEntity<Map<String, Object>> personalizedAnalysis(
            @RequestParam Long userId,
            @RequestParam String currentSkills,
            @RequestParam String targetRole
    ) {
        Map<String, Object> response =
                service.analyzeAndStore(userId, currentSkills, targetRole);

        // ✅ DEBUG LOG (VERY IMPORTANT)
        System.out.println("✅ Controller Response: " + response);

        return ResponseEntity.ok(response);
    }
}
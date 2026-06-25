package com.career.user_service.controller;

import com.career.user_service.repository.RoleSkillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    private final RoleSkillRepository repo;

    public AnalysisController(RoleSkillRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Map<String, Object> analyze(@RequestBody Map<String, Object> input) {

        String currentRole = (String) input.get("currentRole");
        String targetRole = (String) input.get("targetRole");

        List<String> current = repo.findByRoleIgnoreCase(currentRole)
                .stream().map(r -> r.getSkill()).toList();

        List<String> target = repo.findByRoleIgnoreCase(targetRole)
                .stream().map(r -> r.getSkill()).toList();

        List<String> gap = new ArrayList<>(target);
        gap.removeAll(current);

        return Map.of(
                "currentSkills", current,
                "targetSkills", target,
                "gap", gap
        );
    }
}
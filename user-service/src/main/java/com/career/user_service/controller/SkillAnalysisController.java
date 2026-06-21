package com.career.user_service.controller;

import com.career.user_service.service.SkillAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/analysis")
public class SkillAnalysisController {

    private final SkillAnalysisService service;

    public SkillAnalysisController(SkillAnalysisService service) {
        this.service = service;
    }

    @PostMapping
    public Map<String, Object> analyze(
            @RequestParam String currentSkills,
            @RequestParam String targetRole
    ) {
        return service.analyzeSkills(currentSkills, targetRole);
    }
}
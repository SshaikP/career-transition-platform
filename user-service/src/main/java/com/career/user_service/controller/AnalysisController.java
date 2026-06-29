package com.career.user_service.controller;

import com.career.user_service.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/analysis")
@CrossOrigin(origins = "http://localhost:3000")
public class AnalysisController {

    @Autowired
    private AnalysisService service;

    @PostMapping
    public List<Map<String, Object>> analyze(@RequestBody Map<String, Object> request) {

        System.out.println("ANALYSIS API HIT ✅");

        String role = (String) request.get("role");
        Map<String, Integer> skills = (Map<String, Integer>) request.get("skills");

        System.out.println("Role received: " + role);
        System.out.println("Skills received: " + skills);

        return service.analyzeSkills(role, skills);
    }
}
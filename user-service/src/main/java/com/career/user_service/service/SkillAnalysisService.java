package com.career.user_service.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SkillAnalysisService {

    public Map<String, Object> analyzeSkills(String currentSkills, String targetRole) {

        List<String> gaps = new ArrayList<>();
        List<String> learningPlan = new ArrayList<>();

        // ✅ Simple rule-based logic (v1)

        if (targetRole.equalsIgnoreCase("Cloud Engineer")) {

            if (!currentSkills.toLowerCase().contains("aws")) {
                gaps.add("AWS");
                learningPlan.add("Learn AWS fundamentals");
            }

            if (!currentSkills.toLowerCase().contains("docker")) {
                gaps.add("Docker");
                learningPlan.add("Learn Docker and containerization");
            }

            if (!currentSkills.toLowerCase().contains("kubernetes")) {
                gaps.add("Kubernetes");
                learningPlan.add("Learn Kubernetes basics");
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("skillGaps", gaps);
        result.put("learningPlan", learningPlan);

        return result;
    }
}
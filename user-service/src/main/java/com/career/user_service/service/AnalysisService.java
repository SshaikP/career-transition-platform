package com.career.user_service.service;

import com.career.user_service.entity.RoleSkill;
import com.career.user_service.entity.SkillLearningPath;
import com.career.user_service.repository.RoleSkillRepository;
import com.career.user_service.repository.SkillLearningPathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalysisService {

    @Autowired
    private RoleSkillRepository roleRepo;

    @Autowired
    private SkillLearningPathRepository pathRepo;

        public List<Map<String, Object>> analyzeSkills(String role, Map<String, Integer> userSkills) {

        List<RoleSkill> requiredSkills = roleRepo.findByRoleIgnoreCase(role);
        List<Map<String, Object>> result = new ArrayList<>();

        for (RoleSkill skill : requiredSkills) {

            System.out.println("Fetching roadmap for: " + skill.getSkill());

            // ✅ Fetch roadmap INSIDE loop (correct place)
            List<SkillLearningPath> steps =
                    pathRepo.findBySkillOrderByStepOrder(skill.getSkill());

            System.out.println("Steps found: " + steps.size());

            int current = userSkills.getOrDefault(skill.getSkill(), 0);
            int required = skill.getRequiredLevel();
            int gap = Math.max(required - current, 0);

            String priority = gap >= 5 ? "HIGH" : gap >= 3 ? "MEDIUM" : "LOW";

            List<String> freeSteps = new ArrayList<>();
            List<String> premiumSteps = new ArrayList<>();

            for (SkillLearningPath step : steps) {
                if ("FREE".equalsIgnoreCase(step.getType())) {
                    freeSteps.add(step.getStep());
                } else {
                    premiumSteps.add(step.getStep());
                }
                }
                

            Map<String, Object> data = new HashMap<>();
            data.put("skill", skill.getSkill());
            data.put("gap", gap);
            data.put("priority", priority);
            data.put("freePath", freeSteps);
            data.put("premiumPath", premiumSteps);

            result.add(data);
        }

        return result;
    }       
            
}

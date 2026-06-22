package com.career.user_service.service;

import com.career.user_service.entity.RoleSkill;
import com.career.user_service.entity.AnalysisResult;
import com.career.user_service.repository.RoleSkillRepository;
import com.career.user_service.repository.AnalysisResultRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.io.InputStream;
import java.util.*;

@Service
public class SkillAnalysisService {

    private Map<String, List<String>> roleSkills = new HashMap<>();

    private final RoleSkillRepository roleSkillRepository;
    private final AnalysisResultRepository analysisRepository;

    public SkillAnalysisService(RoleSkillRepository roleSkillRepository,
                                AnalysisResultRepository analysisRepository) {
        this.roleSkillRepository = roleSkillRepository;
        this.analysisRepository = analysisRepository;
    }

    // ✅ Load JSON roles
    @PostConstruct
    public void loadSkillsData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream("skills-data.json");

            if (inputStream != null) {
                roleSkills = mapper.readValue(inputStream,
                        new TypeReference<Map<String, List<String>>>() {});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Core analysis
    public Map<String, Object> analyzeSkills(String currentSkills, String targetRole) {

        List<String> gaps = new ArrayList<>();
        List<String> learningPlan = new ArrayList<>();

        String normalizedSkills = currentSkills == null ? "" : currentSkills.toLowerCase();

        List<String> requiredSkills = new ArrayList<>();

        // ✅ DB-driven learning
        List<RoleSkill> dbSkills = roleSkillRepository.findByRoleIgnoreCase(targetRole);

        if (!dbSkills.isEmpty()) {
            requiredSkills = dbSkills.stream()
                    .map(RoleSkill::getSkill)
                    .toList();
        } else if (roleSkills.containsKey(targetRole)) {
            requiredSkills = roleSkills.get(targetRole);
        } else {
            requiredSkills = inferSkills(targetRole);
        }

        for (String skill : requiredSkills) {
            if (!normalizedSkills.contains(skill.toLowerCase())) {
                gaps.add(skill);
                learningPlan.add(generateLearningPlan(skill));
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("skillGaps", gaps);
        result.put("learningPlan", learningPlan);

        return result;
    }

    // ✅ FINAL FIXED METHOD
    public Map<String, Object> analyzeAndStore(Long userId,
                                               String currentSkills,
                                               String targetRole) {

        Map<String, Object> result = analyzeSkills(currentSkills, targetRole);

        // ✅ SAFE extraction
        List<String> gaps = (List<String>) result.getOrDefault("skillGaps", new ArrayList<>());
        List<String> learningPlan = (List<String>) result.getOrDefault("learningPlan", new ArrayList<>());

        List<String> roadmap = generateRoadmap(gaps);

        // ✅ scoring
        List<Map<String, Object>> scored = new ArrayList<>();

        for (String skill : gaps) {
            int score = calculateScore(skill);

            Map<String, Object> entry = new HashMap<>();
            entry.put("skill", skill);
            entry.put("score", score);
            entry.put("priority", getPriority(score));

            scored.add(entry);
        }

        // ✅ DB save (safe)
        try {
            AnalysisResult entity = new AnalysisResult();
            entity.setUserId(userId);
            entity.setTargetRole(targetRole);
            entity.setSkillGaps(String.join(",", gaps));
            entity.setRoadmap(String.join(" | ", roadmap));

            analysisRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace(); // Don't break response
        }

        // ✅ GUARANTEED RESPONSE STRUCTURE
        Map<String, Object> finalResponse = new HashMap<>();
        finalResponse.put("skillGaps", gaps);
        finalResponse.put("learningPlan", learningPlan);
        finalResponse.put("roadmap", roadmap);
        finalResponse.put("scoredGaps", scored);

        return finalResponse;
    }

    // ✅ scoring
    private int calculateScore(String skill) {
        String s = skill.toLowerCase();

        if (s.contains("aws") || s.contains("cloud")) return 90;
        if (s.contains("docker") || s.contains("kubernetes")) return 75;
        if (s.contains("communication")) return 60;

        return 50;
    }

    private String getPriority(int score) {
        if (score >= 80) return "HIGH";
        if (score >= 60) return "MEDIUM";
        return "LOW";
    }

    // ✅ learning plan
    private String generateLearningPlan(String skill) {
        String s = skill.toLowerCase();

        if (s.contains("communication")) {
            return "Practice speaking and presentation skills";
        } else if (s.contains("research")) {
            return "Work on research projects and case studies";
        }

        return "Learn and apply " + skill;
    }

    // ✅ roadmap
    private List<String> generateRoadmap(List<String> gaps) {
        List<String> roadmap = new ArrayList<>();
        int week = 1;

        for (String skill : gaps) {
            roadmap.add("Week " + week + " → Learn " + skill);
            roadmap.add("Week " + (week + 1) + " → Practice " + skill);
            week += 2;
        }

        return roadmap;
    }

    // ✅ fallback
    private List<String> inferSkills(String role) {

        String r = role.toLowerCase();

        if (r.contains("cloud")) return List.of("AWS", "Docker");
        if (r.contains("doctor")) return List.of("Medical Knowledge", "Diagnosis");
        if (r.contains("teacher")) return List.of("Teaching", "Communication");

        return List.of("Communication", "Problem Solving");
    }
}
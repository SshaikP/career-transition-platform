package com.career.user_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "analysis_results")
public class AnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String targetRole;

    @Column(length = 1000)
    private String skillGaps;

    @Column(length = 2000)
    private String roadmap;

    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getTargetRole() { return targetRole; }
    public void setTargetRole(String targetRole) { this.targetRole = targetRole; }

    public String getSkillGaps() { return skillGaps; }
    public void setSkillGaps(String skillGaps) { this.skillGaps = skillGaps; }

    public String getRoadmap() { return roadmap; }
    public void setRoadmap(String roadmap) { this.roadmap = roadmap; }
}
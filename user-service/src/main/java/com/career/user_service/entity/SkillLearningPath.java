package com.career.user_service.entity;

import jakarta.persistence.*;

@Entity
public class SkillLearningPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skill;
    private int stepOrder;
    private String step;
    private String type; // FREE or PREMIUM

    // ✅ GETTERS

    public Long getId() {
        return id;
    }

    public String getSkill() {
        return skill;
    }

    public int getStepOrder() {
        return stepOrder;
    }

    public String getStep() {
        return step;
    }

    public String getType() {
        return type;
    }

    // ✅ SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setStepOrder(int stepOrder) {
        this.stepOrder = stepOrder;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public void setType(String type) {
        this.type = type;
    }
}

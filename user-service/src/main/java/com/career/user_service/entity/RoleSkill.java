package com.career.user_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "role_skills")
public class RoleSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    private String skill;

    // ✅ NEW FIELD
    private int requiredLevel; // 1–10

    public Long getId() { return id; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getSkill() { return skill; }
    public void setSkill(String skill) { this.skill = skill; }

    public int getRequiredLevel() { return requiredLevel; }
    public void setRequiredLevel(int requiredLevel) { this.requiredLevel = requiredLevel; }
}
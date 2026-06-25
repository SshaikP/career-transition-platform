package com.career.user_service.repository;

import com.career.user_service.entity.RoleSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleSkillRepository extends JpaRepository<RoleSkill, Long> {

    List<RoleSkill> findByRole(String role);

    List<RoleSkill> findByRoleIgnoreCase(String role);
}
package com.career.user_service.repository;

import com.career.user_service.entity.SkillLearningPath;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillLearningPathRepository extends JpaRepository<SkillLearningPath, Long> {

    List<SkillLearningPath> findBySkillOrderByStepOrder(String skill);
}
package com.career.user_service.repository;

import com.career.user_service.entity.AnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnalysisResultRepository
        extends JpaRepository<AnalysisResult, Long> {

    List<AnalysisResult> findByUserId(Long userId);
}
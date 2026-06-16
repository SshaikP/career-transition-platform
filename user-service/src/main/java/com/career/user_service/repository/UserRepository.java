package com.career.user_service.repository;

import com.career.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    long countByUserCodeStartingWith(String prefix);

}

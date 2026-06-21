package com.example.userservice.service;

import com.example.userservice.model.UserProfile;
import com.example.userservice.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    private final UserProfileRepository repository;

    public UserProfileService(UserProfileRepository repository) {
        this.repository = repository;
    }

    public UserProfile createProfile(UserProfile profile) {
        return repository.save(profile);
    }

    public List<UserProfile> getProfilesByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
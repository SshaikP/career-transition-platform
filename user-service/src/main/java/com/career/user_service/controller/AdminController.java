package com.career.user_service.controller;

import com.career.user_service.entity.*;
import com.career.user_service.repository.*;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final RoleRepository roleRepo;
    private final RoleSkillRepository roleSkillRepo;
    private final UserRepository userRepo;
    private final SkillLearningPathRepository learningPathRepo;

    public AdminController(RoleRepository roleRepo,
                           RoleSkillRepository roleSkillRepo,
                           UserRepository userRepo,
                           SkillLearningPathRepository learningPathRepo) {
        this.roleRepo = roleRepo;
        this.roleSkillRepo = roleSkillRepo;
        this.userRepo = userRepo;
        this.learningPathRepo = learningPathRepo;
    }

    //////////////////////////////////////////////////////////
    // ✅ USERS
    //////////////////////////////////////////////////////////

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepo.findAll());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return ResponseEntity.ok("User deleted ✅");
    }

    //////////////////////////////////////////////////////////
    // ✅ ROLES
    //////////////////////////////////////////////////////////


        @GetMapping("/roles")
        public ResponseEntity<?> getRoles() {
            List<Role> roles = roleRepo.findAll();
            System.out.println("ROLES SENT TO UI: " + roles); // ✅ DEBUG
            return ResponseEntity.ok(roles);
        }


    @PostMapping("/roles")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleRepo.save(role));
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role updatedRole) {
        return roleRepo.findById(id)
                .map(role -> {
                    role.setName(updatedRole.getName());
                    return ResponseEntity.ok(roleRepo.save(role));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id) {
        roleRepo.deleteById(id);
        return ResponseEntity.ok("Role deleted ✅");
    }

    //////////////////////////////////////////////////////////
    // ✅ SKILLS
    //////////////////////////////////////////////////////////

    @GetMapping("/roleskills")
    public ResponseEntity<List<RoleSkill>> getRoleSkills() {
        return ResponseEntity.ok(roleSkillRepo.findAll());
    }

    @PostMapping("/roleskills")
    public ResponseEntity<RoleSkill> addRoleSkill(@RequestBody RoleSkill roleSkill) {
        return ResponseEntity.ok(roleSkillRepo.save(roleSkill));
    }

    @PutMapping("/roleskills/{id}")
    public ResponseEntity<RoleSkill> updateSkill(@PathVariable Long id, @RequestBody RoleSkill updatedSkill) {
        return roleSkillRepo.findById(id)
                .map(skill -> {
                    skill.setRole(updatedSkill.getRole());
                    skill.setSkill(updatedSkill.getSkill());
                    skill.setRequiredLevel(updatedSkill.getRequiredLevel());
                    return ResponseEntity.ok(roleSkillRepo.save(skill));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/roleskills/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteRoleSkill(@PathVariable Long id) {
        roleSkillRepo.deleteById(id);
        System.out.println("DELETE HIT ✅");
        return ResponseEntity.ok("Skill deleted ✅");
    }

    //////////////////////////////////////////////////////////
    // ✅ ROADMAP
    //////////////////////////////////////////////////////////

    @GetMapping("/learning-path")
    public ResponseEntity<List<SkillLearningPath>> getLearningPaths() {
        return ResponseEntity.ok(learningPathRepo.findAll());
    }

    @PostMapping("/learning-path")
    public ResponseEntity<SkillLearningPath> addStep(@RequestBody SkillLearningPath step) {
        return ResponseEntity.ok(learningPathRepo.save(step));
    }

    @PutMapping("/learning-path/{id}")
    public ResponseEntity<SkillLearningPath> updateStep(@PathVariable Long id,
                                                        @RequestBody SkillLearningPath updatedStep) {
        return learningPathRepo.findById(id)
                .map(step -> {
                    step.setSkill(updatedStep.getSkill());
                    step.setStep(updatedStep.getStep());
                    step.setType(updatedStep.getType());
                    step.setStepOrder(updatedStep.getStepOrder());
                    return ResponseEntity.ok(learningPathRepo.save(step));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/learning-path/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteStep(@PathVariable Long id) {
        learningPathRepo.deleteById(id);
        System.out.println("DELETE HIT ✅");
        return ResponseEntity.ok("Step deleted ✅");
    }
}
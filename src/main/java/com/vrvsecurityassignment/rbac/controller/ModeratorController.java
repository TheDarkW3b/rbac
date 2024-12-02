package com.vrvsecurityassignment.rbac.controller;

import com.vrvsecurityassignment.rbac.dtos.response.ApiResponse;
import com.vrvsecurityassignment.rbac.entity.User;
import com.vrvsecurityassignment.rbac.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/moderator")
public class ModeratorController {
    private final UserRepository userRepository;
    
    @GetMapping
    public ResponseEntity<ApiResponse> viewUsers(Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).orElseThrow();
        return ResponseEntity.ok(new ApiResponse(true, "Access granted: Moderator Area", user.getRole()));
    }
}

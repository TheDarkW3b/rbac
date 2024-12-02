package com.vrvsecurityassignment.rbac.controller;

import com.vrvsecurityassignment.rbac.dtos.request.LoginRequest;
import com.vrvsecurityassignment.rbac.dtos.request.RegisterRequest;
import com.vrvsecurityassignment.rbac.dtos.response.ApiResponse;
import com.vrvsecurityassignment.rbac.entity.User;
import com.vrvsecurityassignment.rbac.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        String token = userService.login(loginRequest);
        return new ResponseEntity<>(
                new ApiResponse(true, "Login successful",
                        Map.of("token", token)), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> response(@RequestBody @Valid RegisterRequest registerRequest) {
        User registeredUser = userService.register(registerRequest);
        return new ResponseEntity<>(
                new ApiResponse(true, "User registered successfully",
                        Map.of("username", registeredUser.getUsername())), HttpStatus.OK);
    }
}

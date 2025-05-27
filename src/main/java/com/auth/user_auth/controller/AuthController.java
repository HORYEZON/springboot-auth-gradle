package com.auth.user_auth.controller;

import com.auth.user_auth.dto.LoginRequest;
import com.auth.user_auth.model.User;
import com.auth.user_auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        User authenticatedUser = userService.authenticateUser(request);
        authenticatedUser.setPassword(null); // Hide password in response
        return ResponseEntity.ok(authenticatedUser);
    }
}

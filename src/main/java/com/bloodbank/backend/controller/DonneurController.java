package com.bloodbank.backend.controller;


import com.bloodbank.backend.model.User;
import com.bloodbank.backend.repository.UserRepository;
import com.bloodbank.backend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/donneurs")
public class DonneurController {

    @Autowired
    private final UserRepository userRepository;

    public DonneurController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(Authentication auth) {
        User user = userRepository.findUserByEmail(auth.getName());
        return ResponseEntity.ok(user);
    }



}

package com.bloodbank.backend.controller;


import com.bloodbank.backend.dto.DonorProfileUpdateDto;
import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.User;
import com.bloodbank.backend.repository.UserRepository;
import com.bloodbank.backend.services.DonorService;
import com.bloodbank.backend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/donneurs")
public class DonneurController {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private DonorService donorService;

    public DonneurController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(Authentication auth) {
        User user = userRepository.findUserByEmail(auth.getName());
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{donorId}/profile")
    public ResponseEntity<Donneur> updateDonorProfile(@PathVariable Long donorId, @RequestBody DonorProfileUpdateDto updateDto){
        Donneur updatedDonor = donorService.updateDonorProfile(donorId, updateDto);
        return ResponseEntity.ok(updatedDonor);
    }

    @GetMapping("/{donorId}/profile")
    public ResponseEntity<Donneur> getDonorProfile(@PathVariable Long donorId) {
        Donneur donor = donorService.getDonorById(donorId);
        return ResponseEntity.ok(donor);
    }




}

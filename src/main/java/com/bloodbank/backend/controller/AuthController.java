package com.bloodbank.backend.controller;

import com.bloodbank.backend.dto.AuthRequest;
import com.bloodbank.backend.dto.AuthResponse;
import com.bloodbank.backend.dto.RegisterDonorDTO;
import com.bloodbank.backend.mappers.DonorMapper;

import com.bloodbank.backend.repository.DonorRepository;
import com.bloodbank.backend.repository.UserRepository;
import com.bloodbank.backend.services.AuthService;
import com.bloodbank.backend.services.JwtService;
import com.bloodbank.backend.services.UserServices;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;



    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerDonor(@RequestBody RegisterDonorDTO dto) {
        AuthResponse authResponse = authService.registerDonor(dto);
        return ResponseEntity.ok(authResponse);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        String jwt = authService.login(request);
        String role = authService.getRoleByEmail(request.getEmail());

        return ResponseEntity.ok(new AuthResponse(jwt, role));
    }
}

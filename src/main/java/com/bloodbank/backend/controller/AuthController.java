package com.bloodbank.backend.controller;

import com.bloodbank.backend.dto.AuthRequest;
import com.bloodbank.backend.dto.AuthResponse;
import com.bloodbank.backend.dto.RegisterDTO;
import com.bloodbank.backend.dto.RegisterDonorDTO;
import com.bloodbank.backend.mappers.DonorMapper;
import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.repository.DonorRepository;
import com.bloodbank.backend.repository.UserRepository;
import com.bloodbank.backend.services.AuthService;
import com.bloodbank.backend.services.JwtService;
import com.bloodbank.backend.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final UserServices userService;
    private final AuthService authService;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final DonorMapper donorMapper;
    private final DonorRepository donorRepository;
    private final PasswordEncoder passwordEncoder;



    public AuthController(UserServices userServices, AuthService authService, JwtService jwtService, UserRepository userRepository, DonorMapper donorMapper, DonorRepository donorRepository, PasswordEncoder passwordEncoder) {
        this.userService = userServices;
        this.authService = authService;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.donorMapper = donorMapper;
        this.donorRepository = donorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
        return userService.register(registerDTO);
    }

    @PostMapping("/register/donor")
    public ResponseEntity<String> registerDonor(@RequestBody RegisterDonorDTO dto) {
        try {
            authService.registerDonor(dto);
            return ResponseEntity.ok("Donneur enregistré avec succès !");
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }





    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        String jwt = authService.login(request);
        String role = authService.getRoleByEmail(request.getEmail());

        return ResponseEntity.ok(new AuthResponse(jwt, role));
    }
}

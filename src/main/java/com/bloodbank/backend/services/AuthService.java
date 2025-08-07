package com.bloodbank.backend.services;


import com.bloodbank.backend.dto.AuthRequest;
import com.bloodbank.backend.dto.AuthResponse;
import com.bloodbank.backend.dto.RegisterDonorDTO;
import com.bloodbank.backend.mappers.DonorMapper;
import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.Role;
import com.bloodbank.backend.model.User;
import com.bloodbank.backend.repository.DonorRepository;
import com.bloodbank.backend.repository.UserRepository;
import com.bloodbank.backend.security.CustomUserDetails;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {


    private final AuthenticationProvider authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final DonorRepository donorRepository;


    public AuthService(AuthenticationProvider authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, UserDetailsService userDetailsService, DonorRepository donorRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.donorRepository = donorRepository;
    }

    public String login(AuthRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        if (!passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities().iterator().next().getAuthority());

        return jwtService.generateToken(claims, userDetails);
    }

    public AuthResponse registerDonor(RegisterDonorDTO dto) {
        Donneur donneur = DonorMapper.toEntity(dto);
        donneur.setPassword(passwordEncoder.encode(dto.password()));
        donneur.setRole(Role.DONOR);
        donorRepository.save(donneur);

        CustomUserDetails userDetails = new CustomUserDetails(donneur);

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", donneur.getRole().name());

        String jwt = jwtService.generateToken(extraClaims, userDetails);

        return new AuthResponse(jwt, donneur.getRole().name());

    }

    public String getRoleByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return user.getRole().name();
    }

}

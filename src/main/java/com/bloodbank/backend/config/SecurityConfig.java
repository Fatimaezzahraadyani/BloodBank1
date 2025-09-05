package com.bloodbank.backend.config;


import com.bloodbank.backend.repository.AdminRepository;
import com.bloodbank.backend.repository.DonorRepository;



import com.bloodbank.backend.security.CustomUserDetailService;
import com.bloodbank.backend.services.JwtService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) throws Exception {
        http

                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // Désactivation CSRF car l'application est une API REST stateless sécurisée par JWT
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/auth/register/donor").permitAll()
                        //requestMatchers("/api/rendezVous/{id}").permitAll()
                        //.requestMatchers("/api/rendezVous/all").permitAll()
                        //.requestMatchers("/api/CentresCollecte/addCenter").permitAll()
                        //.requestMatchers("/user/register").permitAll()
                        //.requestMatchers("/user/login").permitAll()
                        //.requestMatchers("/api/admin/**").permitAll()
                        //.requestMatchers("/api/donor/**").hasRole("DONOR")
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public UserDetailsService userDetailsService(
            AdminRepository adminRepository,
            DonorRepository donorRepository
    ) {
        return new CustomUserDetailService(adminRepository, donorRepository);
    }

    @Bean
    public JwtAuthFilter jwtAuthFilter(UserDetailsService userDetailsService, JwtService jwtService) {
        return new JwtAuthFilter(userDetailsService, jwtService);
    }
}

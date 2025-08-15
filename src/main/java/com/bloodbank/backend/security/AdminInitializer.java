package com.bloodbank.backend.security;


import com.bloodbank.backend.model.Admin;
import com.bloodbank.backend.model.Role;
import com.bloodbank.backend.model.User;
import com.bloodbank.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {
    @Bean
    CommandLineRunner createAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByEmail("Tima1234@gmail.com").isEmpty()) {
                Admin admin = new Admin();
                admin.setFirstName("Admin");
                admin.setLastName("Dyn");
                admin.setEmail("Tima1234@gmail.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole(Role.ADMIN);

                userRepository.save(admin);
                System.out.println("✅ Admin user created: Tima1234@gmail.com / admin123");
            } else {
                System.out.println("ℹ️ Admin user already exists");
            }
        };
    }
}

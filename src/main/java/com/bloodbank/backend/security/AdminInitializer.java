package com.bloodbank.backend.security;


import com.bloodbank.backend.model.Admin;
import com.bloodbank.backend.model.Role;
import com.bloodbank.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    CommandLineRunner createAdmin(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            @Value("${admin.email}") String adminEmail,     // ⚠️ INJECTION DIRECTE dans le paramètre
            @Value("${admin.password}") String adminPassword // ⚠️ INJECTION DIRECTE dans le paramètre
    ) {
        return args -> {
            if (userRepository.findByEmail(adminEmail).isEmpty()) {
                Admin admin = new Admin();
                admin.setFirstName("Admin");
                admin.setLastName("Dyn");
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                admin.setRole(Role.ADMIN);

                userRepository.save(admin);
                System.out.println("✅ Admin user created:" + adminEmail);
            } else {
                System.out.println("ℹ️ Admin user already exists");
            }
        };
    }
}

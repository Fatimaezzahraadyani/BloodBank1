package com.bloodbank.backend.security;

import com.bloodbank.backend.model.User;
import com.bloodbank.backend.repository.AdminRepository;
import com.bloodbank.backend.repository.DonorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailService.class);
    private final AdminRepository adminRepository;
    private final DonorRepository donorRepository;

    public CustomUserDetailService(AdminRepository adminRepository, DonorRepository donorRepository) {
        this.adminRepository = adminRepository;
        this.donorRepository = donorRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = adminRepository.findByEmail(email).orElse(null);

        if (user == null) {
            user = donorRepository.findByEmail(email).orElse(null);
        }

        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email);
        }

       log.info("ROLE from DB: " + user.getRole());

        return new CustomUserDetails(user);
    }
}
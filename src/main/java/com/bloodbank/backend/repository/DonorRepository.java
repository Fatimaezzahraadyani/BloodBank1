package com.bloodbank.backend.repository;

import com.bloodbank.backend.model.Donneur;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<Donneur, Long> {

    Optional<Donneur> findByEmail(String email);

    boolean existsByEmail(String email);
}

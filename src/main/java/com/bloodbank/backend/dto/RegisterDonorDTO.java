package com.bloodbank.backend.dto;

import jakarta.validation.constraints.Email;

import java.time.LocalDate;

public record RegisterDonorDTO (
        String firstName,
        String lastName,
        String email,
        String password,
        String address,
        LocalDate birthdate,
        String bloodType,
        String phone,
        Double weight,
        String maladieHistory,
        String maladiesChroniques,
        boolean chirurgiesRecentes,
        boolean priseDeMedicaments

) {

}

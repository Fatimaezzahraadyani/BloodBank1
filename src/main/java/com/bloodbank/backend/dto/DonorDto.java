package com.bloodbank.backend.dto;

import java.time.LocalDate;

public record DonorDto (
        String firstName,
        String lastName,
        String email,
        String phone,
        String address,
        String bloodType,
        double weight,
        String maladieHistory,
        String maladiesChroniques,
        boolean priseDeMedicaments,
        boolean chirurgiesRecentes,
        LocalDate birthdate
) {
}

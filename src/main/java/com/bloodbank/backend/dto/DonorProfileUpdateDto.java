package com.bloodbank.backend.dto;

import java.time.LocalDate;

public record DonorProfileUpdateDto(
         String bloodType,
         LocalDate birthdate,
         Double weight,
         String maladieHistory,
         String phone,
         String address,
         String maladiesChroniques,
         Boolean priseDeMedicaments,
         Boolean chirurgiesRecentes
) {
}

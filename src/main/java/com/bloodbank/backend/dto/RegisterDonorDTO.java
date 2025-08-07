package com.bloodbank.backend.dto;


public record RegisterDonorDTO (
        String firstName,
        String lastName,
        String email,
        String password
) {

}

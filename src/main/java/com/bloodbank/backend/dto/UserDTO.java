package com.bloodbank.backend.dto;

public record UserDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String role

) {
}

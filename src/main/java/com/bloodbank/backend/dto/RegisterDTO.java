package com.bloodbank.backend.dto;

import com.bloodbank.backend.model.Role;
import com.bloodbank.backend.validation.UniqueEmail;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record RegisterDTO(

        @JsonProperty("firstname")
        @NotBlank(message = "firstname is required")
        String firstName,

        @JsonProperty("lastname")
        @NotBlank(message = "lastName is required")
        String lastName,

        @JsonProperty("email")
        @NotBlank(message = "email is required")
        @Email(message = "please enter a valid email")
        @UniqueEmail
        String email,

        @JsonProperty("password")
        @NotBlank(message = "password is required")
        @Size(min = 6, message = "password must be at least 6 chars")
        String password,


        @NotNull(message = "role is required")
        Role role
) {
}

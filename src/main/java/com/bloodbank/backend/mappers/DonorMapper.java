package com.bloodbank.backend.mappers;


import com.bloodbank.backend.dto.RegisterDonorDTO;
import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DonorMapper {

    public static Donneur toEntity(RegisterDonorDTO dto) {
        Donneur d = new Donneur();
        d.setFirstName(dto.firstName());
        d.setLastName(dto.lastName());
        d.setEmail(dto.email());
        d.setPassword(dto.password());
        d.setDateSoumission(LocalDate.now());

        d.setRole(Role.DONOR);
        return d;
    }
}

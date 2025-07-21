package com.bloodbank.backend.mappers;


import com.bloodbank.backend.dto.RegisterDonorDTO;
import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DonorMapper {

    public static Donneur toEntity(RegisterDonorDTO dto, PasswordEncoder encoder) {
        Donneur d = new Donneur();
        d.setFirstName(dto.firstName());
        d.setLastName(dto.lastName());
        d.setEmail(dto.email());
        d.setPassword(encoder.encode(dto.password()));
        d.setAddress(dto.address());
        d.setBirthdate(dto.birthdate());
        d.setBloodType(dto.bloodType());
        d.setPhone(dto.phone());
        d.setWeight(dto.weight());
        d.setMaladieHistory(dto.maladieHistory());
        d.setMaladiesChroniques(dto.maladiesChroniques());
        d.setChirurgiesRecentes(dto.chirurgiesRecentes());
        d.setPriseDeMedicaments(dto.priseDeMedicaments());
        d.setDateSoumission(LocalDate.now());
        d.setRole(Role.DONOR);
        return d;
    }
}

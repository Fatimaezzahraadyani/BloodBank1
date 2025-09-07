package com.bloodbank.backend.services;

import com.bloodbank.backend.dto.DonorProfileUpdateDto;
import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.User;
import com.bloodbank.backend.repository.DonorRepository;
import com.bloodbank.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DonorService {

    private final DonorRepository donorRepository;
    private final UserRepository userRepository;

    public DonorService(DonorRepository donorRepository, UserRepository userRepository) {
        this.donorRepository = donorRepository;
        this.userRepository = userRepository;
    }

    public Optional<Donneur> getDonneurByEmail(String email){
        return donorRepository.findByEmail(email);
    }

    public Donneur updateDonor(Donneur donneur){
        return donorRepository.save(donneur);
    }

    @Transactional // Assurez-vous que cette opération est atomique
    public Donneur updateDonorProfile(Long donorId, DonorProfileUpdateDto updateDto) {
        Donneur donor = donorRepository.findById(donorId)
                .orElseThrow(() -> new IllegalArgumentException("Donor not found with id: " + donorId));

        // Mapper les champs du DTO vers l'entité User, en gérant les valeurs null
        if (updateDto.getBloodType() != null) {
            donor.setBloodType(updateDto.getBloodType());
        }
        // Pour les champs String, assurez-vous qu'ils ne sont pas vides après mapping
        if (updateDto.getPhone() != null && !updateDto.getPhone().isEmpty()) {
            donor.setPhone(updateDto.getPhone());
        }
        if (updateDto.getMaladieHistory() != null && !updateDto.getMaladieHistory().isEmpty()) {
            donor.setMaladieHistory(updateDto.getMaladieHistory());
        }

        if (updateDto.getAddress() != null && !updateDto.getAddress().isEmpty()) {
            donor.setAddress(updateDto.getAddress());
        }
        if (updateDto.getChirurgiesRecentes() != null) {
            donor.setChirurgiesRecentes(updateDto.getChirurgiesRecentes());
        }
        if (updateDto.getMaladiesChroniques() != null) {
            donor.setMaladiesChroniques(updateDto.getMaladiesChroniques());
        }


        if (updateDto.getAddress() != null && !updateDto.getAddress().isEmpty()) {
            donor.setAddress(updateDto.getAddress());
        }

        // Les booléens et les nombres doivent être vérifiés différemment
        if (updateDto.getWeight() != null) {
            donor.setWeight(updateDto.getWeight());
        }
        if (updateDto.getPriseDeMedicaments() != null) {
            donor.setPriseDeMedicaments(updateDto.getPriseDeMedicaments());
        }

        // Note: La date de naissance (LocalDate) nécessite une conversion correcte côté frontend/backend.
        if (updateDto.getBirthdate() != null) {
            donor.setBirthdate(updateDto.getBirthdate());
        }

        // Sauvegardez l'entité mise à jour
        return userRepository.save(donor);
    }

    public Donneur getDonorById(Long donorId) {
        return donorRepository.findById(donorId)
                .orElseThrow(() -> new IllegalArgumentException("Donor not found with id: " + donorId));
    }

}

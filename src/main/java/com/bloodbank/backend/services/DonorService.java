package com.bloodbank.backend.services;

import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.repository.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DonorService {

    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    public Optional<Donneur> getDonneurByEmail(String email){
        return donorRepository.findByEmail(email);
    }

    public Donneur updateDonor(Donneur donneur){
        return donorRepository.save(donneur);
    }


}

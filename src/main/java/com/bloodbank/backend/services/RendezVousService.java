package com.bloodbank.backend.services;


import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.RendezVous;
import com.bloodbank.backend.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousService {

    private final RendezVousRepository rendezVousRepository;


    public RendezVousService(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    public RendezVous create(RendezVous rendezVous){
        return rendezVousRepository.save(rendezVous);
    }

    public List<RendezVous> getByDonneur(Donneur donneur){
        return rendezVousRepository.findByDonneur(donneur);
    }


}

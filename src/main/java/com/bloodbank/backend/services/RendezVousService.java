package com.bloodbank.backend.services;


import com.bloodbank.backend.model.CentreCollecte;
import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.RendezVous;
import com.bloodbank.backend.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<RendezVous> getByCenter(CentreCollecte centreCollecte){
        return rendezVousRepository.findByCentreCollecte(centreCollecte);
    }

    public RendezVous updateReservation(Long id ,RendezVous rendezVous){
        rendezVous.setId(id);
        return rendezVousRepository.save(rendezVous);
    }


    public List<RendezVous> findAll() {
        return rendezVousRepository.findAll();
    }

    public Optional<RendezVous> findById(Long id) {
        return rendezVousRepository.findById(id);
    }
}

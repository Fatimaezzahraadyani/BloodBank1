package com.bloodbank.backend.services;

import com.bloodbank.backend.model.CentreCollecte;
import com.bloodbank.backend.repository.CentreCollecteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentreCollecteService {


    private final  CentreCollecteRepository centreCollecteRepository;

    public CentreCollecteService(CentreCollecteRepository centreCollecteRepository) {
        this.centreCollecteRepository = centreCollecteRepository;
    }

    public List<CentreCollecte> getAllCentresCollecte() {
        return centreCollecteRepository.findAll();
    }


    public Optional<CentreCollecte> getCentreCollecteById(Long id) {
        return centreCollecteRepository.findById(id);
    }

    public CentreCollecte create(CentreCollecte centreCollecte) {
        return centreCollecteRepository.save(centreCollecte);
    }

    public CentreCollecte update(CentreCollecte centreCollecte, Long id) {
        centreCollecte.setId(id);
        return centreCollecteRepository.save(centreCollecte);
    }

    public void delete(Long id) {
        centreCollecteRepository.deleteById(id);
    }

}

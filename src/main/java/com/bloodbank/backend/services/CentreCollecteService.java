package com.bloodbank.backend.services;

import com.bloodbank.backend.model.CentreCollecte;
import com.bloodbank.backend.repository.CentreCollecteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentreCollecteService {


    @Autowired
    private CentreCollecteRepository centreCollecteRepository;

    public List<CentreCollecte> getCentreCollecteRepository() {
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

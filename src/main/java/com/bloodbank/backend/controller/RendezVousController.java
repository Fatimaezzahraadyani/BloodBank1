package com.bloodbank.backend.controller;


import com.bloodbank.backend.model.RendezVous;
import com.bloodbank.backend.repository.CentreCollecteRepository;
import com.bloodbank.backend.repository.DonorRepository;
import com.bloodbank.backend.repository.RendezVousRepository;
import com.bloodbank.backend.services.RendezVousService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rendezVous")
public class RendezVousController {

    private final RendezVousService rendezVousService;
    private final DonorRepository donorRepository;
    private final CentreCollecteRepository centreCollecteRepository;

    public RendezVousController(RendezVousService rendezVousService, DonorRepository donorRepository, CentreCollecteRepository centreCollecteRepository) {
        this.rendezVousService = rendezVousService;
        this.donorRepository = donorRepository;
        this.centreCollecteRepository = centreCollecteRepository;
    }

    @PostMapping
    public ResponseEntity<RendezVous> creat(@RequestBody RendezVous rendezVous){
        return ResponseEntity.ok(rendezVousService.create(rendezVous));
    }



}

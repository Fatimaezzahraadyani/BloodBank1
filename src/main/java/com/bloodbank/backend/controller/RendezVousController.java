package com.bloodbank.backend.controller;


import com.bloodbank.backend.model.CentreCollecte;
import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.RendezVous;
import com.bloodbank.backend.repository.CentreCollecteRepository;
import com.bloodbank.backend.repository.DonorRepository;
import com.bloodbank.backend.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<RendezVous>> getAllRendezVous() {
        return ResponseEntity.ok(rendezVousService.findAll());
    }

    @PreAuthorize("hasAuthority('ROLE_DONOR')")
    @PostMapping
    public ResponseEntity<RendezVous> creat(@RequestBody RendezVous rendezVous){
        return ResponseEntity.ok(rendezVousService.create(rendezVous));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<RendezVous> getById(@PathVariable Long id) {
        return ResponseEntity.of(rendezVousService.findById(id));
    }


    @GetMapping("/donneur/{donneurId}")
    public ResponseEntity<List<RendezVous>> getByDonneur(@PathVariable Long donneurId){
        Donneur donneur = donorRepository.findById(donneurId).orElseThrow();
        return ResponseEntity.ok(rendezVousService.getByDonneur(donneur));
    }

    @GetMapping("/centre/{centreId}")
    public ResponseEntity<List<RendezVous>> getByCenter(@PathVariable Long centreId){
        CentreCollecte centreCollecte = centreCollecteRepository.findById(centreId).orElseThrow();
        return ResponseEntity.ok(rendezVousService.getByCenter(centreCollecte));
    }

    @PutMapping("/updateReservation/{id}")
    public ResponseEntity<RendezVous> update(@PathVariable Long id, @RequestBody RendezVous rendezVous){
        return ResponseEntity.ok(rendezVousService.updateReservation(id,rendezVous));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        rendezVousService.delete(id);
    }





}

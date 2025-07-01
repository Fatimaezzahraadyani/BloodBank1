package com.bloodbank.backend.controller;

import com.bloodbank.backend.model.CentreCollecte;
import com.bloodbank.backend.services.CentreCollecteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CentresCollecte")
public class CentreCollecteController {

    @Autowired
    private CentreCollecteService centreCollecteService;

    @GetMapping("/{id}")
    public ResponseEntity<CentreCollecte> getById(@PathVariable Long id) {
        return centreCollecteService.getCentreCollecteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public List<CentreCollecte> getAll() {
        return centreCollecteService.getCentreCollecteRepository();
    }

    @PostMapping
    private CentreCollecte createCentreCollecte(@RequestBody CentreCollecte centreCollecte) {
        return centreCollecteService.create(centreCollecte);
    }

    @PutMapping("/{id}")
    public CentreCollecte updateCentreCollecte(@RequestBody CentreCollecte centreCollecte, @PathVariable Long id) {
        return centreCollecteService.update(centreCollecte, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCentreCollecte(@PathVariable Long id) {
        centreCollecteService.delete(id);
    }
}

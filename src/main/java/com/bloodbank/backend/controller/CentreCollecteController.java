package com.bloodbank.backend.controller;

import com.bloodbank.backend.model.CentreCollecte;
import com.bloodbank.backend.services.CentreCollecteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CentresCollecte")
public class CentreCollecteController {


    private final CentreCollecteService centreCollecteService;

    public CentreCollecteController(CentreCollecteService centreCollecteService) {
        this.centreCollecteService = centreCollecteService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<CentreCollecte> getById(@PathVariable Long id) {
        return centreCollecteService.getCentreCollecteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CentreCollecte> getAll() {
        return centreCollecteService.getAllCentresCollecte();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addCenter")
    public ResponseEntity<CentreCollecte> createCentreCollecte(@RequestBody CentreCollecte centreCollecte) {
        return ResponseEntity.ok(centreCollecteService.create(centreCollecte));
    }

   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @PostMapping("/addCenter")
//    private CentreCollecte createCentreCollecte(@RequestBody CentreCollecte centreCollecte) {
//        return centreCollecteService.createCenter(centreCollecte);
//    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public CentreCollecte updateCentreCollecte(@RequestBody CentreCollecte centreCollecte, @PathVariable Long id) {
        return centreCollecteService.update(centreCollecte, id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteCentreCollecte(@PathVariable Long id) {
        centreCollecteService.delete(id);
    }
}

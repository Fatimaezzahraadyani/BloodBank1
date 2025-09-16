package com.bloodbank.backend.Service;


import com.bloodbank.backend.model.CentreCollecte;
import com.bloodbank.backend.repository.CentreCollecteRepository;
import com.bloodbank.backend.services.CentreCollecteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest

public class CentreServiceTest {

    private CentreCollecteService centreCollecteService;

    @Autowired
    private CentreCollecteRepository centreCollecteRepository;

    @BeforeEach
    void setUp(){
        centreCollecteService = new CentreCollecteService(centreCollecteRepository);
    }

    @Test
    void testCreateCentreCollecte(){
        CentreCollecte centreCollecte = new CentreCollecte();
        centreCollecte.setName("ezzouhour");
        centreCollecte.setAdresse("avenue Mohammed 6");
        centreCollecte.setVille("Rabat");

        CentreCollecte saved = centreCollecteService.create(centreCollecte);

        saved.getId();
        assertEquals("ezzouhour", saved.getName());

    }

    @Test
    void testGetAllCentersCollecte(){
        CentreCollecte centre = new CentreCollecte();
        centre.setName("center hjvjhf");
        centre.setAdresse("Bvd Mohammed 5");
        centre.setVille("new city");

        centreCollecteRepository.save(centre);

        List<CentreCollecte>Centres  = centreCollecteService.getAllCentresCollecte();
        assertNotNull(Centres);
        assertTrue(Centres.size() > 0);
    }

    @Test
    void testGetCentreById() {
        CentreCollecte centre = new CentreCollecte();
        centre.setName("Centre Hassan 1");
        centre.setAdresse("Avenuè Royal");
        centre.setVille("abcde");

        CentreCollecte saved = centreCollecteRepository.save(centre);

        CentreCollecte found = centreCollecteService
                .getCentreCollecteById(saved.getId())
                .orElseThrow(() -> new AssertionError("Centre introuvable"));

        assertEquals("Centre Hassan 1", found.getName());
    }


    @Test
    void testUpdateCentreCollecte() {
        //Créer un centre initial
        CentreCollecte centre = new CentreCollecte();
        centre.setName("Centre Hassan P");
        centre.setAdresse("Avenu Royale");
        centre.setVille("mmm");

        CentreCollecte saved = centreCollecteRepository.save(centre);

        //Modifier les champs
        saved.setName("Centre Mohammed V");
        saved.setAdresse("Boulevard Hassan P");

        //Appeler la méthode update
        CentreCollecte updated = centreCollecteService.update(saved, saved.getId());

        //Vérifications
        assertNotNull(updated);
        assertEquals(saved.getId(), updated.getId()); //  le même ID
        assertEquals("Centre Mohammed V", updated.getName()); // Nouveau nom
        assertEquals("Boulevard Hassan P", updated.getAdresse()); // Nouvelle adresse
        assertEquals("mmm", updated.getVille()); // Ville n'a pas changé
    }

    @Test
    void testDeleteCentreCollecte(){
        //Créer un centre initial
        CentreCollecte centre = new CentreCollecte();
        centre.setName("Centre sang");
        centre.setAdresse("Avenue Royale");
        centre.setVille("hhhh");

        CentreCollecte saved = centreCollecteRepository.save(centre);

        //verifier la creation
        assertNotNull(centreCollecteRepository.findById(saved.getId()).orElse(null));

        //supprimer
        centreCollecteService.delete(saved.getId());

        //verifier le suppression
        Optional<CentreCollecte> deleted = centreCollecteRepository.findById(saved.getId());
        assertTrue(deleted.isEmpty(), "Le centre supprimer");

    }





}

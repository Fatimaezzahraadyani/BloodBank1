package com.bloodbank.backend.Service;


import com.bloodbank.backend.model.CentreCollecte;
import com.bloodbank.backend.repository.CentreCollecteRepository;
import com.bloodbank.backend.services.CentreCollecteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
        centreCollecte.setName("Centre moulay rchid");
        centreCollecte.setAdresse("bvd abcd");
        centreCollecte.setVille("ogiugzuief");

        CentreCollecte saved = centreCollecteService.create(centreCollecte);

        assertNotNull(saved.getId());
        assertEquals("Centre moulay rchid", saved.getName());

    }

    @Test
    void testGetAllCentersCollecte(){
        CentreCollecte centre = new CentreCollecte();
        centre.setName("center de dons");
        centre.setAdresse("Bvd Mohammed 6");
        centre.setVille("Beni Mellal");

        centreCollecteRepository.save(centre);

        List<CentreCollecte>Centres  = centreCollecteService.getAllCentresCollecte();
        assertNotNull(Centres);
        assertTrue(Centres.size() > 0);
    }

    @Test
    void testGetCentreById() {
        CentreCollecte centre = new CentreCollecte();
        centre.setName("Centre Hassan II");
        centre.setAdresse("Avenue Royale");
        centre.setVille("Casablanca");

        CentreCollecte saved = centreCollecteRepository.save(centre);

        CentreCollecte found = centreCollecteService
                .getCentreCollecteById(saved.getId())
                .orElseThrow(() -> new AssertionError("Centre introuvable"));

        assertEquals("Centre Hassan II", found.getName());
    }


    @Test
    void testUpdateCentreCollecte() {
        //Créer un centre initial
        CentreCollecte centre = new CentreCollecte();
        centre.setName("Centre Hassan II");
        centre.setAdresse("Avenue Royale");
        centre.setVille("is");

        CentreCollecte saved = centreCollecteRepository.save(centre);

        //Modifier les champs
        saved.setName("Centre Mohammed V");
        saved.setAdresse("Boulevard Hassan II");

        //Appeler la méthode update
        CentreCollecte updated = centreCollecteService.update(saved, saved.getId());

        //Vérifications
        assertNotNull(updated);
        assertEquals(saved.getId(), updated.getId()); //  le même ID
        assertEquals("Centre Mohammed V", updated.getName()); // Nouveau nom
        assertEquals("Boulevard Hassan II", updated.getAdresse()); // Nouvelle adresse
        assertEquals("is", updated.getVille()); // Ville n'a pas changé
    }

    @Test
    void testDeleteCentreCollecte(){
        //Créer un centre initial
        CentreCollecte centre = new CentreCollecte();
        centre.setName("Centre Hassan II");
        centre.setAdresse("Avenue Royale");
        centre.setVille("aa");

        CentreCollecte saved = centreCollecteRepository.save(centre);

        //verrifier la creation
        assertNotNull(centreCollecteRepository.findById(saved.getId()).orElse(null));

        //supprimer
        centreCollecteService.delete(saved.getId());

        //verifier le suppression
        Optional<CentreCollecte> deleted = centreCollecteRepository.findById(saved.getId());
        assertTrue(deleted.isEmpty(), "Le centre supprimer");

    }





}

package com.bloodbank.backend.repository;

import com.bloodbank.backend.model.CentreCollecte;
import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {


    List<RendezVous> findByDonneur(Donneur donneur);

    List<RendezVous> findByCentreCollecte(CentreCollecte centreCollecte);


}

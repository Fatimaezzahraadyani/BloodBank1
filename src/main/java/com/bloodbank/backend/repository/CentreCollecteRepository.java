package com.bloodbank.backend.repository;

import com.bloodbank.backend.model.CentreCollecte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreCollecteRepository extends JpaRepository<CentreCollecte, Long> {

}

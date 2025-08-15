package com.bloodbank.backend.repository;

import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

}

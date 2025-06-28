package com.bloodbank.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "RendezVous")
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private LocalDate date;
    private String heure;

    @ManyToOne
    private Donneur donneur;

    @ManyToOne
    private CentreCollecte centreCollecte;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Donneur getDonneur() {
        return donneur;
    }

    public void setDonneur(Donneur donneur) {
        this.donneur = donneur;
    }

    public CentreCollecte getCentreCollecte() {
        return centreCollecte;
    }

    public void setCentreCollecte(CentreCollecte centreCollecte) {
        this.centreCollecte = centreCollecte;
    }
}

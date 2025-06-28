package com.bloodbank.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Dons")
public class Don {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donId;

    private LocalDate dateDon;
    private double volume;
    private boolean valide;

    @ManyToOne
    private Donneur donneur;

    @ManyToOne
    private CentreCollecte centreCollecte;

    public Long getDonId() {
        return donId;
    }

    public void setDonId(Long donId) {
        this.donId = donId;
    }

    public LocalDate getDateDon() {
        return dateDon;
    }

    public void setDateDon(LocalDate dateDon) {
        this.dateDon = dateDon;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
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

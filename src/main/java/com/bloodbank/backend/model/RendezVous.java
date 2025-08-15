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
    @JoinColumn(name = "donneur_id", nullable = false)
    private Donneur donneur;

    @ManyToOne
    @JoinColumn(name = "centre_collecte_id", nullable = false)
    private CentreCollecte centreCollecte;

    @Enumerated(EnumType.STRING)
    private Statut statut = Statut.en_attente;

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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
}

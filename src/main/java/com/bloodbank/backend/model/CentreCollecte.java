package com.bloodbank.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CentreCollecte")
public class CentreCollecte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "ville", nullable = false)
    private String ville;

    public CentreCollecte() {
    }

    public CentreCollecte(long id, String name, String adresse, String ville) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.ville = ville;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}

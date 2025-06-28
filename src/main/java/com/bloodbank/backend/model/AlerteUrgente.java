package com.bloodbank.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "AlertesUrgentes")
public class AlerteUrgente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long alerteId;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "groupeSanguinRequis", nullable = false)
    private String groupeSanguinRequis;

    @Column(name = "datePublication", nullable = false)
    private LocalDate datePublication;

    @ManyToOne
    private CentreCollecte centre;

    public Long getAlerteId() {
        return alerteId;
    }

    public void setAlerteId(Long alerteId) {
        this.alerteId = alerteId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGroupeSanguinRequis() {
        return groupeSanguinRequis;
    }

    public void setGroupeSanguinRequis(String groupeSanguinRequis) {
        this.groupeSanguinRequis = groupeSanguinRequis;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public CentreCollecte getCentre() {
        return centre;
    }

    public void setCentre(CentreCollecte centre) {
        this.centre = centre;
    }
}

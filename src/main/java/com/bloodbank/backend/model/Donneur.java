package com.bloodbank.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity
@Table (name = "Donneurs")
public class Donneur extends User {

    @Column(name = "bloodType", nullable = true)
    private String bloodType;

    @Column(name = "birthdate", nullable = true)
    private LocalDate birthdate;

    @Column(name = "weight", nullable = true)
    private  Double weight;

    @Column(name = "maladieHistory", nullable = true)
    private String maladieHistory;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "dateSoumission", nullable = true)
    private LocalDate dateSoumission;

    @Column(name = "maladiesChroniques", nullable = true)
    private String maladiesChroniques;

    @Column(name = "priseDeMedicaments", nullable = true)
    private Boolean priseDeMedicaments;

    @Column(name = "chirurgiesRecentes", nullable = true)
    private Boolean chirurgiesRecentes;

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMaladieHistory() {
        return maladieHistory;
    }

    public void setMaladieHistory(String maladieHistory) {
        this.maladieHistory = maladieHistory;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(LocalDate dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public String getMaladiesChroniques() {
        return maladiesChroniques;
    }

    public void setMaladiesChroniques(String maladiesChroniques) {
        this.maladiesChroniques = maladiesChroniques;
    }

    public Boolean isPriseDeMedicaments() {
        return priseDeMedicaments;
    }

    public void setPriseDeMedicaments(boolean priseDeMedicaments) {
        this.priseDeMedicaments = priseDeMedicaments;
    }

    public Boolean isChirurgiesRecentes() {
        return chirurgiesRecentes;
    }

    public void setChirurgiesRecentes(boolean chirurgiesRecentes) {
        this.chirurgiesRecentes = chirurgiesRecentes;
    }
}

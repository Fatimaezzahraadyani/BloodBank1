package com.bloodbank.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table (name = "Donneurs")
public class Donneur extends User {

    @Column(name = "bloodType", nullable = false)
    private String bloodType;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "maladieHistory", nullable = false)
    private String maladieHistory;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "dateSoumission", nullable = false)
    private LocalDate dateSoumission;

    @Column(name = "maladiesChroniques", nullable = false)
    private String maladiesChroniques;

    @Column(name = "priseDeMedicaments", nullable = false)
    private boolean priseDeMedicaments;

    @Column(name = "chirurgiesRecentes", nullable = false)
    private boolean chirurgiesRecentes;

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

    public double getWeight() {
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

    public boolean isPriseDeMedicaments() {
        return priseDeMedicaments;
    }

    public void setPriseDeMedicaments(boolean priseDeMedicaments) {
        this.priseDeMedicaments = priseDeMedicaments;
    }

    public boolean isChirurgiesRecentes() {
        return chirurgiesRecentes;
    }

    public void setChirurgiesRecentes(boolean chirurgiesRecentes) {
        this.chirurgiesRecentes = chirurgiesRecentes;
    }
}

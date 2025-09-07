package com.bloodbank.backend.dto;

import java.time.LocalDate;

public class DonorProfileUpdateDto {
    private String bloodType;
    private LocalDate birthdate;
    private Double weight;
    private String maladieHistory;
    private String phone;
    private String address;
    private String maladiesChroniques;
    private Boolean priseDeMedicaments;
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

    public void setWeight(Double weight) {
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

    public String getMaladiesChroniques() {
        return maladiesChroniques;
    }

    public void setMaladiesChroniques(String maladiesChroniques) {
        this.maladiesChroniques = maladiesChroniques;
    }

    public Boolean getPriseDeMedicaments() {
        return priseDeMedicaments;
    }

    public void setPriseDeMedicaments(Boolean priseDeMedicaments) {
        this.priseDeMedicaments = priseDeMedicaments;
    }

    public Boolean getChirurgiesRecentes() {
        return chirurgiesRecentes;
    }

    public void setChirurgiesRecentes(Boolean chirurgiesRecentes) {
        this.chirurgiesRecentes = chirurgiesRecentes;
    }
}

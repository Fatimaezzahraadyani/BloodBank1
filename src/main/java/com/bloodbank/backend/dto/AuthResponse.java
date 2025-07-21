package com.bloodbank.backend.dto;

public class AuthResponse {

    private String role;
    private String token;

    public AuthResponse(){}


    public AuthResponse(String token) {
        this.token = token;
    }
    public AuthResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

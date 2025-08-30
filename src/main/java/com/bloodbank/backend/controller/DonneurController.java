package com.bloodbank.backend.controller;


import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.services.DonorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/donneurs")
public class DonneurController {

    private final DonorService donorService;


    public DonneurController(DonorService donorService) {
        this.donorService = donorService;
    }

}

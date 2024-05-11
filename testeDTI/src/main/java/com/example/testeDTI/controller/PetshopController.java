package com.example.testeDTI.controller;

import com.example.testeDTI.request.MelhorPetshopRequest;
import com.example.testeDTI.response.MelhorPetshopResponse;
import com.example.testeDTI.service.PetshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/petshop")
public class PetshopController{
    private final PetshopService petshopService;

    @Autowired
    public PetshopController(PetshopService petshopService) {
        this.petshopService = petshopService;
    }

    @PostMapping("/melhor-petshop")
    public MelhorPetshopResponse encontrarMelhorPetshop(@RequestBody MelhorPetshopRequest request) {
        return petshopService.encontrarMelhorPetshop(request);
    }

}

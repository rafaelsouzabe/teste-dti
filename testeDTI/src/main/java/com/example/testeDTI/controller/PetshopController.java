package com.example.testeDTI.controller;

import com.example.testeDTI.request.MelhorPetshopRequest;
import com.example.testeDTI.response.MelhorPetshopResponse;
import com.example.testeDTI.service.PetshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/petshop")
public class PetshopController{
    private final PetshopService petshopService;

    @Autowired
    public PetshopController(PetshopService petshopService) {
        this.petshopService = petshopService;
    }

    @GetMapping("/melhor-petshop")
    public MelhorPetshopResponse encontrarMelhorPetshop(@RequestParam("data") String data,
                                                        @RequestParam("quantidadePequenos") int quantidadePequenos,
                                                        @RequestParam("quantidadeGrandes") int quantidadeGrandes) {
        return petshopService.encontrarMelhorPetshop(new MelhorPetshopRequest(data, quantidadePequenos, quantidadeGrandes));
    }

}

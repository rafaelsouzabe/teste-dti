package com.example.testeDTI.request;
import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MelhorPetshopRequest {
    private String data;
    private int quantidadePequenos;
    private int quantidadeGrandes;


    public String getData() {
        return data;
    }

    public int getQuantidadePequenos() {
        return quantidadePequenos;
    }

    public int getQuantidadeGrandes() {
        return quantidadeGrandes;
    }
}

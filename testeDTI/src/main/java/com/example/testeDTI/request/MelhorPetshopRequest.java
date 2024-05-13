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
    private Integer quantidadePequenos;
    private Integer quantidadeGrandes;


}

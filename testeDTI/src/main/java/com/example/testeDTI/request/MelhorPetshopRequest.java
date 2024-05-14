package com.example.testeDTI.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MelhorPetshopRequest {
    private String data;
    private Integer quantidadePequenos;
    private Integer quantidadeGrandes;


}

package com.example.testeDTI.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Petshop {

    private Integer id;
    private String nome;
    private Double distancia;
    private Double valorCaoPequeno;
    private Double valorCaoGrande;
    private Double aumentoCaoPequeno;
    private Double aumentoCaoGrande;
    private Boolean porcentagem;

}

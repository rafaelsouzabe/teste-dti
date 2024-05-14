package com.example.testeDTI.core.calculadora;

import com.example.testeDTI.core.entity.Petshop;

public interface CalculadoraPreco {
    Double calcularPrecoTotal(Petshop petshop, int quantidadePequenos, int quantidadeGrandes);
}

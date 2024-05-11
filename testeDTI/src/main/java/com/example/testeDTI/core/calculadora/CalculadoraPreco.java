package com.example.testeDTI.core.calculadora;

import com.example.testeDTI.core.entity.Petshop;

public interface CalculadoraPreco {
    double calcularPrecoTotal(Petshop petshop, int quantidadePequenos, int quantidadeGrandes);
}

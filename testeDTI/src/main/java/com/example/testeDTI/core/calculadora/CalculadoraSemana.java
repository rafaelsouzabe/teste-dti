package com.example.testeDTI.core.calculadora;

import com.example.testeDTI.core.entity.Petshop;


public class CalculadoraSemana implements CalculadoraPreco {
    @Override
    public Double calcularPrecoTotal(Petshop petshop, int quantidadePequenos, int quantidadeGrandes) {
        return quantidadePequenos * petshop.getValorCaoPequeno() + quantidadeGrandes * petshop.getValorCaoGrande();
    }
}

package com.example.testeDTI.core.calculadora;

import com.example.testeDTI.core.entity.Petshop;

public class CalculadoraFimDeSemana implements CalculadoraPreco {
    @Override
    public Double calcularPrecoTotal(Petshop petshop, int quantidadePequenos, int quantidadeGrandes) {
        double precoPequenos = 0;
        double precoGrandes = 0;
        if (petshop.getPorcentagem()) {
            precoPequenos = petshop.getValorCaoPequeno() + (petshop.getValorCaoPequeno() * (petshop.getAumentoCaoPequeno() / 100));
            precoGrandes = petshop.getValorCaoGrande() + (petshop.getValorCaoGrande() * (petshop.getAumentoCaoGrande() / 100));
        } else {
            precoPequenos = petshop.getValorCaoPequeno() + petshop.getAumentoCaoPequeno();
            precoGrandes = petshop.getValorCaoGrande() + petshop.getAumentoCaoGrande();
        }
        double precoTotalPequenos = quantidadePequenos * precoPequenos;
        double precoTotalGrandes = quantidadeGrandes * precoGrandes;

        return precoTotalPequenos + precoTotalGrandes;
    }
}

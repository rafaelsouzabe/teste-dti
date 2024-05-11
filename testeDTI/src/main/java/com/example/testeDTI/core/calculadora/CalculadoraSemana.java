package com.example.testeDTI.core.calculadora;

import com.example.testeDTI.core.entity.Petshop;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraSemana implements CalculadoraPreco{
    @Override
    public double calcularPrecoTotal(Petshop petshop, int quantidadePequenos, int quantidadeGrandes) {
        return quantidadePequenos * petshop.getValorCaoPequeno() + quantidadeGrandes * petshop.getValorCaoGrande();
    }
}

package com.example.testeDTI.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.testeDTI.request.MelhorPetshopRequest;
import com.example.testeDTI.response.MelhorPetshopResponse;
import com.example.testeDTI.core.entity.Petshop;
import com.example.testeDTI.core.calculadora.CalculadoraFimDeSemana;
import com.example.testeDTI.core.calculadora.CalculadoraPreco;
import com.example.testeDTI.core.calculadora.CalculadoraSemana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PetshopService {
    private CalculadoraPreco calculadoraPrecoSemana;
    private CalculadoraPreco calculadoraPrecoFimDeSemana;

    @Autowired
    public PetshopService(CalculadoraSemana calculadoraPrecoSemana,
                          CalculadoraFimDeSemana calculadoraPrecoFimDeSemana
                         ) {
        this.calculadoraPrecoSemana = calculadoraPrecoSemana;
        this.calculadoraPrecoFimDeSemana = calculadoraPrecoFimDeSemana;
    }

    public MelhorPetshopResponse encontrarMelhorPetshop(MelhorPetshopRequest request) {
        List<Petshop> petshops = new ArrayList<>();

        Petshop pet01 = new Petshop(1,"Meu Canino Feliz", 2, 20.0, 40.0, 20.0, 20.0,true);
        petshops.add(pet01);
        Petshop pet02 = new Petshop(2,"Vai Rex", 1.7, 15.0, 50.0, 5.0, 5.0, false);
        petshops.add(pet02);
        Petshop pet03 = new Petshop(3,"ChowChawgas", 0.8, 30.0, 45.0, 0, 0,false);
        petshops.add(pet03);

        //aqui vai ser a chamada do repository que vai retornar a lista de petshops
        LocalDate data = LocalDate.parse(request.getData());
        double melhorPreco = Double.MAX_VALUE;
        Petshop melhorPetshop = null;

        for (Petshop petshop : petshops) {
            double precoTotal;
            if (isFinalDeSemana(data)) {
                precoTotal = calculadoraPrecoFimDeSemana.calcularPrecoTotal(petshop,
                        request.getQuantidadePequenos(),
                        request.getQuantidadeGrandes());
            } else {
                precoTotal = calculadoraPrecoSemana.calcularPrecoTotal(petshop,
                        request.getQuantidadePequenos(),
                        request.getQuantidadeGrandes());
            }

            if (precoTotal < melhorPreco || (precoTotal == melhorPreco && petshop.getDistancia()< melhorPetshop.getDistancia())) {
                melhorPreco = precoTotal;
                melhorPetshop = petshop;
            }

        }

        MelhorPetshopResponse response = new MelhorPetshopResponse();
        assert melhorPetshop != null;
        response.setNome(melhorPetshop.getNome());
        response.setPrecoTotal(melhorPreco);
        return response;
    }

    private boolean isFinalDeSemana(LocalDate data) {
        return data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

}

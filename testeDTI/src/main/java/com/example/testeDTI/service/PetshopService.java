package com.example.testeDTI.service;

import com.example.testeDTI.repository.Repository;
import com.example.testeDTI.core.calculadora.CalculadoraFimDeSemana;
import com.example.testeDTI.core.calculadora.CalculadoraPreco;
import com.example.testeDTI.core.calculadora.CalculadoraSemana;
import com.example.testeDTI.core.entity.Petshop;
import com.example.testeDTI.request.MelhorPetshopRequest;
import com.example.testeDTI.response.MelhorPetshopResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class PetshopService {
    private final CalculadoraPreco calculadoraPrecoSemana = new CalculadoraSemana();
    private final CalculadoraPreco calculadoraPrecoFimDeSemana = new CalculadoraFimDeSemana();
    private final Repository repository;

    @Autowired
    public PetshopService(Repository repository) {
        this.repository = repository;
    }

    public MelhorPetshopResponse encontrarMelhorPetshop(MelhorPetshopRequest request) throws Exception {

        LocalDate data = LocalDate.parse(request.getData());
        Double melhorPreco = null;
        Petshop melhorPetshop = null;

        final List<Petshop> petsShop = repository.getPetshops();

        if (petsShop.isEmpty()) {
            throw new Exception("NÃO EXISTEM PETS SHOP DISPONIVEIS");
        }

        for (Petshop petshop : petsShop) {
            Double precoTotal;
            if (isFinalDeSemana(data)) {
                precoTotal = calculadoraPrecoFimDeSemana.calcularPrecoTotal(petshop,
                        request.getQuantidadePequenos(),
                        request.getQuantidadeGrandes());
            } else {
                precoTotal = calculadoraPrecoSemana.calcularPrecoTotal(petshop,
                        request.getQuantidadePequenos(),
                        request.getQuantidadeGrandes());
            }
            if (melhorPetshop == null || precoTotal < melhorPreco || (precoTotal == melhorPreco && verificaMenorDistancia(petshop, melhorPetshop))) {
                melhorPreco = precoTotal;
                melhorPetshop = petshop;
            }
        }

        MelhorPetshopResponse response = new MelhorPetshopResponse();
        response.setNome(melhorPetshop.getNome());
        response.setPrecoTotal(melhorPreco);
        return response;
    }

    private Boolean isFinalDeSemana(LocalDate data) {
        return data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private Boolean verificaMenorDistancia(Petshop petshop, Petshop melhorPetshop) {
        return petshop.getDistancia() < melhorPetshop.getDistancia();
    }
}

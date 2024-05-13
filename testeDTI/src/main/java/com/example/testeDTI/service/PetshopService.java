package com.example.testeDTI.service;
import com.example.testeDTI.Repository;
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
    private final CalculadoraPreco calculadoraPrecoSemana;
    private final CalculadoraPreco calculadoraPrecoFimDeSemana;

    @Autowired
    public PetshopService(CalculadoraSemana calculadoraPrecoSemana,
                          CalculadoraFimDeSemana calculadoraPrecoFimDeSemana
                         ) {
        this.calculadoraPrecoSemana = calculadoraPrecoSemana;
        this.calculadoraPrecoFimDeSemana = calculadoraPrecoFimDeSemana;
    }

    public MelhorPetshopResponse encontrarMelhorPetshop(MelhorPetshopRequest request) throws Exception {
        Repository repository = new Repository();
        repository.getPetshops();


        //aqui vai ser a chamada do repository que vai retornar a lista de petshops
        LocalDate data = LocalDate.parse(request.getData());
        double melhorPreco = Double.MAX_VALUE;

        final List<Petshop> petsShop = repository.getPetshops();

        if (petsShop.isEmpty()) {
            throw new Exception("NÃO EXISTEM PETS SHOP DISPONIVEIS");
        }

        Petshop melhorPetshop = petsShop.get(0);


        for (Petshop petshop : petsShop) {
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

        if (melhorPetshop == null) {
            throw new Exception("NÃO EXISTEM PETS SHOP DISPONIVEIS");
        }

        MelhorPetshopResponse response = new MelhorPetshopResponse();
        response.setNome(melhorPetshop.getNome());
        response.setPrecoTotal(melhorPreco);
        return response;
    }

    private boolean isFinalDeSemana(LocalDate data) {
        return data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

}

package com.example.testeDTI.service;

import com.example.testeDTI.repository.Repository;
import com.example.testeDTI.core.calculadora.CalculadoraPreco;
import com.example.testeDTI.core.calculadora.CalculadoraSemana;
import com.example.testeDTI.core.entity.Petshop;
import com.example.testeDTI.request.MelhorPetshopRequest;
import com.example.testeDTI.response.MelhorPetshopResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

class PetshopServiceTest {


    @Mock
    private Repository repository;

    @InjectMocks
    private PetshopService petshopService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void testListaPetshops() {
        // Criar dados de teste
        Petshop petshop1 = new Petshop(1, "Meu Canino Feliz", 2.0, 20.0, 40.0, 20.0, 20.0, true);
        Petshop petshop2 = new Petshop(2, "Vai Rex", 1.7, 15.0, 50.0, 5.0, 5.0, false);
        Petshop petshop3 = new Petshop(3, "ChowChawgas", 0.8, 30.0, 45.0, 0.0, 0.0, false);


//         Configurar comportamento do mock
        when(repository.getPetshops()).thenReturn(Arrays.asList(petshop1, petshop2, petshop3));

//         Chamar método sob teste
        List<Petshop> petshops = repository.getPetshops();

//         Verificar resultado
        assertEquals(3, petshops.size());
        assertEquals(petshop1, petshops.get(0));
        assertEquals(petshop2, petshops.get(1));
        assertEquals(petshop3, petshops.get(2));
    }
@Test
public void testCalculoPreco() {
//     Criar dados de teste
    Petshop petshop = new Petshop(1, "Meu Canino Feliz", 2.0, 20.0, 40.0, 20.0, 20.0, true);
    int quantidadePequenos = 3;
    int quantidadeGrandes = 5;

//     Chamar método sob teste
    CalculadoraPreco  calculadoraSemana= new CalculadoraSemana();
    // Chamar método sob teste
    double preco = calculadoraSemana.calcularPrecoTotal(petshop, quantidadePequenos, quantidadeGrandes);

//     Verificar resultado
    assertEquals(260.0, preco, 0.01); //verifica tolerancia de 0.01
    }

    @Test
    public void testMelhorPetshop() throws Exception {
        // Criar dados de teste
        String date = "2024-05-13";
        int quantidadePequenos = 3;
        int quantidadeGrandes = 5;

        // Criar petshops
        Petshop petshop1 = new Petshop(1, "Meu Canino Feliz", 2.0, 20.0, 40.0, 20.0, 20.0, true);
        Petshop petshop2 = new Petshop(2, "Vai Rex", 1.7, 15.0, 50.0, 5.0, 5.0, false);
        Petshop petshop3 = new Petshop(3, "ChowChawgas", 0.8, 30.0, 45.0, 0.0, 0.0, false);

        // Configurar comportamento do mock
        when(repository.getPetshops()).thenReturn(Arrays.asList(petshop1, petshop2, petshop3));

        MelhorPetshopRequest melhorPetshopRequest = new MelhorPetshopRequest(date, quantidadePequenos, quantidadeGrandes);
//        CalculadoraPreco  calculadoraSemana= new CalculadoraSemana();
//        double preco1 = calculadoraSemana.calcularPrecoTotal(petshop1, quantidadePequenos, quantidadeGrandes);
//        double preco2 = calculadoraSemana.calcularPrecoTotal(petshop1, quantidadePequenos, quantidadeGrandes);
//        double preco3 = calculadoraSemana.calcularPrecoTotal(petshop1, quantidadePequenos, quantidadeGrandes);

//        List<Petshop> petshops = repository.getPetshops();
        // Chamar método sob teste
        MelhorPetshopResponse bestPetshop = petshopService.encontrarMelhorPetshop(melhorPetshopRequest);

        // Verificar resultado
        assertEquals(petshop3, bestPetshop);
    }

//    @Test
//    public void testPrecoIgualVerificaMenorDistancia() {
////     Criar dados de teste
//        Petshop petshop = new Petshop(1, "Meu Canino Feliz", 2.0, 15.0, 40.0, 20.0, 20.0, true);
//        Petshop petshop2 = new Petshop(2, "Vai Rex", 1.7, 15.0, 50.0, 5.0, 5.0, false);
//        int quantidadePequenos = 3;
//        int quantidadeGrandes = 0;
//
////     Chamar método sob teste
//        CalculadoraPreco  calculadoraSemana= new CalculadoraSemana();
//        // Chamar método sob teste
//        double price = calculadoraSemana.calcularPrecoTotal(petshop, quantidadePequenos, quantidadeGrandes);
//
////     Verificar resultado
//        assertEquals(260.0, price, 0.01); //verifica tolerancia de 0.01
//    }
}
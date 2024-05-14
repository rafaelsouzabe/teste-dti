package com.example.testeDTI.service;

import com.example.testeDTI.core.calculadora.CalculadoraPreco;
import com.example.testeDTI.core.calculadora.CalculadoraSemana;
import com.example.testeDTI.core.entity.Petshop;
import com.example.testeDTI.repository.Repository;
import com.example.testeDTI.request.MelhorPetshopRequest;
import com.example.testeDTI.response.MelhorPetshopResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
        CalculadoraPreco calculadoraSemana = new CalculadoraSemana();
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

        // Chamar método sob teste
        MelhorPetshopResponse response = petshopService.encontrarMelhorPetshop(melhorPetshopRequest);

        // Verificar resultado
        assertEquals("Meu Canino Feliz", response.getNome());
        assertEquals(260.0, response.getPrecoTotal());
    }


    //verificando quando os preços dos petshops sao iguais, retorna o petshop de menor distancia.
    @Test
    public void testPrecoIgualVerificaMenorDistancia() throws Exception {
//     Criar dados de teste
        Petshop petshop1 = new Petshop(1, "Meu Canino Feliz", 2.0, 15.0, 40.0, 20.0, 20.0, true);
        Petshop petshop2 = new Petshop(2, "Vai Rex", 1.7, 15.0, 50.0, 5.0, 5.0, false);
        Petshop petshop3 = new Petshop(3, "ChowChawgas", 0.8, 30.0, 45.0, 0.0, 0.0, false);

        String date = "2024-05-13";
        int quantidadePequenos = 3;
        int quantidadeGrandes = 0;

        // Configurar comportamento do mock
        when(repository.getPetshops()).thenReturn(Arrays.asList(petshop1, petshop2, petshop3));

        MelhorPetshopRequest melhorPetshopRequest = new MelhorPetshopRequest(date, quantidadePequenos, quantidadeGrandes);

        // Chamar método sob teste
        MelhorPetshopResponse response = petshopService.encontrarMelhorPetshop(melhorPetshopRequest);

        // Verificar resultado
        assertEquals("Vai Rex", response.getNome());
        assertEquals(45.0, response.getPrecoTotal());
    }

    @Test
    public void testFinalSemanaAumentoValorFixo() throws Exception {
//     Criar dados de teste
        Petshop petshop1 = new Petshop(1, "Meu Canino Feliz", 2.0, 20.0, 40.0, 20.0, 20.0, true);
        Petshop petshop2 = new Petshop(2, "Vai Rex", 1.7, 15.0, 50.0, 5.0, 5.0, false);
        Petshop petshop3 = new Petshop(3, "ChowChawgas", 0.8, 30.0, 45.0, 0.0, 0.0, false);

        String date = "2024-05-12";
        int quantidadePequenos = 10;
        int quantidadeGrandes = 0;

        // Configurar comportamento do mock
        when(repository.getPetshops()).thenReturn(Arrays.asList(petshop1, petshop2, petshop3));

        MelhorPetshopRequest melhorPetshopRequest = new MelhorPetshopRequest(date, quantidadePequenos, quantidadeGrandes);

        // Chamar método sob teste
        MelhorPetshopResponse response = petshopService.encontrarMelhorPetshop(melhorPetshopRequest);

        // Verificar resultado
        assertEquals("Vai Rex", response.getNome());
        assertEquals(200.0, response.getPrecoTotal());
    }

    @Test
    public void testFinalSemanaAumentoPorcentagem() throws Exception {
//     Criar dados de teste
        Petshop petshop1 = new Petshop(1, "Meu Canino Feliz", 2.0, 20.0, 40.0, 20.0, 20.0, true);
        Petshop petshop2 = new Petshop(2, "Vai Rex", 1.7, 15.0, 50.0, 5.0, 5.0, false);
        Petshop petshop3 = new Petshop(3, "ChowChawgas", 0.8, 30.0, 45.0, 0.0, 0.0, false);

        String date = "2024-05-12";
        int quantidadePequenos = 2;
        int quantidadeGrandes = 2;

        // Configurar comportamento do mock
        when(repository.getPetshops()).thenReturn(Arrays.asList(petshop1, petshop2, petshop3));

        MelhorPetshopRequest melhorPetshopRequest = new MelhorPetshopRequest(date, quantidadePequenos, quantidadeGrandes);

        // Chamar método sob teste
        MelhorPetshopResponse response = petshopService.encontrarMelhorPetshop(melhorPetshopRequest);

        // Verificar resultado
        assertEquals("Meu Canino Feliz", response.getNome());
        assertEquals(144.0, response.getPrecoTotal());
    }
}
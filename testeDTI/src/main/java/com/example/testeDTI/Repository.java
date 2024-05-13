package com.example.testeDTI;

import com.example.testeDTI.core.entity.Petshop;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    public List<Petshop> getPetshops() {
        List<Petshop> petshops = new ArrayList<>();

        // Adicionar as instâncias dos petshops
        petshops.add(new Petshop(1, "Meu Canino Feliz", 2.0, 20.0, 40.0, 20.0, 20.0, true));
        petshops.add(new Petshop(2, "Vai Rex", 1.7, 15.0, 50.0, 5.0, 5.0, false));
        petshops.add(new Petshop(3, "ChowChawgas", 0.8, 30.0, 45.0, 0.0, 0.0, false));

        return petshops;
    }
}

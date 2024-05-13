package com.example.testeDTI.repository;

import com.example.testeDTI.core.entity.Petshop;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@org.springframework.stereotype.Repository
public class Repository {

    private List<Petshop> petshops;

    public Repository() {
        petshops = new ArrayList<>();

        petshops.add(new Petshop(1, "Meu Canino Feliz", 2.0, 20.0, 40.0, 20.0, 20.0, true));
        petshops.add(new Petshop(2, "Vai Rex", 1.7, 15.0, 50.0, 5.0, 5.0, false));
        petshops.add(new Petshop(3, "ChowChawgas", 0.8, 30.0, 45.0, 0.0, 0.0, false));

    }

}

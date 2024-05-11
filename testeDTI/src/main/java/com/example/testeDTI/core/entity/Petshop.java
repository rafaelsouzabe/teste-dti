package com.example.testeDTI.core.entity;

import lombok.Getter;

//@Getter
public class Petshop {

    private int id;
    private String nome;
    private double distancia;
    private double valorCaoPequeno;
    private double valorCaoGrande;
    private double aumentoCaoPequeno;
    private double aumentoCaoGrande;
    private boolean porcentagem;


    public Petshop(int id, String nome, double distancia, double valorCaoPequeno, double valorCaoGrande, double aumentoCaoPequeno, double aumentoCaoGrande, boolean porcentagem) {
        this.id = id;
        this.nome = nome;
        this.distancia = distancia;
        this.valorCaoPequeno = valorCaoPequeno;
        this.valorCaoGrande = valorCaoGrande;
        this.aumentoCaoPequeno = aumentoCaoPequeno;
        this.aumentoCaoGrande = aumentoCaoGrande;
        this.porcentagem = porcentagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getValorCaoPequeno() {
        return valorCaoPequeno;
    }

    public void setValorCaoPequeno(double valorCaoPequeno) {
        this.valorCaoPequeno = valorCaoPequeno;
    }

    public double getValorCaoGrande() {
        return valorCaoGrande;
    }

    public void setValorCaoGrande(double valorCaoGrande) {
        this.valorCaoGrande = valorCaoGrande;
    }

    public double getAumentoCaoPequeno() {
        return aumentoCaoPequeno;
    }

    public double getAumentoCaoGrande() {
        return aumentoCaoGrande;
    }

    public boolean isPorcentagem() {
        return porcentagem;
    }
}

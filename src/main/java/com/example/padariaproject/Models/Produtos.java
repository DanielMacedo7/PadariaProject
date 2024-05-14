package com.example.padariaproject.Models;

import java.util.Date;

//ID, NOME , PRAZO, CATEGORIA E VALOR
public class Produtos {
    private int id;
    private String nome;
    private Date prazo;
    private String categoria;
    private float valor;

    public Produtos(){

    }
    public Produtos(int id, String nome, Date prazo, String categoria, float valor) {
        this.id = id;
        this.nome = nome;
        this.prazo = prazo;
        this.categoria = categoria;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}

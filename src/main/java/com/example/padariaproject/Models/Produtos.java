package com.example.padariaproject.Models;

import java.util.Date;

//ID, NOME , PRAZO, CATEGORIA E VALOR
public class Produtos {
    private int id;
    private String nome;
    private Date prazo;
    private String categoria;
    private float valor;
    private int quantidade;

    public Produtos(){

    }
    public Produtos(int id, String nome, Date prazo, String categoria, float valor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.prazo = prazo;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Produtos(String nome, String categoria, float valor, int quantidade) {
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    @Override
    public String toString() {
        return "Produtos{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prazo=" + prazo +
                ", categoria='" + categoria + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}

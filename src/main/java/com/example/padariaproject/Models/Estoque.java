package com.example.padariaproject.Models;

// ID , ID_PRODUTO E MÉTODOS a implementar
public class Estoque {
    private int id;
    private int id_produto;

    public Estoque(int id, int id_produto) {
        this.id = id;
        this.id_produto = id_produto;
    }

    public void CalcularEstoque(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
}

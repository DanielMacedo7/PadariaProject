package com.example.padariaproject.Models;

import java.util.Objects;

// ID, NOME , LOGIN E SENHA
public class Perfil {
    private int id;
    private String nome;
    private String login;
    private String senha;

    public Perfil(){

    }
    public Perfil(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return id == perfil.id && Objects.equals(nome, perfil.nome) && Objects.equals(login, perfil.login) && Objects.equals(senha, perfil.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, login, senha);
    }
}

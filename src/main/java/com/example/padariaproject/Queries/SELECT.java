package com.example.padariaproject.Queries;

import com.example.padariaproject.Models.Estoque;
import com.example.padariaproject.Models.Funcionario;
import com.example.padariaproject.Models.Perfil;
import com.example.padariaproject.Models.Produtos;
import com.example.padariaproject.Util.ConnectionDBA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SELECT {

    // só é necessário passar como parâmetro um id se for fazer find by id .
    // nesse caso como teremos apenas um perfil iremos fazer um findby id.

    //FindBylogin para procurar fazer login na tela.
    public static Perfil findPerfilByLogin(String login) {
        Perfil perfil = null;
        String sql = "SELECT id, nome, login, senha FROM Perfil WHERE login = ?";
        try (Connection conn = ConnectionDBA.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
             statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    perfil = new Perfil();
                    perfil.setId(resultSet.getInt("id"));
                    perfil.setNome(resultSet.getString("nome"));
                    perfil.setLogin(resultSet.getString("login"));
                    perfil.setSenha(resultSet.getString("senha"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perfil;
    }



    public static List<Funcionario> funcionariofindAll(){

        String sql = "SELECT * FROM Funcionario";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Funcionario> funcionarioList = new ArrayList<>();

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while(resultSet.next()){

            Funcionario funcionario = new Funcionario();
            funcionario.setId(resultSet.getInt("id"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setTelefone(resultSet.getString("telefone"));
            funcionario.setEndereco(resultSet.getString("endereço"));
            funcionarioList.add(funcionario);

            }

            return funcionarioList;

        }catch(SQLException e){
            throw new RuntimeException("Erro ao Buscar Funcionario" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection2(connection,statement,resultSet);
        }




    }

    public static List<Produtos> produtosfindAll(){

        String sql = "SELECT * FROM Produtos";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Produtos> produtosList = new ArrayList<>();

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Produtos produtos = new Produtos();
                produtos.setId(resultSet.getInt("id"));
                produtos.setNome(resultSet.getString("nome"));
                produtos.setPrazo(resultSet.getDate("prazo"));
                produtos.setCategoria(resultSet.getString("categoria"));
                produtos.setValor(resultSet.getFloat("valor"));
                produtos.setQuantidade(resultSet.getInt("quantidade"));
                produtosList.add(produtos);

            }
                return produtosList;

        }catch(SQLException e){
            throw new RuntimeException("Erro ao Pesquisar produtos" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection2(connection,statement,resultSet);
        }



    }

    public static List<Estoque> estoquefindAll(int id_produto){

    String sql = "SELECT * FROM Estoque WHERE id_produto = ?";

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    List<Estoque> estoqueList = new ArrayList<>();

    try{
        connection = ConnectionDBA.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id_produto);
        resultSet = statement.executeQuery();

        while(resultSet.next()){

        Estoque estoque = new Estoque();
        estoque.setId(resultSet.getInt("id"));
        estoque.setId_produto(resultSet.getInt("id_produto"));
        estoqueList.add(estoque);

        }

        return estoqueList;

    }catch(SQLException e){
        throw new RuntimeException("Erro ao buscar por Produto no Estoque" + e.getMessage() + e);
    }finally {
        ConnectionDBA.closeConnection2(connection,statement,resultSet);
    }




    }



}

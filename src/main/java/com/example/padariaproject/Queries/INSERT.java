package com.example.padariaproject.Queries;

import com.example.padariaproject.Models.Estoque;
import com.example.padariaproject.Models.Funcionario;
import com.example.padariaproject.Models.Perfil;
import com.example.padariaproject.Models.Produtos;
import com.example.padariaproject.Util.ConnectionDBA;

import java.sql.*;

// essa classe vai conter o insert de todas as entidades.
public class INSERT {

    public static void savePerfil(Perfil perfil) {

        Connection connection = null;

        // lembrar sempre de chamar o Prepare pq é atráves dele que vamos executar as inst.
        PreparedStatement statement = null;

        String sql = "INSERT INTO Perfil(nome, login, senha) VALUES (?, ?, ?)";

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, perfil.getNome());
            statement.setString(2, perfil.getLogin());
            statement.setString(3, perfil.getSenha());
            statement.execute();

        }catch(SQLException e){
            throw new RuntimeException("Erro ao Salvar perfil" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection(connection, statement);
        }

    }


    public static void saveFuncionario(Funcionario funcionario){

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "INSERT INTO Funcionario(nome, telefone, endereço) VALUES (?, ?, ?)";

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getTelefone());
            statement.setString(3, funcionario.getEndereco());
            statement.execute();

        }catch (SQLException e){
            throw new RuntimeException("Erro ao Inserir Funcionario" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection(connection, statement);
        }
    }


    public static void saveProdutos(Produtos produtos){

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "INSERT INTO Produtos(nome, prazo, categoria, valor, quantidade) VALUES (?, ?, ?, ?, ?)";

        try{

            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, produtos.getNome());
            statement.setDate(2, new Date(produtos.getPrazo().getTime()));
            statement.setString(3, produtos.getCategoria());
            statement.setFloat(4, produtos.getValor());
            statement.setInt(5, produtos.getQuantidade());
            statement.execute();

        }catch(SQLException e){
            throw new RuntimeException("Erro ao Inserir Produto" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection(connection, statement);
        }


    }

    public static void saveEstoque(Estoque estoque){

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "INSERT INTO Estoque(id_produto) VALUES (?)";

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, estoque.getId_produto());
            statement.execute();

        }catch(SQLException e){
            throw new RuntimeException("Erro ao Inserir produto no Estoque" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection(connection, statement);
        }

    }

}

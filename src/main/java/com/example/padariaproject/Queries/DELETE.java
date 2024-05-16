package com.example.padariaproject.Queries;

import com.example.padariaproject.Models.Estoque;
import com.example.padariaproject.Models.Funcionario;
import com.example.padariaproject.Models.Produtos;
import com.example.padariaproject.Util.ConnectionDBA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class DELETE {

    public static void deleteFuncionario(Funcionario funcionario){

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "DELETE FROM Funcionario WHERE id = ?";

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, funcionario.getId());
            statement.execute();


        }catch(SQLException e){
            throw new RuntimeException("Erro ao Deletar Perfil" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection(connection, statement);
        }


    }

    public static void deleteProdutos(Produtos produtos){

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "DELETE FROM Produtos WHERE id = ?";

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, produtos.getId());
            statement.execute();

        }catch (SQLException e){
            throw new RuntimeException("Erro ao Deletar Produtos" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection(connection,statement);
        }


    }

    public static void deleteEstoque(Estoque estoque){

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "DELETE FROM Estoque WHERE id = ?";

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, estoque.getId());
            statement.execute();

        }catch (SQLException e){
            throw new RuntimeException("Erro ao Deletar produto do Estoque" + e.getMessage() + e);
            }finally {
            ConnectionDBA.closeConnection(connection,statement);
        }

    }

}

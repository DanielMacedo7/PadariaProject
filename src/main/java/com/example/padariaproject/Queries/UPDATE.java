package com.example.padariaproject.Queries;

import com.example.padariaproject.Models.Estoque;
import com.example.padariaproject.Models.Funcionario;
import com.example.padariaproject.Models.Perfil;
import com.example.padariaproject.Models.Produtos;
import com.example.padariaproject.Util.ConnectionDBA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UPDATE {


    public static void updatePerfil(Perfil perfil){

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE Perfil SET " +
                "nome = ?," +
                " login = ?," +
                " senha = ? " +
                " WHERE id = ?";

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, perfil.getNome());
            statement.setString(2, perfil.getLogin());
            statement.setString(3, perfil.getSenha());
            statement.setInt(4, perfil.getId());
            statement.execute();


        }catch(SQLException e){
            throw new RuntimeException("Erro ao Atualizar perfil" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection(connection, statement);
        }



    }

    public static void updateFuncionario(Funcionario funcionario){

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE Funcionario SET " +
                "nome = ?," +
                "telefone = ?," +
                "endereço = ? " +
                "WHERE id = ?";

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getTelefone());
            statement.setString(3, funcionario.getEndereco());
            statement.setInt(4, funcionario.getId());
            statement.execute();


        }catch (SQLException e){
            throw  new RuntimeException("Erro ao Atualizar Funcionario" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection(connection,statement);
        }

    }

    // vou mostrar para vocês como fazer o update do restante das entidades, já fiz o save de todas
    // e também já testei o update da 1 entidade.

    public static void updateProdutos(Produtos produtos){

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE Produtos SET " +
                "nome = ?, " +
                "prazo = ?," +
                "categoria = ?, " +
                "valor = ? " +
                "WHERE id = ?";

        try{
            connection = ConnectionDBA.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, produtos.getNome());
            statement.setDate(2, new Date(produtos.getPrazo().getTime())); // aqui é tipo date então precisamos converter
            statement.setString(3, produtos.getCategoria());
            statement.setFloat(4, produtos.getValor());
            statement.setInt(5, produtos.getId());
            statement.execute();

        }catch(SQLException e){
            throw new RuntimeException("Erro ao Atualizar Produtos"  + e.getMessage() + e);
        }

    }

    public static void updateEstoque(Estoque estoque){

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE Estoque SET " +
                "id_produto = ? " +
                "WHERE id = ?";

        try{
            connection = ConnectionDBA.getConnection(); // abre conexão
            statement = connection.prepareStatement(sql); // cria objeto da interface que executa instrução SQL
            statement.setInt(1 , estoque.getId_produto());
            statement.setInt(2, estoque.getId());
            statement.execute();

        }catch(SQLException e){
            throw new RuntimeException("Erro ao Atualizar Estoque" + e.getMessage() + e);
        }finally {
            ConnectionDBA.closeConnection(connection, statement);
        }

    }

    // aqui finalizamos o UPDATE de cada Entidade, agora vamos testar manualmente.

}

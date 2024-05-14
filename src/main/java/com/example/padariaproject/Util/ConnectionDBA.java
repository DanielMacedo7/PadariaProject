package com.example.padariaproject.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ConnectionDBA{

    //essa classe só irá conter métodos estáticos para não haver a necessidade de instacia-los.

    // 3 ATRIBUTOS PRINCIPAIS PARA FAZER ESSA INTEGRAÇÃO COM O BANCO DE DADOS
    public static final String URL = "jdbc:postgresql://localhost:5432/PadariaApp";
    public static final String USER = "postgres";
    public static final String PASS = "root";


    //Abrindo a conexão com o banco de dados
    public static Connection getConnection(){
      try {
          return DriverManager.getConnection(URL, USER, PASS);
      }catch(SQLException ex ){
          throw  new RuntimeException("Erro ao abrir conexão com o banco de dados", ex);
      }
    }

    // Método para fechar conexão, fecha também a interface que executa instruções SQL e
    // ResultSet que vai servir para buscar todos os nossos dados do objeto
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar conexão");
        }

        try{
            if(statement != null){
                statement.close();
            }
        }catch (SQLException e){
            throw new RuntimeException("", e);
        }



    }

    public static void closeConnection2(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar conexão");
        }

        try{
            if(statement != null){
                statement.close();
            }
        }catch (SQLException e){
            throw new RuntimeException("", e);
        }

        try{
            if(resultSet != null){
                resultSet.close();
            }
        }catch (SQLException e){
            throw new RuntimeException("", e);
        }


    }





}

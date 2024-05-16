package com.example.padariaproject;

import com.example.padariaproject.Models.Estoque;
import com.example.padariaproject.Models.Funcionario;
import com.example.padariaproject.Models.Perfil;
import com.example.padariaproject.Models.Produtos;
import com.example.padariaproject.Queries.DELETE;
import com.example.padariaproject.Queries.INSERT;
import com.example.padariaproject.Queries.UPDATE;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.example.padariaproject.Queries.DELETE.*;
import static com.example.padariaproject.Queries.INSERT.*;
import static com.example.padariaproject.Queries.SELECT.*;
import static com.example.padariaproject.Queries.UPDATE.*;


public class PadariaApplication extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainView"));
        stage.setMaximized(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("PadariaApp");
        stage.setScene(scene);
        stage.show();

        // através do método toString ele retorna todos os dados do banco em um array
        // para testar o find vamos criar uma variavel da lista e chamar o método para ela.
        List<Perfil> perfilList = perfilfindAll(1);
        System.out.println("Perfil " + perfilList);

        List<Funcionario> funcionarioList = funcionariofindAll();
        System.out.println("Funcionarios: " + funcionarioList);

        List<Produtos> produtosList = produtosfindAll();
        System.out.println("Produtos: " + produtosList);

        List<Estoque> estoqueList = estoquefindAll(3);
        System.out.println("Estoque: " + estoqueList);

      //  Funcionario funcionario = new Funcionario();
      //  funcionario.setId(1);
      //  deleteFuncionario(funcionario);

      //   Produtos produtos = new Produtos();
      //   produtos.setId(1);
      //   deleteProdutos(produtos);

      //     Estoque estoque = new Estoque();
      //     estoque.setId(1);
      //     deleteEstoque(estoque);


        // 1 - vamos testar o update de Funcionario por que o de perfil já está funcionando.
        // 2 - Produtos. check.
        // 3 - Estoque. check
        // UPDATE feito de todas as entidades : Código disponível no github.

       // Estoque estoque = new Estoque();
       // estoque.setId_produto(2);
       // estoque.setId(1);
       // updateEstoque(estoque);



      //  Produtos produtos = new Produtos();
      //  produtos.setNome("Novo Produto");
      //  produtos.setPrazo(new Date());
      //  produtos.setCategoria("Salgados");
      //  produtos.setValor(30);
      //  produtos.setId(1);
      //  updateProdutos(produtos);

       // Funcionario funcionario = new Funcionario();
       // funcionario.setNome("New Funcionario");
       // funcionario.setTelefone("New Telefone");
       // funcionario.setEndereco("New Endereço");
       // funcionario.setId(1);
       // updateFuncionario(funcionario);

      //  Perfil perfil = new Perfil();
      //  perfil.setId(2);
      //  perfil.setNome("Novo nome");
      //  perfil.setLogin("Novo Login");
      //  perfil.setSenha("Nova Senha");
      //  updatePerfil(perfil);


      //  Perfil perfil = new Perfil();
      //  perfil.setNome("Daniel Macedo");
      //  perfil.setLogin("danieru1");
      //  perfil.setSenha("Astro@99");
      //  savePerfil(perfil);

   //    Funcionario funcionario = new Funcionario();
   //    funcionario.setNome("Daniel");
   //    funcionario.setEndereco("Rodovia Prefeito Joao Sampaio");
   //    funcionario.setTelefone("123456789");
   //    saveFuncionario(funcionario);

     //  Produtos produtos = new Produtos();
     //  produtos.setNome("Queijo");
     //  produtos.setPrazo(new Date());
     //  produtos.setCategoria("Frios");
     //  produtos.setValor(99.0f);
     //  saveProdutos(produtos);

     //   Estoque estoque = new Estoque();
     //   estoque.setId_produto(3);
     //   saveEstoque(estoque);
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PadariaApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Scene getMainScene() {
        return scene;
    }


    public static void main(String[] args) {
        launch(args);


    }
}


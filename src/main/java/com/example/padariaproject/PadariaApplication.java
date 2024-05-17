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
        scene = new Scene(loadFXML("Login"));
        stage.setMaximized(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("PadariaApp");
        stage.setScene(scene);
        stage.show();


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


package com.example.padariaproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

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


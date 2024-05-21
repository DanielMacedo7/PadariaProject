package com.example.padariaproject.Util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Arrays;
import java.util.Optional;

// Classe para emitir alertas nas telas

public class Alerts {

    public static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public static void showAlertSucess(String title, String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.OK);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public static Optional<ButtonType> AlertaConfirmacao(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        return alert.showAndWait();
    }

    public static boolean checkTextFields2 (String... Fields) {
       for(String field : Fields){
           System.out.println("Check fields: " + field);
           if(field == null || field.trim().isEmpty()){
           return false;
           }
       }
       return true;
    }

}

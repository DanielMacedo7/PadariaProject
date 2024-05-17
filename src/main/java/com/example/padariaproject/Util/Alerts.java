package com.example.padariaproject.Util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Arrays;

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

    // Para fazer checagem de textfields ou qualquer tipo de campo vazio.
    public static boolean checkTextFields (String... args) {
        return Arrays.stream(args).allMatch(arg -> arg == null || arg.isEmpty());
    }


}

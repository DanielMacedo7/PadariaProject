package com.example.padariaproject;

import com.example.padariaproject.Models.Perfil;
import com.example.padariaproject.Util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.padariaproject.Queries.INSERT.savePerfil;

public class LoginController implements Initializable {


    @FXML
    private Hyperlink si_hyperlink;

    @FXML
    private TextField si_login;

    @FXML
    private Button si_loginbtn;

    @FXML
    private PasswordField si_password;


    @FXML
    private Button re_btnclear;

    @FXML
    private Button re_btnsave;

    @FXML
    private TextField re_login;

    @FXML
    private TextField re_name;

    @FXML
    private PasswordField re_password;


    @FXML
    private void clearRegister(){
        re_name.clear();
        re_login.clear();
        re_password.clear();

    }

    @FXML
    private void saveRegister(ActionEvent event){

        String name = re_name.getText();
        String login = re_login.getText();
        String password = re_password.getText();

    try {

        if (Alerts.checkTextFields(name, login, password)) {
            Alerts.showAlert("Erro", "Preencha os campos Vazios!");


            Perfil perfil = new Perfil();
            perfil.setNome(name);
            perfil.setLogin(login);
            perfil.setSenha(password);
            savePerfil(perfil);
            Alerts.showAlertSucess("Sucesso", "Perfil foi Salvo!");

        }else {
            Alerts.showAlert("Erro", "Perfil nao foi salvo");
        }

    }catch (Exception e){
        throw new RuntimeException("Erro:" , e);
    }


    }


    @FXML
    private void clickHyperlink(ActionEvent event) throws IOException {
        if(event.getSource() == si_hyperlink){
            loadJDialog("JDialogRegister");

        }

    }


    @FXML
    private void loadJDialog(String file) throws IOException {
        Parent root = FXMLLoader.load(PadariaApplication.class.getResource(file + ".fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 291, 293);
        stage.setScene(scene);
        stage.show();
        si_hyperlink.getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }



}

package com.example.padariaproject.Controller;

import com.example.padariaproject.Models.Perfil;
import com.example.padariaproject.PadariaApplication;
import com.example.padariaproject.Util.Alerts;
import com.example.padariaproject.Util.ConnectionDBA;
import com.example.padariaproject.Util.PerfilSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.example.padariaproject.Queries.INSERT.savePerfil;
import static com.example.padariaproject.Queries.SELECT.findPerfilByLogin;


public class LoginController implements Initializable {

    //Tudo sobre Login
    @FXML
    private Button btnbacklogin;

    @FXML
    private Hyperlink si_hyperlink;

    @FXML
    private TextField si_login;

    @FXML
    private Button si_loginbtn;

    @FXML
    private PasswordField si_password;
    //////////////////////////////////


    //Tudo sobre Registro
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
    /////////////////////////////////


    //Método para limpar os campos de registro.
    @FXML
    private void clearRegister(){
        re_name.clear();
        re_login.clear();
        re_password.clear();

    }

    //Implementação do evento de salvar um registro.
    @FXML
    private void saveRegister(ActionEvent event){

        String name = re_name.getText();
        String login = re_login.getText();
        String password = re_password.getText();

        System.out.println("nome : " + name);
        System.out.println("login : " + login);
        System.out.println("senha : " + password);

    try {

        if (!Alerts.checkTextFields2(name, login, password)) {
            Alerts.showAlert("Erro", "Preencha os campos Vazios!");

        }else{

            Perfil perfil = new Perfil();
            perfil.setNome(name);
            perfil.setLogin(login);
            perfil.setSenha(password);
            savePerfil(perfil);
            Alerts.showAlertSucess("Sucesso", "Perfil foi Salvo!");
            loadLogin("Login");

        }

    }catch (Exception e){
        throw new RuntimeException("Erro:" , e);
    }


    }

    //Recebe um aviso e depois se OK fecha o sistema completamente
    @FXML
    private void SystemExit(ActionEvent event){
        Optional<ButtonType> question = Alerts.AlertaConfirmacao("Alerta", " tem certeza que deseja sair?");

        if(question.get().equals(ButtonType.OK)) {
            System.exit(0);

        }

    }



    //ao clicar no hyperlink você carrega a tela de registro.
    @FXML
    private void clickHyperlink(ActionEvent event) throws IOException {
        if(event.getSource() == si_hyperlink){
            loadJDialog("JDialogRegister");

        }

    }


    //Implementação do método para carregar a tela de registro.
    @FXML
    private void loadJDialog(String file) throws IOException {
        Parent root = FXMLLoader.load(PadariaApplication.class.getResource(file + ".fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 291, 293);
        stage.setMaximized(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        si_hyperlink.getScene().getWindow().hide();
    }


    //Implementação do método para carregar a tela de login
    @FXML
    private void loadLogin(String file) throws IOException {
        Parent root = FXMLLoader.load(PadariaApplication.class.getResource(file + ".fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 600, 400);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.show();
        re_btnsave.getScene().getWindow().hide();
    }


    //Evento para efetuar login e carregar as informações do login.
    @FXML
    private void Login(ActionEvent event) throws IOException {

    String login = si_login.getText();
    String password = si_password.getText();

    if(!Alerts.checkTextFields2(login, password)) {
        Alerts.showAlert("Erro: ", "Preencha os campos para fazer o Login");

    }else {
        Perfil perfil = findPerfilByLogin(login);
        if(perfil == null || !perfil.getSenha().equals(password)){
            Alerts.showAlert("Erro" , "Login ou Senha Incorretos.");
        }else{
            Alerts.showAlertSucess("Sucesso", "Login efetuado: " + login + " : " + password );
            PerfilSession.setPerfil(perfil);
            loadMainView("MainView");

        }
      }
    }


    //Implementação do método para carregar a MainView
    @FXML
    private void loadMainView(String file) throws IOException {
        Parent root = FXMLLoader.load(PadariaApplication.class.getResource(file + ".fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 800, 600);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.show();
        si_loginbtn.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }



}

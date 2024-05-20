package com.example.padariaproject;

import com.example.padariaproject.Models.Perfil;
import com.example.padariaproject.Util.Alerts;
import com.example.padariaproject.Util.PerfilSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.example.padariaproject.Queries.UPDATE.updatePerfil;


public class PadariaController implements Initializable {

    private static Scene scene;

    // Tudo da Aba Perfil.
    @FXML
    private Button pe_btnupdate;

    @FXML
    private TextField pe_id;

    @FXML
    private TextField pe_fieldlogin;

    @FXML
    private TextField pe_fieldname;

    @FXML
    private PasswordField pe_fieldpassword;

    @FXML
    private AnchorPane paneperfil;

    //////////////////////////////////////////

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnEstoque;

    @FXML
    private Button btnFuncionario;

    @FXML
    private Button btnInicio;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnback;

    @FXML
    private ListView<String> listview;


    @FXML
    private AnchorPane paneInicio;

    @FXML
    private AnchorPane paneestoque;

    @FXML
    private AnchorPane panefuncionarios;

    @FXML
    private AnchorPane paneprodutos;



    private void loadList(){
        String[] items = {"Maça","Banana", "Pera", "Mamao"};
        ObservableList <String> itemlist = FXCollections.observableArrayList(items);
        listview.setItems(itemlist);
    }

    @FXML
    private void returnToLogin(ActionEvent Event) throws IOException {
       BackSystem("Login");

    }

    @FXML
    private void BackSystem(String file) throws IOException{
       Optional <ButtonType> question = Alerts.AlertaConfirmacao("Alerta", " tem certeza que deseja sair?");

       if(question.get().equals(ButtonType.OK)) {
           btnback.getScene().getWindow().hide();
       }

        Parent root =  FXMLLoader.load(PadariaApplication.class.getResource(file + ".fxml"));
        Stage stage = new Stage(); // controla tudo
        Scene scene = new Scene(root, 600, 400); // apenas a cena
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    private void TransitionView(ActionEvent event){
        if(event.getSource() == btnInicio) {
            paneInicio.setVisible(true);
            paneestoque.setVisible(false);
            panefuncionarios.setVisible(false);
            paneprodutos.setVisible(false);
            paneperfil.setVisible(false);
        }else if(event.getSource() == btnEstoque){
            paneestoque.setVisible(true);
            paneInicio.setVisible(false);
            panefuncionarios.setVisible(false);
            paneprodutos.setVisible(false);
            paneperfil.setVisible(false);
        }else if(event.getSource() == btnProdutos){
            paneprodutos.setVisible(true);
            paneestoque.setVisible(false);
            panefuncionarios.setVisible(false);
            paneInicio.setVisible(false);
            paneperfil.setVisible(false);
        }else if(event.getSource() == btnFuncionario){
            panefuncionarios.setVisible(true);
            paneestoque.setVisible(false);
            paneInicio.setVisible(false);
            paneprodutos.setVisible(false);
            paneperfil.setVisible(false);
        }else if(event.getSource() == btnPerfil){
            paneperfil.setVisible(true);
            panefuncionarios.setVisible(false);
            paneestoque.setVisible(false);
            paneInicio.setVisible(false);
            paneprodutos.setVisible(false);
        }

    }

    //método para atualizar o perfil que está sendo carregado.
    @FXML
    private void atualizaPerfil(ActionEvent event) {
        String id = pe_id.getText();
        String nome = pe_fieldname.getText();
        String login = pe_fieldlogin.getText();
        String password = pe_fieldpassword.getText();
        Perfil perfil = PerfilSession.getPerfil();

        if (perfil != null) {
            if (!Alerts.checkTextFields2(id, nome, login, password)) {
                Alerts.showAlert("Erro", "Preencha os Campos para salvar Alteracao");
            } else {
                perfil.setId(Integer.parseInt(id));
                perfil.setNome(nome);
                perfil.setLogin(login);
                perfil.setSenha(password);
                updatePerfil(perfil);
                Alerts.showAlertSucess("Sucesso!", "Perfil atualizado com Sucesso!");
            }
        }
    }

    //método para carregar os atributos de perfil nos textfields de perfil.
    private void loadPerfil(){
    Perfil perfil = PerfilSession.getPerfil();
    if(perfil != null) {
        pe_id.setText(String.valueOf(perfil.getId()));
        pe_fieldname.setText(perfil.getNome());
        pe_fieldlogin.setText(perfil.getLogin());
        pe_fieldpassword.setText(perfil.getSenha());
    }

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PadariaApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    // precisamos converter para observablelist para setar os items
    loadList();
    loadPerfil();

    }

}
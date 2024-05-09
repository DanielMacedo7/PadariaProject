package com.example.padariaproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class PadariaController implements Initializable {

    @FXML
    private Hyperlink si_hyperlink;

    @FXML
    private TextField si_login;

    @FXML
    private Button si_loginbtn;

    @FXML
    private PasswordField si_password;

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
    private AnchorPane paneperfil;


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
    private void BackSystem(){
        System.exit(0);
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    // precisamos converter para observablelist para setar os items
    loadList();

    }

}
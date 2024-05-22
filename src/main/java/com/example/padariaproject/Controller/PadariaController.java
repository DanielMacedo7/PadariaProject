package com.example.padariaproject.Controller;

import com.example.padariaproject.Models.Funcionario;
import com.example.padariaproject.Models.Perfil;
import com.example.padariaproject.Models.Produtos;
import com.example.padariaproject.PadariaApplication;
import com.example.padariaproject.Queries.DELETE;
import com.example.padariaproject.Util.Alerts;
import com.example.padariaproject.Util.OpenWebInDesktop;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.example.padariaproject.Queries.DELETE.deleteFuncionario;
import static com.example.padariaproject.Queries.INSERT.saveFuncionario;
import static com.example.padariaproject.Queries.INSERT.saveProdutos;
import static com.example.padariaproject.Queries.SELECT.funcionariofindAll;
import static com.example.padariaproject.Queries.SELECT.produtosfindAll;
import static com.example.padariaproject.Queries.UPDATE.*;
import static com.example.padariaproject.Util.ConversionDate.converterData;
import static com.example.padariaproject.Util.ConversionDate.formatarData;
import static com.example.padariaproject.Util.OpenWebInDesktop.OpenWebPage;


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

    //Tudo sobre Funcionarios 62 até 81

    @FXML
    private AnchorPane panefuncionarios;


    @FXML
    private TableView<Funcionario> tb_funcionarios;

    @FXML
    TableColumn tb_funcioid ;

    @FXML
    TableColumn tb_funcionome ;

    @FXML
    TableColumn tb_funciotelefone;

    @FXML
    TableColumn tb_endereco;

    @FXML
    TextField txtfuncionome;

    @FXML
    TextField txtfunciotelefone;

    @FXML
    TextField txtfuncioendereco;

    @FXML
    TextField txtfuncioid;

    @FXML
    Button btnadicionarfun;

    @FXML
    Button btnlimparfun;

    @FXML
    Button btnupdatefun;

    @FXML
    Button btndeletarfun;


    ////////////////////////////////////////////


    //Tudo sobre Produtos  81 até 102
    @FXML
    private AnchorPane paneprodutos;

    @FXML
    private TableView<Produtos> tb_produtos;

    @FXML
    TableColumn tb_produtosid ;

    @FXML
    TableColumn tb_produtosnome ;

    @FXML
    TableColumn tb_produtosprazo;

    @FXML
    TableColumn tb_produtoscategoria;

    @FXML
    TableColumn tb_produtosvalor;

    @FXML
    TextField txtprodutosid;

    @FXML
    TextField txtprodutosnome;

    @FXML
    TextField txtprodutosprazo;


    @FXML
    TextField txtprodutoscategoria;


    @FXML
    TextField txtprodutosvalor;

    @FXML
    Button btnadicionarprodutos;

    @FXML
    Button btnlimparprodutos;

    @FXML
    Button btnatualizarprodutos;

    @FXML
    Button btndeletarprodutos;





    /////////////////////////////////


    //Tudo sobre Inicio 111 até 120

    @FXML
    private AnchorPane paneInicio;

    @FXML
    private Hyperlink ini_hyperlinkgit;

    @FXML
    private Hyperlink ini_hyperlinkwpp;

    /////////////////////////////////


    //Tudo sobre Estoque 125 até 130
    @FXML
    private AnchorPane paneestoque;

    @FXML
    private ListView<String> listview;

    //////////////////////////////////

    //Botões para transições das Telas
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


    //Método para carregar funcionarios na TableView
    private void LoadFuncionarios(){
    List<Funcionario> listfuncionario = funcionariofindAll();
    ObservableList <Funcionario> funcionarios = FXCollections.observableList(listfuncionario);
        tb_funcionarios.setItems(funcionarios);


    }

    //Método para carregar produtos na TableView
    private void LoadProdutos(){
        List<Produtos> listprodutos = produtosfindAll();
        ObservableList <Produtos> produtos = FXCollections.observableList(listprodutos);
        tb_produtos.setItems(produtos);

    }



    //Mock de list para testar a list em estoques.
    private void loadList(){
        String[] items = {"Maça","Banana", "Pera", "Mamao"};
        ObservableList <String> itemlist = FXCollections.observableArrayList(items);
        listview.setItems(itemlist);
    }


    //Redirecionamento para a tela de login.
    @FXML
    private void returnToLogin(ActionEvent Event) throws IOException {
       BackSystem("Login");

    }

    // implementação do método para retornar para tela de login após clicar no botão de Sair
    private void BackSystem(String file) throws IOException{
       Optional <ButtonType> question = Alerts.AlertaConfirmacao("Alerta", " tem certeza que deseja sair?");

       if(question.get().equals(ButtonType.OK)) {
           btnback.getScene().getWindow().hide();

           // carrega a tela de login caso o clique botão OK.
           Parent root = FXMLLoader.load(PadariaApplication.class.getResource(file + ".fxml"));
           Stage stage = new Stage(); // controla tudo
           Scene scene = new Scene(root, 600, 400); // apenas a cena
           stage.initStyle(StageStyle.TRANSPARENT);
           stage.setMaximized(false);
           stage.setScene(scene);
           stage.show();

       }

    }

    // Método de transição das telas.
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

    //310 até 338 métodos para abrir o navegador na url ordenada via hyperlink na interface.

    //Evento de abrir github atráves de um hyperlink no destkop.
    @FXML
    private void WebGit(ActionEvent event){

        String url = "https://github.com/DanielMacedo7/PadariaProject";

        try{
            OpenWebPage(new URI(url));
        }catch(URISyntaxException e){
            e.printStackTrace();
        }

    }

    //Evento de cair na minha conversa no whatsapp web atráves de um hyperlink no desktop.
    @FXML
    private void WebWpp(ActionEvent event){

        String url = "https://wa.me/5521980913660";

        try{
            OpenWebPage(new URI(url));
        }catch(URISyntaxException e){
            e.printStackTrace();
        }

    }

    // 340 até 370 Preencher TxtFields das abas de Funcionario e Produtos.

    //Implementação do método para clicar em um elemento na tableview e carregar os textfields de funcionarios
    @FXML
    private void PreencherFieldsFuncionarios(){
        Funcionario funcionario = tb_funcionarios.getSelectionModel().getSelectedItem();
        int y = tb_funcionarios.getSelectionModel().getSelectedIndex();

        int pass = funcionario.getId();
        String receive = String.valueOf(pass);

        if(y == -1) return;
        txtfuncioid.setText(receive);
        txtfuncionome.setText(funcionario.getNome());
        txtfunciotelefone.setText(funcionario.getTelefone());
        txtfuncioendereco.setText(funcionario.getEndereco());

    }

    //Implementação do método para clicar em um elemento na tableview e carregar os textfields de produtos
    @FXML
    private void PreencherFieldsProdutos(){
        Produtos produtos = tb_produtos.getSelectionModel().getSelectedItem();
        int x = tb_produtos.getSelectionModel().getSelectedIndex();

        float passvalor = produtos.getValor();// precisamos carregar o valor do produto nessa variável pois é float
        String receive = String.valueOf(passvalor); // e depois converter para string para carregar no campo.

        int passid = produtos.getId();
        String receiveid = String.valueOf(passid);

        if(x == -1) return; // validação para checar se o indice for = - 1 então não existe algo selecionado
        txtprodutosid.setText(receiveid);
        txtprodutosnome.setText(produtos.getNome());
        txtprodutosprazo.setText(produtos.getPrazo().toString());
        txtprodutoscategoria.setText(produtos.getCategoria());
        txtprodutosvalor.setText(receive);
    }




    //Inicialização das tableView
    private void inicializaTables(){
        LoadFuncionarios();
        tb_funcioid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tb_funcionome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tb_funciotelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tb_endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        LoadProdutos();
        tb_produtosid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tb_produtosnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tb_produtosprazo.setCellValueFactory(new PropertyValueFactory<>("prazo"));
        tb_produtoscategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tb_produtosvalor.setCellValueFactory(new PropertyValueFactory<>("valor"));

    }


    //Métodos para limpar txtfields nas Screens de Funcionarios e Produtos.
    public void ClearFieldsFuncionarios(){
        txtfuncionome.clear();
        txtfunciotelefone.clear();
        txtfuncioendereco.clear();

    }

    public void ClearFieldsProdutos(){
        txtprodutosnome.clear();
        txtprodutosprazo.clear();
        txtprodutoscategoria.clear();
        txtprodutosvalor.clear();
    }


    // Método para Atualizar um Registro na TableView
    @FXML
    private void updateFuncionarioEvt(ActionEvent event) {
        String id = txtfuncioid.getText();
        String nome = txtfuncionome.getText();
        String telefone = txtfunciotelefone.getText();
        String endereco = txtfuncioendereco.getText();
        Funcionario funcionario = tb_funcionarios.getSelectionModel().getSelectedItem();

        if(funcionario != null) {
            if (!Alerts.checkTextFields2(id, nome, telefone, endereco)) {
                Alerts.showAlert("Erro", "por favor preencha os campos necessários");
            }else {

                funcionario.setId(Integer.parseInt(id));
                funcionario.setNome(nome);
                funcionario.setTelefone(telefone);
                funcionario.setEndereco(endereco);
                updateFuncionario(funcionario);

                tb_funcionarios.refresh();

            }

        }
    }


    //Método para criar um Registro na TableView
    @FXML
    private void saveFuncionarioEvt(ActionEvent event){
        String nome = txtfuncionome.getText();
        String telefone = txtfunciotelefone.getText();
        String endereco = txtfuncioendereco.getText();
        Funcionario funcionario = new Funcionario();

        if(!Alerts.checkTextFields2(nome, telefone, endereco)){
            Alerts.showAlert("Erro" ,"por favor preencha os campos necessários");
        }

        funcionario.setNome(nome);
        funcionario.setTelefone(telefone);
        funcionario.setEndereco(endereco);
        saveFuncionario(funcionario);

        tb_funcionarios.getItems().add(funcionario);



    }

    //Método para apagar um Registro da TableView.
    @FXML
    private void deleteFuncionarioEvt(ActionEvent event) {

        Funcionario funcionario = tb_funcionarios.getSelectionModel().getSelectedItem();
        if (funcionario != null)
            deleteFuncionario(funcionario);
        tb_funcionarios.getItems().remove(funcionario);
        tb_funcionarios.refresh();

    }

    //Método para criar um registro na TableView de Produtos.
    @FXML
    private void saveProdutosEvt(ActionEvent event){
    String nome = txtprodutosnome.getText();
    String prazo = txtprodutosprazo.getText();
    String categoria = txtprodutoscategoria.getText();
    String valor = txtprodutosvalor.getText();
    Produtos produtos = new Produtos();

    if(!Alerts.checkTextFields2(nome, prazo, categoria, valor)){
        Alerts.showAlert("Erro", "por favor preencha os campos necessários.");
    }

    float x = Float.parseFloat(valor);

    Date getTime = converterData(prazo);
    ;
    if(getTime == null){
        Alerts.showAlert("Erro", "Formato de Data Inválida.");
    }

    String newDate = formatarData(getTime);

    produtos.setNome(nome);
    produtos.setPrazo(getTime);
    produtos.setCategoria(categoria);
    produtos.setValor(x);
    saveProdutos(produtos);


    tb_produtos.getItems().add(produtos);
    tb_produtos.refresh();


    }

    //Método para atualizar um registro na tableview de produtos.
    @FXML
    private void updateProdutosEvt(ActionEvent event){
    String id = txtprodutosid.getText();
    String nome = txtprodutosnome.getText();
    String prazo = txtprodutosprazo.getText();
    String categoria = txtprodutoscategoria.getText();
    String valor = txtprodutosvalor.getText();
    Produtos produtos = tb_produtos.getSelectionModel().getSelectedItem();

       if(produtos != null) {
           if (!Alerts.checkTextFields2(nome, prazo, categoria, valor)) {
               Alerts.showAlert("Erro", "por favor preencha os campos.");
           }

           float pass = Float.parseFloat(valor);
           Date getTime = converterData(prazo);

           if (getTime == null) {
                Alerts.showAlert("Erro", "formato de data Inválido");
           }

       produtos.setId(Integer.parseInt(id));
       produtos.setNome(nome);
       produtos.setPrazo(getTime);
       produtos.setCategoria(categoria);
       produtos.setValor(pass);
       updateProdutos(produtos);

       tb_produtos.refresh();

       }


    }

    //Método de Deletar um registro da tableView
    @FXML
    private void deleteProdutosEvt(ActionEvent event){

        Produtos produtos = tb_produtos.getSelectionModel().getSelectedItem();
        if(produtos != null){
            DELETE.deleteProdutos(produtos);
        }

        tb_produtos.getItems().remove(produtos);
        tb_produtos.refresh();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    // precisamos converter para observablelist para setar os items
    loadList();
    loadPerfil();
    inicializaTables();


    }

}
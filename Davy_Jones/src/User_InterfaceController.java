/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author uriel
 */
public class User_InterfaceController implements Initializable {

    @FXML
    private ImageView Image;
    
    Usuário user = new Usuário();
    
    UsuárioDAO dao = new UsuárioDAO();

    private Stage dialogStage;
    
    private Principal principal;
    
    @FXML
    private TextField Nome_Usuario;
    @FXML
    private Label id;
    @FXML
    private Label xp;
    @FXML
    private Label vitorias;
    @FXML
    private Label derrotas;
    @FXML
    private Label jogadas;
    @FXML
    private Label info;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //this.user.setID(dao.user.getID());
        //this.user.setSenha(dao.user.getSenha());
     
            this.user = Sessao.usuarioLogado;
            
            System.out.println("Teste de FUNCIONALIDADE: ");
            System.out.println("Id_GamePlay: " + this.user.getID());
            System.out.println("user: " + this.user.getNome());
            System.out.println("jogadas_: " + this.user.getJogadas());
            System.out.println("vitorias_: " + this.user.getVitorias());
            System.out.println("derrotas_: " + this.user.getDerrotas());
            System.out.println("Experience: " + this.user.getXP());
            System.out.println("Senha: " + this.user.getSenha());
            
            System.out.println("Se não houver retornado 0 ou null, a aplicação funciona.");
            
            this.id.setText(Integer.toString(this.user.getID()));
            this.Nome_Usuario.setText(this.user.getNome());
            this.jogadas.setText(Integer.toString(this.user.getJogadas()));
            this.vitorias.setText(Integer.toString(this.user.getVitorias()));
            this.derrotas.setText(Integer.toString(this.user.getDerrotas()));
            this.xp.setText(Integer.toString(this.user.getXP()));
            
    }    
    
    public void setMainApp(Principal principal){
        this.principal = principal;
    }
    
    public void setDialogStage (Stage dialogStage){
        this.dialogStage = dialogStage; 
    }

    @FXML
    private void Salvar_Dado(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (this.user.getNome() != null){
            
            dao.UpdateNome(Sessao.usuarioLogado.getID(), this.Nome_Usuario.toString());
            
        }else{
            System.out.print("Você não tem permissão para isso");
            info.setText("Você não tem permissão para isso");
        }
    }

    @FXML
    private void Close(ActionEvent event) throws Throwable {
        
        dialogStage.close();
        
    }

    @FXML
    private void Sair(ActionEvent event) {
        dao.LogOff();
        dialogStage.close();
        
    }
    
}

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Log_OnController implements Initializable {
    
    User_InterfaceController control = new User_InterfaceController();
    Usuário user = new Usuário();
    
    @FXML
    private TextField fieldUsuario;
    @FXML
    private PasswordField fieldSenha;
    
    private Stage STAGE;
    
    private Principal PRINCIPIA;
    
    @FXML
    private Label Info;
    @FXML
    private AnchorPane ancora;

    public void setMainApp(Principal principal){
        this.PRINCIPIA = principal;
    }
    
    public void setDialogStage (Stage dialogStage){
        this.STAGE = dialogStage; 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void computFieds(ActionEvent event) throws ClassNotFoundException, SQLException{
        
        int x=0;
        
        int a = Integer.parseInt(this.fieldUsuario.getText());
        String b = this.fieldSenha.getText();
        
        try {
            this.user = this.control.dao.LogOn(a, b);
            
            Sessao.usuarioLogado = this.user;
            
        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.print(e.fillInStackTrace());
            
        } finally {
            
            this.STAGE.close();
            
        }
        
        this.control.user = this.user;
        
    }
    
    public void setInfo(Label Info){
        
        this.Info = Info;
        
    }
    
    @FXML
    private void CancelButton(ActionEvent event) {
        
        this.STAGE.close();
        
    }

}

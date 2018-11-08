import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Cadastro_NewController implements Initializable {

    @FXML
    private PasswordField Senha_ID;
    @FXML
    private TextField Usuário_ID;

    UsuárioDAO dao = new UsuárioDAO();
    
    private Stage STAGE;

    private Principal PRINCIPIA;
    
    public void setMainApp(Principal principal){
        this.PRINCIPIA = principal;
    }
    
    public void setDialogStage (Stage dialogStage){
        this.STAGE = dialogStage; 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Cadastro(ActionEvent event) throws ClassNotFoundException {
        
        String x = this.Usuário_ID.toString();
        String y = this.Usuário_ID.toString();
        this.dao.newGamer(x, y);
        
    }

    @FXML
    private void Cancel_Button(ActionEvent event) {
        
        STAGE.close();
    }
    
}

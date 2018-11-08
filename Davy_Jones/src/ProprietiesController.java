import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ProprietiesController implements Initializable {

   
    
    // Relativo ao Principal.JAVA
    
    private Principal Mains;
    private Stage dialogScene;
    private ComboBox<?> itens;
    @FXML
    private CheckBox EnableSpecialCPU;
    @FXML
    private CheckBox EnableCPUGiveUp;
    @FXML
    private CheckBox EnableCPUPassTurn;
    @FXML
    private CheckBox EnableD20True;

    public void setMainApp(Principal principal){
        this.Mains = principal;
        
    }
    
    public void setDialogScene (Stage dialogScene){
        
        this.dialogScene = dialogScene;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void Sopa(ActionEvent event) {
        Sessao.pontuation = 50;
        this.EnableD20True.setSelected(true);
        Sessao.enableD20 = true;
        this.EnableSpecialCPU.setSelected(false);
        Sessao.enableCPUEspecial = false;
        this.EnableCPUGiveUp.setSelected(true);
        Sessao.enableCPUGiveUp = true;
        this.EnableCPUPassTurn.setSelected(true);
        Sessao.enableCPUPassTurn = true;
        
    }

    @FXML
    private void EasyPeeze(ActionEvent event) {
        Sessao.pontuation = 75;
        this.EnableD20True.setSelected(true);
        Sessao.enableD20 = true;
        this.EnableSpecialCPU.setSelected(false);
        Sessao.enableCPUEspecial = false;
        this.EnableCPUGiveUp.setSelected(true);
        Sessao.enableCPUGiveUp = true;
        this.EnableCPUPassTurn.setSelected(true);
        Sessao.enableCPUPassTurn = true;
        
        
    }

    @FXML
    private void Regular(ActionEvent event) {
        Sessao.pontuation = 85;
        Sessao.enableD20 = false;
        Sessao.enableCPUEspecial = true;
        Sessao.enableCPUGiveUp = true;
        Sessao.enableCPUPassTurn = true;
    }

    @FXML
    private void Hardway(ActionEvent event) {
        Sessao.pontuation = 100;
        this.EnableD20True.setSelected(false);
        Sessao.enableD20 = false;
        this.EnableSpecialCPU.setSelected(true);
        Sessao.enableCPUEspecial = true;
        this.EnableCPUGiveUp.setSelected(true);
        Sessao.enableCPUGiveUp = true;
        this.EnableCPUPassTurn.setSelected(false);
        Sessao.enableCPUPassTurn = false;
    }

    @FXML
    private void MaesteOfDV(ActionEvent event) {
        Sessao.pontuation = 200;
        this.EnableD20True.setSelected(false);
        Sessao.enableD20 = false;
        this.EnableSpecialCPU.setSelected(true);
        Sessao.enableCPUEspecial = true;
        this.EnableCPUGiveUp.setSelected(false);
        Sessao.enableCPUGiveUp = false;
        this.EnableCPUPassTurn.setSelected(false);
        Sessao.enableCPUPassTurn = false;
    }

    @FXML
    private void setCPUEspecial(ActionEvent event) {
        
        if (this.EnableSpecialCPU.isSelected() == true){
            Sessao.enableCPUEspecial = true;
            
        }else{
            Sessao.enableCPUEspecial = false;
            
        }
        
    }

    @FXML
    private void setCPUGiveUp(ActionEvent event) {
        
        if (this.EnableCPUGiveUp.isSelected() == true){
            Sessao.enableCPUGiveUp = true;
        }else{
            Sessao.enableCPUGiveUp = false;
        }
        
    }

    @FXML
    private void setCPUPassTurn(ActionEvent event) {
        
        if (this.EnableCPUPassTurn.isSelected() == true){
            Sessao.enableCPUPassTurn = true;
            
        }else{
            Sessao.enableCPUPassTurn = false;
            
        }
        
    }

    @FXML
    private void setD20True(ActionEvent event) {
        
        if (this.EnableD20True.isSelected() == true){
            Sessao.enableD20 = true;
            
        }else{
              Sessao.enableD20 = false;
            
        }
        
    }

    @FXML
    private void exit(ActionEvent event) {
        this.dialogScene.close();
        
    }
    
}

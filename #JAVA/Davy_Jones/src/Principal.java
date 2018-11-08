import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;


public class Principal extends Application{
    
        private Stage primary;
        private AnchorPane rootLayout;
	
	public static void main(String[] args){
	
            launch();
            
        }
        
        @Override
        public void start(Stage stage) throws IOException{
        
            this.primary = stage;
            this.primary.setTitle("Davy Jones");
            
            janelaRaiz();
            
        }
        
        public void janelaRaiz() {
            
            try {
                
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("Jones.fxml"));
                rootLayout = load.load();
                
                Scene scene =  new Scene(rootLayout);
                primary.setScene(scene);
                primary.show();
                
                JonesController control = load.getController();
                control.setMainApp(this);
                
            } catch (IOException ex) {
                System.out.print(ex);
            }
            
        }
        
        public void janelaUsuario_Profile(){
            
            try {
                
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("User_Interface.fxml"));
                AnchorPane ancora = (AnchorPane)load.load();
                
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(primary);
                
                Scene scene = new Scene(ancora);
                dialogStage.setScene(scene);
                
                // Acesso:
                
                User_InterfaceController control = load.getController();
                control.setDialogStage(dialogStage);
                control.setMainApp(this);
                
                dialogStage.showAndWait();
                
            } catch (IOException ex) {
                System.out.print(ex);
            }
            
        }
        
        public void janelaUsuario_logOn(){
            
                
                try {
                
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("LogOn.fxml"));
                AnchorPane ancora = (AnchorPane)load.load();
                
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(primary);
                
                Scene scene = new Scene(ancora);
                dialogStage.setScene(scene);
                
                // Acesso:
                
                Log_OnController control = load.getController();
                control.setDialogStage(dialogStage);
                control.setMainApp(this);
                
                dialogStage.showAndWait();
                
            } catch (IOException ex) {
                System.out.print(ex);
            }
                
        }
        
        public void janelaUsuario_Cadastro(){
            
                
                try {
                
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("Cadastro_New.fxml"));
                AnchorPane ancora = (AnchorPane)load.load();
                
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(primary);
                
                Scene scene = new Scene(ancora);
                dialogStage.setScene(scene);
                
                // Acesso:
                
                Cadastro_NewController control = load.getController();
                control.setDialogStage(dialogStage);
                control.setMainApp(this);
                
                dialogStage.showAndWait();
                
            } catch (IOException ex) {
                System.out.print(ex);
            }
                
        }
        
        public void janelaPropriedades(){
            
                
                try {
                
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("Proprieties.fxml"));
                AnchorPane ancora = (AnchorPane)load.load();
                
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(primary);
                
                Scene scene = new Scene(ancora);
                dialogStage.setScene(scene);
                
                // Acesso:
                
                ProprietiesController control = load.getController();
                control.setDialogScene(dialogStage);
                control.setMainApp(this);
                
                dialogStage.showAndWait();
                
            } catch (IOException ex) {
                System.out.print(ex);
            }
                
        }

    void fire() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
}	

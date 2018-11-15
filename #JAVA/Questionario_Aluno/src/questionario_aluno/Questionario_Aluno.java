package questionario_aluno;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * It is the eggxecutor, please ignore.
 * ~~Uriel Anderson de Oliveira LasHeras
 */
public class Questionario_Aluno extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

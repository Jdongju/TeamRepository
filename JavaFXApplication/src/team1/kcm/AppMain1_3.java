package team1.kcm;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain1_3 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("root1.fxml")); 
        
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Panel"); 
        primaryStage.show();
				primaryStage.setMaxWidth(800);
				primaryStage.setMaxHeight(480);
				
       
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

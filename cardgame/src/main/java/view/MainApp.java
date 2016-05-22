package view;

import javafx.application.Application;
import static javafx.application.Application.launch;

import com.sun.glass.ui.Cursor;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Card;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       // Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Parent node = FXMLLoader.load(getClass().getResource("/fxml/Choose.fxml"));
    	
        //Scene scene = new Scene(root); 
        Scene scene2 = new Scene(node); 
        //scene2.setCursor(javafx.scene.Cursor.CROSSHAIR);
        stage.setTitle("Card Game");
        
        stage.setScene(scene2);
        stage.show();
        //stage.setScene(scene);
        stage.setResizable(false);
       // stage.show();
        
    }

    /**
     * Java Doc O.o.
     * 
     * 
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

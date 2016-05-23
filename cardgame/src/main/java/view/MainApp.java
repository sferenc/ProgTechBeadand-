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

//CHECKSTYLE:OFF
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent node = FXMLLoader.load(getClass().getResource("/fxml/Choose.fxml"));  	

        Scene scene2 = new Scene(node); 
        //scene2.setCursor(javafx.scene.Cursor.CROSSHAIR);
        stage.setTitle("Card Game");        
        stage.setScene(scene2);
        stage.show();
        stage.setResizable(false);

        
    }

    public static void main(String[] args) {
        launch(args);
    }

}

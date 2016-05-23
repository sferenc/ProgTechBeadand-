package view;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
//CHECKSTYLE:OFF
public class ChooseController implements Initializable{
	// CHECKSTYLE:ON

	@FXML 
	Button button,button2;
	
	@FXML 
	private ColorPicker colorPicker1,colorPicker2;
	
	@FXML
	TextField player1Name,player2Name;

	@FXML
	private void buttonAction2(ActionEvent event){
		System.out.println(colorPicker1.getValue());	
	}
	
	@FXML
	private void setName(KeyEvent event){
		if (event.getSource()==player1Name){
			if((!player1Name.getText().equals(""))){
			Players.player1name=player1Name.getText();
			}
		}
		if (event.getSource()==player2Name){
			if((!player2Name.getText().equals(""))){
			Players.player2name=player2Name.getText();
			}
		}
	}
	
	@FXML
	private void setColor(ActionEvent event){
		if (event.getSource()==colorPicker1){
			Players.player1color=colorPicker1.getValue();
			light1.setColor(colorPicker1.getValue());
		}
		else{
			Players.player2color=colorPicker2.getValue();
			light2.setColor(colorPicker2.getValue());
		}
	}
	
	@FXML
    private void buttonAction(MouseEvent event) throws Exception {        
        
		if ((Players.player1name.equals(Players.player2name))||(Players.player1color.equals(Players.player2color))){
			startScreen.setText("You cannot choose the same playername or the same color! Please choose different!");
		}
		else{
        Parent root=FXMLLoader.load(ChooseController.class.getResource("/fxml/Scene.fxml"));
        Stage stage=(Stage) button.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
		}
        
    }
	
	@FXML
	PointLight light1,light2;
	@FXML
	Sphere sphere1,sphere2;
	@FXML
	Label startScreen;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Players.player1color=Color.RED;
		Players.player2color=Color.DEEPPINK;
		Players.player1name="Player1";
		Players.player2name="Player2";
		light1.setColor(Color.RED);
		light1.setTranslateX(50);
	    light1.setTranslateY(50);
	    light1.setTranslateZ(-100);
	    light1.setRotate(90);
	    light2.setColor(Color.DEEPPINK);
		light2.setTranslateX(50);
	    light2.setTranslateY(50);
	    light2.setTranslateZ(-100);
	    light2.setRotate(90);
			
	}

	
}

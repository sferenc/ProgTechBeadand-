package controller;

import java.net.URL;
import java.util.stream.*;

import com.sun.javafx.application.LauncherImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Card;

public class FXMLController implements Initializable {
	
	GameController game = new GameController();	
	Card randomCard1=game.randomcard();
	Card randomCard2=game.randomcard();
	Card randomCard3=game.randomcard();
	
	@FXML
	private Label playerTurnLabel,scoreboard,val1,val2,val3,val4,val5,
	chooseAbleTop1,chooseAbleTop2,chooseAbleTop3,
	chooseAbleBottom1,chooseAbleBottom2,chooseAbleBottom3,
	chooseAbleCardName1,chooseAbleCardName2,chooseAbleCardName3,
	chooseAbleLeft1,chooseAbleLeft2,chooseAbleLeft3,
	chooseAbleRight1,chooseAbleRight2,chooseAbleRight3,
	top11,top12,top13,top14,top21,top22,top23,top24,top31,top32,top33,top34,top41,top42,top43,top44,
	bottom11,bottom12,bottom13,bottom14,bottom21,bottom22,bottom23,bottom24,bottom31,bottom32,bottom33,bottom34,bottom41,bottom42,bottom43,bottom44,
	cardName11,cardName12,cardName13,cardName14,cardName21,cardName22,cardName23,cardName24,cardName31,cardName32,cardName33,cardName34,cardName41,cardName42,cardName43,cardName44,
	left11,left12,left13,left14,left21,left22,left23,left24,left31,left32,left33,left34,left41,left42,left43,left44,
	right11,right12,right13,right14,right21,right22,right23,right24,right31,right32,right33,right34,right41,right42,right43,right44;

	private Label[][] fieldtops,fieldbottoms,fieldnames,fieldlefts,fieldrights;
	private Label[][][] fields;
	
	private String[][] cardnames;
	private int[][] tops;
	private int[][] bottoms;
	private int[][] lefts;
	private int[][] right;
	
	private int cardIdentifier=0;
	private boolean reseter=true;
	private int ending=0;
	private boolean turn=true;
	
	
	@FXML
    private BorderPane random1,random2,random3,
    clickable11,clickable12,clickable13,clickable14,clickable21,clickable22,clickable23,clickable24,
    clickable31,clickable32,clickable33,clickable34,clickable41,clickable42,clickable43,clickable44;
	private BorderPane[][] clickables;
	
	@FXML
	private Rectangle rect11,rect12,rect13,rect14,rect21,rect22,rect23,rect24,rect31,rect32,rect33,rect34,rect41,rect42,rect43,rect44,crect1,crect2,crect3;
	private Rectangle[][] rectangles;
	private Rectangle[] crects;
	
	@FXML
	private MenuItem newG;
	
	/*@FXML
	private static void ac(ActionEvent event) {
	    System.out.println("Róland egy köcsög");
	}*/

	@FXML
	private void reset(MouseEvent event){
		if (reseter){
			randomCard1=game.randomcard();
			randomCard2=game.randomcard();
			randomCard3=game.randomcard();
			game.graphics(randomCard1, chooseAbleCardName1, chooseAbleBottom1, chooseAbleTop1, chooseAbleLeft1, chooseAbleRight1);
			game.graphics(randomCard2, chooseAbleCardName2, chooseAbleBottom2, chooseAbleTop2, chooseAbleLeft2, chooseAbleRight2);
			game.graphics(randomCard3, chooseAbleCardName3, chooseAbleBottom3, chooseAbleTop3, chooseAbleLeft3, chooseAbleRight3);
			reseter=false;
		}
	}
	
	
	@FXML
	private void onRandomCardClick(MouseEvent event) {  
		 if (event.getSource()==random1){	
			 cardIdentifier=1;		
			 val1.setText(randomCard1.getName());
			 val2.setText(randomCard1.getTop()+"");
			 val3.setText(randomCard1.getBottom()+"");
			 val4.setText(randomCard1.getRight()+"");
			 val5.setText(randomCard1.getLeft()+"");
			 
			 
			 //System.out.println(randomCard1.getTop());			 
		    } else if (event.getSource()==random2) {
		    	cardIdentifier=2;
		   	 val1.setText(randomCard2.getName());
			 val2.setText(randomCard2.getTop()+"");
			 val3.setText(randomCard2.getBottom()+"");
			 val4.setText(randomCard2.getRight()+"");
			 val5.setText(randomCard2.getLeft()+"");
		    	//System.out.println(randomCard2.getTop());
		    } else if (event.getSource()==random3) {
		    	cardIdentifier=3;
		   	 val1.setText(randomCard3.getName());
			 val2.setText(randomCard3.getTop()+"");
			 val3.setText(randomCard3.getBottom()+"");
			 val4.setText(randomCard3.getRight()+"");
			 val5.setText(randomCard3.getLeft()+"");
		    	//System.out.println(randomCard3.getTop());
		    } else {
		    	System.out.println("Róland egy köcsög!");
		    }
	}
	
	@FXML
	private void onAvailableFieldClicked(MouseEvent event) {  	 
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if (event.getSource()==clickables[i][j]) {
					if(cardIdentifier==1){
						cardIdentifier=game.setCardSlot(i, j, cardIdentifier, fields, randomCard1, rectangles, turn);				
						turn=game.playersTurn(turn, playerTurnLabel, cardIdentifier,crects);
						if(cardIdentifier==0){
							ending+=game.ifEndCounter(ending, rectangles, scoreboard,playerTurnLabel);
							randomCard1=game.randomcard();
							game.graphics(randomCard1, chooseAbleCardName1, chooseAbleBottom1, chooseAbleTop1, chooseAbleLeft1, chooseAbleRight1);
							reseter=true;
						}
					}
					if(cardIdentifier==2){
						cardIdentifier=game.setCardSlot(i, j, cardIdentifier, fields, randomCard2, rectangles, turn);					
						turn=game.playersTurn(turn, playerTurnLabel, cardIdentifier,crects);
						if(cardIdentifier==0){
							ending+=game.ifEndCounter(ending, rectangles, scoreboard,playerTurnLabel);
							randomCard2=game.randomcard();
							game.graphics(randomCard2, chooseAbleCardName2, chooseAbleBottom2, chooseAbleTop2, chooseAbleLeft2, chooseAbleRight2);
							reseter=true;
						}
					}
					if(cardIdentifier==3){
						cardIdentifier=game.setCardSlot(i, j, cardIdentifier, fields, randomCard3, rectangles, turn);						
						turn=game.playersTurn(turn, playerTurnLabel, cardIdentifier,crects);
						if(cardIdentifier==0){
							ending+=game.ifEndCounter(ending, rectangles, scoreboard,playerTurnLabel);
							randomCard3=game.randomcard();
							game.graphics(randomCard3, chooseAbleCardName3, chooseAbleBottom3, chooseAbleTop3, chooseAbleLeft3, chooseAbleRight3);
							reseter=true;
						}
					}
				}
			}
		}
		 
	}
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {	
    	//REKT.setFill(Color.RED);
    	crects=new Rectangle[]{crect1,crect2,crect3};
    	for (int i=0;i<3;i++) crects[i].setFill(Color.RED);
    	rectangles=new Rectangle[][]{
			{rect11,rect12,rect13,rect14},
			{rect21,rect22,rect23,rect24},
			{rect31,rect32,rect33,rect34},
			{rect41,rect42,rect43,rect44}};
    	fieldbottoms=new Label[][]{
			{bottom11,bottom12,bottom13,bottom14},
			{bottom21,bottom22,bottom23,bottom24},
			{bottom31,bottom32,bottom33,bottom34},
			{bottom41,bottom42,bottom43,bottom44}};
		fieldtops=new Label[][]{
			{top11,top12,top13,top14},
			{top21,top22,top23,top24},
			{top31,top32,top33,top34},
			{top41,top42,top43,top44}};
		fieldnames=new Label[][]{
			{cardName11,cardName12,cardName13,cardName14},
			{cardName21,cardName22,cardName23,cardName24},
			{cardName31,cardName32,cardName33,cardName34},
			{cardName41,cardName42,cardName43,cardName44}};
		fieldlefts=new Label[][]{
			{left11,left12,left13,left14},
			{left21,left22,left23,left24},
			{left31,left32,left33,left34},
			{left41,left42,left43,left44}};
		fieldrights=new Label[][]{
			{right11,right12,right13,right14},
			{right21,right22,right23,right24},
			{right31,right32,right33,right34},
			{right41,right42,right43,right44}};			
		fields=new Label[][][]{fieldtops,fieldbottoms,fieldnames,fieldlefts,fieldrights};
		clickables=new BorderPane[][]{
			{clickable11,clickable12,clickable13,clickable14},
			{clickable21,clickable22,clickable23,clickable24},
			{clickable31,clickable32,clickable33,clickable34},
			{clickable41,clickable42,clickable43,clickable44}};
			playerTurnLabel.setText("Válassz 1 kártyát a legördülő listából!(vörös játékos köre)");
    	game.graphics(randomCard1, chooseAbleCardName1, chooseAbleBottom1, chooseAbleTop1, chooseAbleLeft1, chooseAbleRight1);
    	game.graphics(randomCard2, chooseAbleCardName2, chooseAbleBottom2, chooseAbleTop2, chooseAbleLeft2, chooseAbleRight2);
    	game.graphics(randomCard3, chooseAbleCardName3, chooseAbleBottom3, chooseAbleTop3, chooseAbleLeft3, chooseAbleRight3);
    }    
}

package view;

import java.net.URL;
import java.util.stream.*;

import com.sun.javafx.application.LauncherImpl;

import controller.GameController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Card;

public class FXMLController implements Initializable {
	
	GameController game = new GameController();	
	Card[] randomCards;
	
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

	private Label[][] fieldtops,fieldbottoms,fieldnames,fieldlefts,fieldrights,chooseables;
	private Label[][][] fields;
	
	private int cardIdentifier=0;
	private boolean reseter=true;
	private int ending=0;
	private boolean turn=Players.turn;
	
	private int ifEndCounter(int count){
		if (count==15){
			int first=0,second=0;
			for (int i=0;i<4;i++){
				for (int j=0;j<4;j++){
					if (rectangles[i][j].getFill()==Players.player1color){
						first++;
					}
					if (rectangles[i][j].getFill()==Players.player2color){
						second++;
					}
				}
			}
			if (first>second){
				scoreboard.setText("Congratulation "+Players.player1name+" you WON!\n \tWith "+first+"-"+second+" score !");
			}
			if (first<second){
				scoreboard.setText("Congratulation "+Players.player2name+" you WON!\n \tWith "+second+"-"+first+" score !");
			}
			if (first==second){
				scoreboard.setText("The game ended in a draw!");
			}
			playerTurnLabel.setText("Please Quit");
			return 420;
		} else return 1;
	}
	
	int setCardSlot(int row,int column,Card rcard){
		if (game.isAvailableCardSlot(row, column)){
			if(turn) rectangles[column][row].setFill(Players.player1color);
			else rectangles[column][row].setFill(Players.player2color);
			fields[0][row][column].setText(rcard.getTop()+"");
			fields[1][row][column].setText(rcard.getBottom()+"");
			fields[2][row][column].setText(rcard.getName());
			fields[3][row][column].setText(rcard.getLeft()+"");
			fields[4][row][column].setText(rcard.getRight()+"");
			return 0;
		} else return cardIdentifier;
	}
	
	private void graphics(Card card,int index){
    	chooseables[0][index].setText(card.getTop()+"");
    	chooseables[1][index].setText(card.getBottom()+"");
    	chooseables[2][index].setText(card.getName());
    	chooseables[3][index].setText(card.getLeft()+"");
    	chooseables[4][index].setText(card.getRight()+"");
	}
	
	private void turnColor(){
		if (!turn){
			playerTurnLabel.setText(Players.player2name+"'s trun!"); 
			for (int i=0;i<3;i++) crects[i].setFill(Players.player2color);
		}
		else {
			playerTurnLabel.setText(Players.player1name+"'s turn!");
			for (int i=0;i<3;i++) crects[i].setFill(Players.player1color);
		}
	}
	
	private void colorChanger(int row,int column){
		if (game.rightHigher(row, column)){
			if (turn) rectangles[column+1][row].setFill(Players.player2color);
				else rectangles[column+1][row].setFill(Players.player1color);
		}
		if (game.leftHigher(row, column)){
			if (turn) rectangles[column-1][row].setFill(Players.player2color);
				else rectangles[column-1][row].setFill(Players.player1color);
		}
		if (game.topHigher(row, column)){
			if (turn) rectangles[column][row-1].setFill(Players.player2color);
				else rectangles[column][row-1].setFill(Players.player1color);
		}
		if (game.bottomHigher(row, column)){
			if (turn) rectangles[column][row+1].setFill(Players.player2color);
				else rectangles[column][row+1].setFill(Players.player1color);
		}
	}
	
	
	@FXML
    private BorderPane random1,random2,random3,
    clickable11,clickable12,clickable13,clickable14,clickable21,clickable22,clickable23,clickable24,
    clickable31,clickable32,clickable33,clickable34,clickable41,clickable42,clickable43,clickable44;
	private BorderPane[] randoms;
	private BorderPane[][] clickables;
	
	@FXML
	private Rectangle rect11,rect12,rect13,rect14,rect21,rect22,rect23,rect24,rect31,rect32,rect33,rect34,rect41,rect42,rect43,rect44,crect1,crect2,crect3;
	private Rectangle[][] rectangles;
	private Rectangle[] crects;
	
	@FXML
	private MenuItem newG;
	
	@FXML
	private Button button;

	@FXML
	private void reset(MouseEvent event){
		if (reseter){
			for (int k=0;k<3;k++){
				randomCards[k]=game.randomcard();
				graphics(randomCards[k], k);
			}
			reseter=false;
		}
	}
	
	
	@FXML
	private void onRandomCardClick(MouseEvent event) {  
		 for (int k=0;k<3;k++){
			 if (event.getSource()==randoms[k]){
				 cardIdentifier=k+1;
				 val1.setText(randomCards[k].getName());
				 val2.setText(randomCards[k].getTop()+"");
				 val3.setText(randomCards[k].getBottom()+"");
				 val4.setText(randomCards[k].getRight()+"");
				 val5.setText(randomCards[k].getLeft()+"");
			 }
		 }
	}
	
	@FXML
	private void onAvailableFieldClicked(MouseEvent event) {  	 
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if (event.getSource()==clickables[i][j]) {				
					for (int k=0;k<3;k++){
						if(cardIdentifier==k+1){
							cardIdentifier=setCardSlot(i, j, randomCards[k]);									
							turn=game.turnChange(turn, cardIdentifier);	
							turnColor();
							if(cardIdentifier==0){
								game.storeData(i, j, randomCards[k]);
								colorChanger(i, j);
								ending+=ifEndCounter(ending);
								randomCards[k]=game.randomcard();
								graphics(randomCards[k], k);
								reseter=true;
							}
						}
					}
				}
			}
		}
		 
	}
	
    @Override
    public void initialize(URL url, ResourceBundle rb) { 	
    	crects=new Rectangle[]{crect1,crect2,crect3};
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
		chooseables=new Label[][]{
			{chooseAbleTop1,chooseAbleTop2,chooseAbleTop3},
			{chooseAbleBottom1,chooseAbleBottom2,chooseAbleBottom3},
			{chooseAbleCardName1,chooseAbleCardName2,chooseAbleCardName3},
			{chooseAbleLeft1,chooseAbleLeft2,chooseAbleLeft3},
			{chooseAbleRight1,chooseAbleRight2,chooseAbleRight3}};
		randoms=new BorderPane[]{random1,random2,random3};
		clickables=new BorderPane[][]{
			{clickable11,clickable12,clickable13,clickable14},
			{clickable21,clickable22,clickable23,clickable24},
			{clickable31,clickable32,clickable33,clickable34},
			{clickable41,clickable42,clickable43,clickable44}};		
			if (turn){
				for (int i=0;i<3;i++) crects[i].setFill(Players.player1color);
				playerTurnLabel.setText("Please choose a card from this list ("+ Players.player1name +" köre)");
			}
			else{
				for (int i=0;i<3;i++) crects[i].setFill(Players.player2color);
				playerTurnLabel.setText("Please choose a card from this list ("+ Players.player2name +" köre)");
			}		
		randomCards=new Card[]{game.randomcard(),game.randomcard(),game.randomcard()};
		for (int k=0;k<3;k++){
			graphics(randomCards[k], k);				
		}   	
    }    
}

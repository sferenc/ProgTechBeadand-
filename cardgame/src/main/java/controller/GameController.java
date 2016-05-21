package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import dao.CardDaoJsonImpl;
import dao.CardService;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Card;

public class GameController {
	
	public GameController() {
		
	}

	private int[][] controllTops=new int[5][5];
	private int[][] controllBots=new int[5][5];
	private String[][] controllNames=new String[5][5];
	private int[][] controllLefts=new int[5][5];
	private int[][] controllRights=new int[5][5];
	private Object[][][] controllFields={{controllTops},{controllBots},{controllNames},{controllLefts},{controllRights}};

	
	Card randomcard(){
		CardService service = new CardService(new CardDaoJsonImpl());
		return service.getRandomCard();
	}
	
	void randomcards(Card r1,Card r2,Card r3){
		r1=randomcard();
    	r2=randomcard();
    	r3=randomcard();
	}
	
	void graphics(Card card,Label name,Label bottom,Label top,Label left,Label right){
		name.setText(card.getName());
    	bottom.setText(card.getBottom()+"");
    	top.setText(card.getTop()+"");
    	left.setText(card.getLeft()+"");
    	right.setText(card.getRight()+"");
	}
	
	int setCardSlot(int row,int column,int cardIdentifier,Label fields[][][],Card rcard,Rectangle[][] rect,boolean turn){
		if(fields[2][row][column].getText()==""){
			//System.out.println(fields[2][row][column].getText());
			if(turn) rect[column][row].setFill(Color.RED);
			else rect[column][row].setFill(Color.DEEPPINK);
			fields[0][row][column].setText(rcard.getTop()+"");
			fields[1][row][column].setText(rcard.getBottom()+"");
			fields[2][row][column].setText(rcard.getName());
			fields[3][row][column].setText(rcard.getLeft()+"");
			fields[4][row][column].setText(rcard.getRight()+"");
			changeColors(row, column, fields, rect, turn);
			return 0;
		} else return cardIdentifier;

	}
	
	boolean playersTurn(boolean turn,Label label,int CardIdentifier,Rectangle[] chooseables){
		if (CardIdentifier==0){
			if (turn){
				label.setText("Hupilila játékos következik!"); 
				for (int i=0;i<3;i++) chooseables[i].setFill(Color.DEEPPINK);
			}
			else {
				label.setText("Vörös játékos következik!");
				for (int i=0;i<3;i++) chooseables[i].setFill(Color.RED);
			}
			return !turn;
		}
		else return turn;
	}
	
	@Deprecated
	void storeData(int row,int column,Card card){
		controllFields[0][row][column]=card.getTop();
		controllFields[1][row][column]=card.getBottom();
		controllFields[2][row][column]=card.getName();
		controllFields[3][row][column]=card.getLeft();
		controllFields[4][row][column]=card.getRight();
	} 
	
	void changeColors(int row, int column, Label[][][] fields,Rectangle rect[][],boolean turn){
		if ((column>0) && (fields[0][row][column-1].getText()!="") /*&& (cardIdentifier!=0)*/){
			if (Integer.parseInt(fields[3][row][column].getText())>Integer.parseInt(fields[4][row][column-1].getText())){
				if (turn) rect[column-1][row].setFill(Color.RED);
				else rect[column-1][row].setFill(Color.DEEPPINK);
			}
		}
		if ((column<3) && (fields[0][row][column+1].getText()!="") /*&& (cardIdentifier!=0)*/){
			if (Integer.parseInt(fields[4][row][column].getText())>Integer.parseInt(fields[3][row][column+1].getText())){
				if (turn) rect[column+1][row].setFill(Color.RED);
				else rect[column+1][row].setFill(Color.DEEPPINK);
			}
		}
		if ((row>0) && (fields[0][row-1][column].getText()!="") /*&& (cardIdentifier!=0)*/){
			if (Integer.parseInt(fields[0][row][column].getText())>Integer.parseInt(fields[1][row-1][column].getText())){
				if (turn) rect[column][row-1].setFill(Color.RED);
				else rect[column][row-1].setFill(Color.DEEPPINK);
			}
		}
		if ((row<3) && (fields[0][row+1][column].getText()!="") /*&& (cardIdentifier!=0)*/){
			if (Integer.parseInt(fields[1][row][column].getText())>Integer.parseInt(fields[0][row+1][column].getText())){
				if (turn) rect[column][row+1].setFill(Color.RED);
				else rect[column][row+1].setFill(Color.DEEPPINK);
			}
		}
	}
	
	int ifEndCounter(int count,Rectangle[][] rect,Label label,Label label2){
		if (count==15){
			int first=0,second=0;
			for (int i=0;i<4;i++){
				for (int j=0;j<4;j++){
					if (rect[i][j].getFill()==Color.RED){
						first++;
					}
					if (rect[i][j].getFill()==Color.DEEPPINK){
						second++;
					}
				}
			}
			if (first>second){
				label.setText("Gratulálunk a Vörös nyert!\n \tMéghozzá "+first+"-"+second+" fölénnyel !");
			}
			if (first<second){
				label.setText("Gratulálunk a Hupilila nyert!\n \tMéghozzá "+second+"-"+first+" fölénnyel !");
			}
			if (first==second){
				label.setText("A játék döntetlennel záródott!");
			}
			label2.setText("A Játék mostmár befejeződött");
			return 420;
		} else return 1;
	}
	
}

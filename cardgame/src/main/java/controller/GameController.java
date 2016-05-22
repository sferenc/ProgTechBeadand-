package controller;

import dao.CardDaoJsonImpl;
import dao.CardService;
import model.Card;

public class GameController {
	
	public GameController() {	
	}		

	public GameController(int[][] controllTops, int[][] controllBots, String[][] controllNames, int[][] controllLefts,
			int[][] controllRights) {
		this.controllTops = controllTops;
		this.controllBots = controllBots;
		this.controllNames = controllNames;
		this.controllLefts = controllLefts;
		this.controllRights = controllRights;
	}


	public int[][] controllTops=new int[5][5];
	public int[][] controllBots=new int[5][5];
	public String[][] controllNames=new String[5][5];
	public int[][] controllLefts=new int[5][5];
	public int[][] controllRights=new int[5][5];

	
	public Card randomcard(){
		CardService service = new CardService(new CardDaoJsonImpl());
		return service.getRandomCard();
	}
	
	
	public boolean isAvailableCardSlot(int row,int column){
		if (controllNames[row][column]==null){
			return true;
		}else return false;
	}

	
	public boolean turnChange(boolean turn,int CardIdentifier){
		if (CardIdentifier==0){
			return !turn;
		}
		else return turn;
	}
	
	
	public void storeData(int row,int column,Card card){
		controllTops[row][column]=card.getTop();
		controllBots[row][column]=card.getBottom();
		controllNames[row][column]=card.getName();
		controllLefts[row][column]=card.getLeft();
		controllRights[row][column]=card.getRight();
	} 
	
	public boolean leftHigher(int row,int column){
		if((column>0) && controllNames[row][column-1]!=null){
			if (controllLefts[row][column]>controllRights[row][column-1]){
				return true;
			} else return false;
		} else return false;
	}
	
	public boolean rightHigher(int row,int column){
		if((column<3) && controllNames[row][column+1]!=null){
			if (controllRights[row][column]>controllLefts[row][column+1]){
				return true;
			} else return false;
		} else return false;
	}
	
	public boolean topHigher(int row,int column){
		if((row>0) && controllNames[row-1][column]!=null){
			if (controllTops[row][column]>controllBots[row-1][column]){
				return true;
			} else return false;
		} else return false;
	}
	
	public boolean bottomHigher(int row,int column){
		if((row<3) && controllNames[row+1][column]!=null){
			if (controllBots[row][column]>controllTops[row+1][column]){
				return true;
			} else return false;
		} else return false;
	}
	
}

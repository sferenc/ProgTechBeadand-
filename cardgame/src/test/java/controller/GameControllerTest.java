package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.CardDaoJsonImpl;
import dao.CardService;
import model.Card;

public class GameControllerTest {
	public GameController game;

	public int[][] controllTops;
	public int[][] controllBots;
	public String[][] controllNames;
	public int[][] controllLefts;
	public int[][] controllRights;
	
	public GameController game2;

	@Before
	public void setUp() {	
		game=new GameController();
		controllNames=new String[][]{
			{null,"sajt","kenyér",null},
			{"card1","card2","card3","card4"},
			{"raptop","trex","spino","pterodactyl"},
			{"kaposzta",null,"fikusz","kókusz"}};
		controllBots=new int[][]{{1,2,3,7},{5,6,7,8},{4,5,3,7},{6,7,0,1}};
		controllTops=new int[][]{{1,2,3,4},{5,6,2,8},{4,5,9,9},{9,7,0,1}};
		controllLefts=new int[][]{{1,2,3,4},{5,6,7,8},{4,5,0,7},{9,7,8,0}};
		controllRights=new int[][]{{1,2,3,4},{5,6,7,8},{4,9,8,7},{9,7,8,1}};
		game2=new GameController(controllTops, controllBots, controllNames, controllLefts, controllRights);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void playerTrunTest(){
		assertFalse(game.turnChange(false, 1));
		assertTrue(game.turnChange(false, 0));
		assertTrue(game.turnChange(true, 1));
		assertFalse(game.turnChange(true, 0));
	}
	
	@Test
	public void availableCardSlotTest(){
		assertTrue(game2.isAvailableCardSlot(0, 0));
		assertFalse(game2.isAvailableCardSlot(1, 1));
	}
	
	@Test
	public void containsRandomCard(){
		CardDaoJsonImpl dao= new CardDaoJsonImpl();
		assertTrue(dao.getCards().contains(game.randomcard()));
	}
	
	@Test
	public void doesItReallyStoreData(){
		game2.storeData(1, 1, new Card("Rekt",1,2,3,4));
		assertEquals("Rekt", controllNames[1][1]);
	}
	
	@Test
	public void theLeftIsReallyHigher(){
		assertFalse(game2.leftHigher(0, 0));
		assertFalse(game2.leftHigher(0, 1));
		assertTrue(game2.leftHigher(1, 1));
		assertFalse(game2.leftHigher(3, 3));
		
	}
	
	@Test
	public void theRightIsReallyHigher(){
		assertFalse(game2.rightHigher(0, 3));
		assertFalse(game2.rightHigher(0, 2));
		assertTrue(game2.rightHigher(2, 2));
		assertFalse(game2.rightHigher(1, 2));
		
	}
	
	@Test
	public void theTopIsReallyHigher(){
		assertFalse(game2.topHigher(0, 3));
		assertFalse(game2.topHigher(1, 0));
		assertTrue(game2.topHigher(2, 3));
		assertFalse(game2.topHigher(1, 2));
		
	}
	
	@Test
	public void theBottomIsReallyHigher(){
		assertFalse(game2.bottomHigher(3, 3));
		assertFalse(game2.bottomHigher(2, 1));
		assertTrue(game2.bottomHigher(1, 1));
		assertFalse(game2.bottomHigher(1, 2));
		
	}

}

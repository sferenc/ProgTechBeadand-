package controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.CardDao;
import dao.CardDaoJsonImpl;
import dao.CardService;
import model.Card;

public class GameControllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void randomtest(){
		CardDaoJsonImpl dao=new CardDaoJsonImpl();
		List<Card>cards=dao.getCards();
		GameController game=new GameController();
		Card randomcard=game.randomcard();
		Boolean contains;
		if (cards.contains(randomcard)) contains=true;
		else contains=false;
		assertTrue(contains);
		
	}

}

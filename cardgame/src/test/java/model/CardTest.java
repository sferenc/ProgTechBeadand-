package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	Card card;
	
	@Before
	public void setUp() {	
		card=new Card("Example", 1, 2, 3, 4);
	}
	
	@Test
	public void equalsTest() {
		assertTrue(card.equals(new Card("Example", 1, 2, 3, 4)));
	}
	
	@Test
	public void modelConstructorTest() {
		assertEquals(new Card("Example", 1, 2, 3, 4), card);												
	}
	
	@Test 
	public void topTest(){
		card.setTop(5);
		assertEquals(5, card.getTop());
	}
	
	@Test 
	public void bottomTest(){
		card.setBottom(4);
		assertEquals(4, card.getBottom());
	}
	
	@Test 
	public void nameTest(){
		card.setName("Modified");
		assertEquals("Modified", card.getName());
	}
	
	@Test 
	public void rightTest(){
		card.setRight(7);
		assertEquals(7, card.getRight());
	}
	
	@Test 
	public void leftTest(){
		card.setLeft(1);
		assertEquals(1, card.getLeft());
	}
	
	@Test
	public void hashCodeTest(){
		assertEquals(1969969221, card.hashCode());
		card=new Card("", 1, 2, 3, 4);
		assertEquals(30595451, card.hashCode());
	}

}

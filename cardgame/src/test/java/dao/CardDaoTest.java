package dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Card;

public class CardDaoTest {
	final Gson GSON = new Gson();
	List<Card> cards = new ArrayList<Card>();
	InputStream is = CardDao.class.getResourceAsStream("/json/cards.json");
	
	CardDao daojson=new CardDao();

	@Test
	public void daoTest() {
		cards=GSON.fromJson(new InputStreamReader(is), new TypeToken<ArrayList<Card>>() {}.getType());	
		assertTrue(daojson.getCards().equals(cards));		
	}
	
	@Test
	public void getRandomCardTest(){
		Random random=new Random();
		List<Card> c=daojson.getCards();
		assertTrue(daojson.getCards().contains(c.get(random.nextInt(c.size()))));
		
		
	}

}

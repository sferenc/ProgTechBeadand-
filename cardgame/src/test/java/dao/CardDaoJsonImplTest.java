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

public class CardDaoJsonImplTest {
	final Gson GSON = new Gson();
	List<Card> cards = new ArrayList<Card>();
	InputStream is = CardDaoJsonImpl.class.getResourceAsStream("/json/cards.json");
	
	CardDaoJsonImpl daojson=new CardDaoJsonImpl();

	@Test
	public void daoTest() {
		cards=GSON.fromJson(new InputStreamReader(is), new TypeToken<ArrayList<Card>>() {}.getType());		
		if (daojson.getCards().equals(cards)) assertTrue(true);
		else assertTrue(false);
	}
	
	@Test
	public void getRandomCardTest(){//fölös
		Random random=new Random();
		List<Card> c=daojson.getCards();
		if (daojson.getCards().contains(c.get(random.nextInt(c.size())))) assertTrue(true);
		else assertTrue(false);
		
		
	}

}

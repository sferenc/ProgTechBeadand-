package dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Card;

public class CardDaoJsonImplTest {

	@Test
	public void test() {
		final Gson GSON = new Gson();
		List<Card> cards = new ArrayList<Card>();
		InputStream is = CardDaoJsonImpl.class.getResourceAsStream("/json/cards.json");
		cards=GSON.fromJson(new InputStreamReader(is), new TypeToken<ArrayList<Card>>() {}.getType());
		CardDaoJsonImpl daojson=new CardDaoJsonImpl();
		if (daojson.getCards().equals(cards)) assertTrue(true);
		else assertTrue(false);
	}

}

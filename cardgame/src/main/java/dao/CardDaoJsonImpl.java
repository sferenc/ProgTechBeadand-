package dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Card;


public class CardDaoJsonImpl implements CardDao {

	private static final Gson GSON = new Gson();
	private List<Card> cards = new ArrayList<Card>();


	private void init() {
		InputStream is = CardDaoJsonImpl.class.getResourceAsStream("/json/cards.json");
		cards=GSON.fromJson(new InputStreamReader(is), new TypeToken<ArrayList<Card>>() {}.getType());
	}

	
	public List<Card> getCards(){
		init();
		return cards;
	}

	

	@Override
	public Card getCard(String cardName) {
		for (Card card : getCards()) {
			if (card.getName().equals(cardName)) {
				return card;
			}
		}
		return null;
	}

	@Override
	public Card getRandomCard() {
		Random random = new Random();
		List<Card> c = getCards();
		return c.get(random.nextInt(c.size()));

	}

}

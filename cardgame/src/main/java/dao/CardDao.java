package dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Card;

/**
 * Ez az osztály felelős az adatbázis hozzáférésért, kiolvassa az adatbázist amellyel a program dolgozhat.
 * @author Tarján Zsolt
 *
 */
public class CardDao {

	private static final Gson GSON = new Gson();
	private List<Card> cards = new ArrayList<Card>();


	private void init() {
		InputStream is = CardDao.class.getResourceAsStream("/json/cards.json");
		cards=GSON.fromJson(new InputStreamReader(is), new TypeToken<ArrayList<Card>>() {}.getType());
	}

	/**
	 * Visszadja az összes kártyát az adatbázisból.
	 * @return Az adatbázisban lévő kártyák.
	 */
	public List<Card> getCards(){
		init();
		return cards;
	}

	
	/**
	 * Visszadja azt a kártyát amelynek a neve megegyezik a paraméterben átadott névvel.
	 * 
	 * @param cardName A keresett kártya nevével eggyező String
	 * @return Az a kártya amelyiknek a neve megegyezik a paraméterben lévővel.
	 */
	public Card getCard(String cardName) {
		for (Card card : getCards()) {
			if (card.getName().equals(cardName)) {
				return card;
			}
		}
		return null;
	}
	
	/**
	 * Az összes kártya közül vissza ad egy darabot véletlenszerűen.
	 * @return 1 db véletlenszerűen kiválasztott kártya. 
	 */
	public Card getRandomCard() {
		Random random = new Random();
		List<Card> c = getCards();
		return c.get(random.nextInt(c.size()));

	}

}

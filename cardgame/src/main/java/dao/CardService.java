package dao;

import model.Card;
/**
 * Ez az osztály továbbítja az adatbázisból kiolvasott adatokat a program számára.
 * @author Tarján Zsolt
 *
 */
public class CardService {

	private CardDao cardDao = new CardDao();
	/**
	 * Lényegében ez egy getter az adatbázis hozzáférésért felelős osztályhoz.
	 * @param cardDao Az adatbázis hozzáférésért felelős osztály.
	 */
	public CardService(CardDao cardDao) {
		this.cardDao = cardDao;
	}
	
	/**
	 * Visszadja azt a kártyát amelynek a neve megegyezik a paraméterben átadott névvel.
	 * 
	 * @param cardName A keresett kártya nevével eggyező String
	 * @return Az a kártya amelyiknek a neve megegyezik a paraméterben lévővel.
	 */
	public Card getCard(String cardName){
		return cardDao.getCard(cardName);
	}
	
	/**
	 * Az összes kártya közül vissza ad egy darabot véletlenszerűen.
	 * @return 1 db véletlenszerűen kiválasztott kártya. 
	 */
	public Card getRandomCard(){
		return cardDao.getRandomCard();
	}
}

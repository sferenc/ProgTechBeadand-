package dao;

import model.Card;

public class CardService {

	private CardDao cardDao = new CardDaoJsonImpl();
	
	public CardService(CardDao cardDao) {
		//super();
		this.cardDao = cardDao;
	}
	
	public Card getCard(String cardName){
		return cardDao.getCard(cardName);
	}
	
	public Card getRandomCard(){
		return cardDao.getRandomCard();
	}
}

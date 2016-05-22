package dao;

import java.util.List;

import model.Card;

public interface CardDao {

	public Card getCard(String cardName);
	
	public List<Card> getCards();
	
	public Card getRandomCard();
}

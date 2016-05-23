package dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardServiceTest {

	@Test
	public void daotest(){
		CardDao cardDao = new CardDao();
		CardService service=new CardService(cardDao);
		
		assertEquals("Megnézem hogy meggyezik e a 2 getcard metódus eredménye (muszály hogy megyezzen ugyanis a visszatérési értéke az egyik a másiknak konkrétan)",
				service.getCard("asd"), cardDao.getCard("asd"));
	}

}

package controller;

import dao.CardDao;
import dao.CardService;
import model.Card;
/**
 * Játékvezérlő osztály, a játékmenethez nélkülözhetetlen funkciókat tartalmazó osztály.
 * @author Tarján Zsolt
 *
 */
public class GameController {
	/**
	 * A játékvezérlő paraméterek nélküli konstruktora.
	 */
	public GameController() {	
	}		
	/**
	 * A játékvezérlő konstruktora.
	 * @param controllTops A játék tábláján szereplő kártyák tetején szereplő értékeit tartalmazza.
	 * @param controllBots A játék tábláján szereplő kártyák alján szereplő értékeit tartalmazza.
	 * @param controllNames A játék tábláján szereplő kártyák nevét tartalmazza.
	 * @param controllLefts A játék tábláján szereplő kártyák bal oldalán szereplő értékeit tartalmazza.
	 * @param controllRights A játék tábláján szereplő kártyák jobb oldalán szereplő értékeit tartalmazza.
	 */
	public GameController(int[][] controllTops, int[][] controllBots, String[][] controllNames, int[][] controllLefts,
			int[][] controllRights) {
		this.controllTops = controllTops;
		this.controllBots = controllBots;
		this.controllNames = controllNames;
		this.controllLefts = controllLefts;
		this.controllRights = controllRights;
	}

	/**
	 * A játék tábláján szereplő kártyák tetején szereplő értékeit tartalmazza.
	 */
	public int[][] controllTops=new int[5][5];
	/**
	 * A játék tábláján szereplő kártyák alján szereplő értékeit tartalmazza.
	 */
	public int[][] controllBots=new int[5][5];
	/**
	 * A játék tábláján szereplő kártyák nevét tartalmazza.
	 */
	public String[][] controllNames=new String[5][5];
	/**
	 * A játék tábláján szereplő kártyák bal oldalán szereplő értékeit tartalmazza.
	 */
	public int[][] controllLefts=new int[5][5];
	/**
	 * A játék tábláján szereplő kártyák jobb oldalán szereplő értékeit tartalmazza.
	 */
	public int[][] controllRights=new int[5][5];

	/**
	 * Az összes kártya közül vissza ad egy darabot véletlenszerűen.
	 * @return 1 db véletlenszerűen kiválasztott kártya. 
	 */
	public Card randomcard(){
		CardService service = new CardService(new CardDao());
		return service.getRandomCard();
	}
	
	/**
	 * Meghatározza hogy a tábla adott oszlopának egy adott sorára elhelyezhetünk e kártyát.
	 * @param row A tábla egy sora.
	 * @param column A tábla egy oszlopa.
	 * @return Egy logikai érték, igaz vagy hamis, azaz elhelyezhetünk vagy sem.
	 */
	public boolean isAvailableCardSlot(int row,int column){
		if (controllNames[row][column]==null){
			return true;
		}else return false;
	}

	/**
	 * Átadja a kört a másik játékos számára.
	 * @param turn Egy logikai érték amely meghatározza, hogy melyik játékos körében vagyunk.
	 * @param CardIdentifier Egy azonosító amely azt határozza meg, hogy melyik kártyát választottuk egy adott listából.
	 *  Ha az érték 0 ez azt jelenti, hogy egyik kártyát sem választottuk. 
	 * @return Egy logikai érték amely a praméterül kapott logikai értéket megfordítja, lényegében a kört fordítja meg.
	 * Példa: Ha az első játékos körében vagyunk akkor a másodikéba lépünk.
	 */
	public boolean turnChange(boolean turn,int CardIdentifier){
		if (CardIdentifier==0){
			return !turn;
		}
		else return turn;
	}
	
	/**
	 * Eltárolja a választott kártya értékeit.
	 * @param row A tábla egy sora.
	 * @param column A tábla egy oszlopa.
	 * @param card Az a kártya aminek az értékeit tároljuk el.
	 */
	public void storeData(int row,int column,Card card){
		controllTops[row][column]=card.getTop();
		controllBots[row][column]=card.getBottom();
		controllNames[row][column]=card.getName();
		controllLefts[row][column]=card.getLeft();
		controllRights[row][column]=card.getRight();
	} 
	/**
	 * Meghatározza, hogy a jobb oldalra elhelyezett kártya bal oldali értéke nagyobb e a tőle
	 * bal oldalra lévő kártya jobb oldali értékénél.
	 * @param row Azt mondja meg hogy a tábla hányadik sorába helyezzük le a kártyát.
	 * @param column Azt mondja meg hogy a tábla hányadik oszlopába helyezzük le a kártyát.
	 * @return Egy logikai érték igaz vagy hamis (azaz nagyobb vagy nem).
	 */
	public boolean leftHigher(int row,int column){
		if((column>0) && controllNames[row][column-1]!=null){
			if (controllLefts[row][column]>controllRights[row][column-1]){
				return true;
			} else return false;
		} else return false;
	}
	/**
	 * Meghatározza, hogy a bal oldalra elhelyezett kártya jobb oldali értéke nagyobb e a tőle
	 * jobb oldalra lévő kártya bal oldali értékénél.
	 * @param row Azt mondja meg hogy a tábla hányadik sorába helyezzük le a kártyát.
	 * @param column Azt mondja meg hogy a tábla hányadik oszlopába helyezzük le a kártyát.
	 * @return Egy logikai érték igaz vagy hamis (azaz nagyobb vagy nem).
	 */
	public boolean rightHigher(int row,int column){
		if((column<3) && controllNames[row][column+1]!=null){
			if (controllRights[row][column]>controllLefts[row][column+1]){
				return true;
			} else return false;
		} else return false;
	}
	/**
	 * Meghatározza, hogy egy másik kártya alá elhelyezett kártya tetején lévő érték, nagyobb e a másik kártya
	 * alján található értéknél.
	 * @param row Azt mondja meg hogy a tábla hányadik sorába helyezzük le a kártyát.
	 * @param column Azt mondja meg hogy a tábla hányadik oszlopába helyezzük le a kártyát.
	 * @return Egy logikai érték igaz vagy hamis (azaz nagyobb vagy nem).
	 */
	public boolean topHigher(int row,int column){
		if((row>0) && controllNames[row-1][column]!=null){
			if (controllTops[row][column]>controllBots[row-1][column]){
				return true;
			} else return false;
		} else return false;
	}
	/**
	 * Meghatározza, hogy egy másik kártya felé elhelyezett kártya alján lévő érték, nagyobb e a másik kártya
	 * tetején található értéknél.
	 * @param row Azt mondja meg hogy a tábla hányadik sorába helyezzük le a kártyát.
	 * @param column Azt mondja meg hogy a tábla hányadik oszlopába helyezzük le a kártyát.
	 * @return Egy logikai érték igaz vagy hamis (azaz nagyobb vagy nem).
	 */
	public boolean bottomHigher(int row,int column){
		if((row<3) && controllNames[row+1][column]!=null){
			if (controllBots[row][column]>controllTops[row+1][column]){
				return true;
			} else return false;
		} else return false;
	}
	
}

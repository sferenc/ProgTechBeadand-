package model;
/**
 * A kártyát reprezentáló osztály a kártyán 5 érték található van neve, teteje, alja, jobb oldala és bal oldala.
 * @author Tarján Zsolt
 *
 */
public class Card {
    
	private String name;
    private int top;
    private int bottom;   
    private int right;
    private int left;
	/**
	 * A kártya konstruktora.
	 * @param name A kártya neve.
	 * @param top A kártya tetején szereplő érték.
	 * @param bottom A kártya alján szereplő érték.
	 * @param right A kártya jobb oldalán szereplő érték.
	 * @param left A kártya bal oldalán szereplő érték.
	 */
    public Card(String name, int top, int bottom, int right, int left) {
		this.name = name;
		this.top = top;
		this.bottom = bottom;
		this.right = right;
		this.left = left;
	}
    /**
     * Visszadja a kártya nevét.
     * @return A kártya neve.
     */
	public String getName() {
		return name;
	}
	/**
	 * Beállítja a kártya nevét.
	 * @param name A kártya neve.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Visszaadja a kártya tetején található értéket.
	 * @return A kártya tetején található érték.
	 */
	public int getTop() {
		return top;
	}
	/**
	 * Beállítja a kártya tetején található értéket.
	 * @param top A kártya tetején található érték.
	 */
	public void setTop(int top) {
		this.top = top;
	}
	/**
	 * Visszaadja a kártya alján található értéket.
	 * @return A kártya alján található érték.
	 */
	public int getBottom() {
		return bottom;
	}
	/**
	 * Beállítja a kártya alján található értéket.
	 * @param bottom A kártya alján található érték.
	 */
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}
	/**
	 * Visszaadja a kártya jobb oldalán található értéket.
	 * @return A kártya jobb oldalán található érték.
	 */
	public int getRight() {
		return right;
	}
	/**
	 * Beállítja a kártya jobb oldalán található értéket.
	 * @param right A kártya jobb oldalán található érték.
	 */
	public void setRight(int right) {
		this.right = right;
	}
	/**
	 * Visszaadja a kártya bal oldalán található értéket.
	 * @return A kártya bal oldalán található érték.
	 */
	public int getLeft() {
		return left;
	}
	/**
	 * Beállítja a kártya bal oldalán található értéket.
	 * @param left A kártya bal oldalán található érték.
	 */
	public void setLeft(int left) {
		this.left = left;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + ", top=" + top + ", bottom=" + bottom + ", right=" + right + ", left=" + left
				+ "]";
	}
	//CHECKSTYLE:OFF
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bottom;
		result = prime * result + left;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + right;
		result = prime * result + top;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (bottom != other.bottom)
			return false;
		if (left != other.left)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (right != other.right)
			return false;
		if (top != other.top)
			return false;
		return true;
	}
    
    
    
}



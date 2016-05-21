package model;

public class Card {
    
	private String name;
    private int top;
    private int bottom;   
    private int right;
    private int left;
	
    public Card(String name, int top, int bottom, int right, int left) {
		this.name = name;
		this.top = top;
		this.bottom = bottom;
		this.right = right;
		this.left = left;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + ", top=" + top + ", bottom=" + bottom + ", right=" + right + ", left=" + left
				+ "]";
	}

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



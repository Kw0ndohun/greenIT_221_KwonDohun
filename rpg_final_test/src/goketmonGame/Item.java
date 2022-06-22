package goketmonGame;

public class Item {
	private String name;
	private int price;
	
	public Item(String n,int p) {
		this.name=n;
		this.price=p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

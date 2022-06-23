package goketmonGame;
 
public abstract class Item {
	private String name;
	private int price;
	
	
//	public Item(String n,int p) {
//		this.name=n;
//		this.price=p;
//	}

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
	
	public abstract void effect(Unit unit);
	
	public void print() {
		System.out.println(this.name+"을 사용했다!");
	}
	
}

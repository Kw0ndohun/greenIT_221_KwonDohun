package item;

import unit.Unit;

public abstract class Item {
	private String name;
	private int price;
	private String ex;
	private int target;
	
//	public Item(String n,int p) {
//		this.name=n;
//		this.price=p;
//	}
	
	public String getName() {
		return name;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
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
	public void printItem() {
		System.out.println(this.name+" "+this.ex);
	}
	
}

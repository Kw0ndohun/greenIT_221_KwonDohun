package shop;

public class Item {
	String name;
	int price;
	String category;
	
	Item(String name, int price, String category){
		this.name=name;
		this.price=price;
		this.category=category;
	}
	
	void print() {
		System.out.println("["+name+"]"+"["+price+"]"+"["+category+"]");
	}
}

package shop;

public class Item {
	String name;
	int price;
	String category;
	
	Item(String name,int pr,String cate){
		this.name=name;
		this.price=pr;
		this.category=cate;
	}
	
	void print() {
		System.out.println(category+" : "+name+" : АЁАн : "+price);
	}

}

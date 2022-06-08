package shop;

public class Cart {
	//구입한 아이템
	String userId;
	String itemName;
	int price;
	
	void print() {
		System.out.println("userId : 아이템 : "+itemName);
	}
	
	Cart(String userId,String item,int price){
		this.userId=userId;
		this.itemName=item;
		this.price=price;
	}

}

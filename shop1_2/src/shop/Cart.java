package shop;

public class Cart {
	//구입한 아이템
	String userId;
	String itemName;
	
	void print() {
		System.out.println("userId : 아이템 : "+itemName);
	}
	
	Cart(String userId,String item){
		this.userId=userId;
		this.itemName=item;
	}

}

package shop;

public class Cart {
	//������ ������
	String userId;
	String itemName;
	int price;
	
	void print() {
		System.out.println("userId : ������ : "+itemName);
	}
	
	Cart(String userId,String item,int price){
		this.userId=userId;
		this.itemName=item;
		this.price=price;
	}

}

package shop;

public class Cart {
	//������ ������
	String userId;
	String itemName;
	
	void print() {
		System.out.println("userId : ������ : "+itemName);
	}
	
	Cart(String userId,String item){
		this.userId=userId;
		this.itemName=item;
	}

}

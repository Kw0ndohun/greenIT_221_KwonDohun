package shop;

public class User {
	String id;
	int money;
	
	User(String id,int money){
		this.id=id;
		this.money=money;
	}
	
	void print() {
		System.out.println(id+" : ฑÝพื : "+money);
	}

}

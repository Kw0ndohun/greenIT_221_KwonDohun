package rpg;

public class Item {
	private String name;
	private int price;
	private int kind;
	private int power;
	
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

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	static final int WEAPON=1;
	static final int ARMOR=2;
	static final int RING=3;
	
	Item(String name,int price,int kind,int power) {
		this.name=name;
		this.price=price;
		this.kind=kind;
		this.power=power;
	}
	
	public void print() {
		System.out.print("[이름:"+name+" 가격:"+price+" 능력치: "+power+"]");
		
	}
	
}

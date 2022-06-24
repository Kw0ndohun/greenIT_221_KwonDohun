package goketmonGame;

public class Player {
	
	static Player instance=new Player();
	//인벤토리랑 내 포켓몬은 플레이어가 가지고 있다
	private MyGoketmon myGoketmonInstance=new MyGoketmon(); 
	private Inventory invenInstance=new Inventory();
	
	public MyGoketmon getMyGoketmonInstance() {
		return myGoketmonInstance;
	}


	public void setMyGoketmonInstance(MyGoketmon myGoketmonInstance) {
		this.myGoketmonInstance = myGoketmonInstance;
	}


	public Inventory getInvenInstance() {
		return invenInstance;
	}


	public void setInvenInstance(Inventory invenInstance) {
		this.invenInstance = invenInstance;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	private String name;
	private int money;
	 
	
	public Player(){
		this.name="플레이어";
		this.money=100000;
	}

}

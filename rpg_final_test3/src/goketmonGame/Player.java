package goketmonGame;

public class Player {
	
	static Player instance=new Player();
	//�κ��丮�� �� ���ϸ��� �÷��̾ ������ �ִ�
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
		this.name="�÷��̾�";
		this.money=100000;
	}

}

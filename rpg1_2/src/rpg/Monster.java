package rpg;

public class Monster {
	
	private int maxHp;
	private int hp;
	private int money;
	
	public Monster(int h,int m){
		this.maxHp=h;
		this.hp=h;
		this.money=m;
	}
	
	public int getHp() {
		return hp;
	}
	public int getMaxhp() {
		return maxHp;
	}

	public int getMoney() {
		return money;
	}

	public void setHp(int hp) {
		this.hp=hp;
	}
	public void setMoney(int money) {
		this.money=money;
	}
}

package zombi1_2;

abstract public class Unit {
	private int hp;
	private int maxHp;
	private String name;
	private int pos;
	
	
	
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public Unit(int h,String n , int p) {
		this.hp=h;
		this.maxHp=h;
		this.name=n;
		this.pos=p;
	}
	
	abstract public void attack(Unit unit);
	
}

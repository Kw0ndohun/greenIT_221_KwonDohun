package goketmonGame;

public class Unit {
	private String name;
	private int maxHp;
	private int hp;
	private int power;
	private int def;
	
	//��͵��� �־ ���ϸ��� ���� Ȯ�� ���� ����.
	// ����/��ų �żҵ� �����ؼ� ������ ���ϸ��� �����ִ� ���ݴ�� ���
	
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	
	
	public void print() {
		System.out.println(this.name+"�� hp: "+this.hp+" ���ݷ�: "+this.power+" ����: "+this.def);
	}
	

}
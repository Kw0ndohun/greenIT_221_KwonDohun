package unit;

import goketmonGame.Fn;

public abstract class Unit implements Fn{
	
	private String name;
	private int maxHp;
	private int hp;
	private int power;
	private int def;
	private boolean party=false;
	
	//��͵��� �־ ���ϸ��� ���� Ȯ�� ���� ����.
	// ����/��ų �żҵ� �����ؼ� ������ ���ϸ��� �����ִ� ���ݴ�� ���
	
	
	public int getPower() {
		return power;
	}
	public boolean isParty() {
		return party;
	}
	public void setParty(boolean party) {
		this.party = party;
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
		System.out.print(this.name+"��(��) hp: "+this.hp+" ���ݷ�: "+this.power+" ����: "+this.def + " ��Ƽ:");
		if(this.party) {
			System.out.println("O");
		}
		else {
			System.out.println("X");
		}
	}
	
//	public void attack(Unit unit) {
//		unit.setHp(unit.getHp()-this.power);
//		System.out.println(this.name+"�� "+unit.name+"���� "+this.power+"�� �������� ������!!!");
//		if(unit.getHp()<=0) {
//			unit.setHp(0);
//			System.out.println(unit.name+"�� ��������!");
//		}
//	}

	public abstract void settingUnit(int hp, int power, int def);
}

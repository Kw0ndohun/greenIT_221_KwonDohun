package goketmonGame;

public abstract class Unit {
	private String name;
	private int maxHp;
	private int hp;
	private int power;
	private int def;
	private boolean party=false;
	
	//희귀도를 넣어서 고켓몬의 등장 확률 조정 가능.
	// 어택/스킬 매소드 강제해서 각각의 고켓몬이 개성있는 공격대사 출력
	
	
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
		System.out.print(this.name+"은(는) hp: "+this.hp+" 공격력: "+this.power+" 방어력: "+this.def + " 파티:");
		if(this.party) {
			System.out.println("O");
		}
		else {
			System.out.println("X");
		}
	}
	

	public abstract void settingUnit(int hp, int power, int def);
}

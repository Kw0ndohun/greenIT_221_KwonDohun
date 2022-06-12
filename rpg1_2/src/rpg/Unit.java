package rpg;

public class Unit {
	private String name;
	private int level;
	// 4개 스텟
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	private int exp;
	// 파티가입여부
	private boolean party;
	// 아이템 장착
	private Item weapon;
	private Item armor;
	private Item ring;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public boolean isParty() {
		return party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmor() {
		return armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing() {
		return ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

	public Unit(String name, int l, int h, int a, int d, int e) {
		this.name=name;
		this.level=l;
		this.hp=h;
		this.maxHp=h;
		this.att=a;
		this.def=d;
		this.exp=e;
	}
	public Unit(String name, int l, int h, int a, int d, int e, boolean party) {
		this.name=name;
		this.level=l;
		this.hp=h;
		this.maxHp=h;
		this.att=a;
		this.def=d;
		this.exp=e;
		this.party=party;
	}
	
	public void printUnit() {
		System.out.print("[이름: "+this.name+"]");
		System.out.print("[레벨: "+this.level+"]");
		System.out.print("[경험치: "+this.exp+"]");
		System.out.print("[체력: "+this.hp);
		System.out.print(" / "+this.maxHp+"]");
		System.out.print("[공격력: "+this.att+"]");
		System.out.print("[방어력: "+this.def+"]");
		System.out.print("[파티: "+this.party+"]");
		System.out.println();
	}
	
	
	public void printEquitedItem() {
		if(weapon==null) {
			System.out.println("[무기: 없음 ]");
		}
		else {
			System.out.println("[무기: "+weapon.getName() +" ]");
		}
		if(armor==null) {
			System.out.println("[방어구: 없음 ]");
		}
		else {
			System.out.println("[방어구: "+armor.getName() +" ]");
		}
		if(ring==null) {
			System.out.println("[반지: 없음 ]");
		}
		else {
			System.out.println("[반지: "+ring.getName() +" ]");
		}
	}
	
	
}

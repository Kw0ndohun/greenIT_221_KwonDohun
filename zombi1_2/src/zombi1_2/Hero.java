package zombi1_2;

public class Hero extends Unit{
	private int power;
	private int level=1;
	private int exp=0;
	private int dmg;
	private int mp=0;
	
	public Hero(int h, String n, int p,int po) {
		super(h, n, p);
		this.power=po;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void attack(Unit unit) {
		// TODO Auto-generated method stub
		if(unit instanceof Boss) {
			Boss boss=(Boss)unit;
			if(boss.getShield()>0) {
				if(this.dmg>boss.getShield()) {
					this.dmg=this.dmg-boss.getShield();
					boss.setShield(0);
				}
				else {
					boss.setShield(boss.getShield()-this.dmg);
				}
			}
			else {
				boss.setHp(boss.getHp()-this.dmg);
			}
		}
		else {
			unit.setHp(unit.getHp()-this.dmg);
		}
		System.out.printf("%s가 %d의 공격력으로 공격.\n",this.getName(),this.dmg);
		System.out.printf("[ 영웅Hp: %d, 몬스터Hp: %d ]\n",this.getHp(),unit.getHp());
	}
	
	public int setDmg() {
		this.dmg=Game.r.nextInt(power-4)+5;
		return this.dmg;
	}
	
	public int buringCrush() {
		this.dmg=100;
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("버닝 크러쉬!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return this.dmg;
	}
	
	public int Slash() {
		this.dmg=35;
		System.out.println("슬래쉬!!!");
		return this.dmg;
	}

	public void drinkPotion() {
		System.out.println("포션을 마셔서 hp 20을 회복했다.");
		this.setHp(this.getHp()+20);
	}
	
	public void addExp(int exp) {
		
	}
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	public String data() {
		String data="";
		data+=Integer.valueOf(this.getHp())+"/";
		data+=this.getName()+"/";
		data+=Integer.valueOf(this.getPos())+"/";
		data+=Integer.valueOf(this.power)+"\n";
		return data;
	}
	
}

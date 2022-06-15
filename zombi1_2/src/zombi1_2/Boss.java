package zombi1_2;

public class Boss extends Unit{
	private int power;
	private int shield;
	
	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public Boss(int h, String n, int p,int s,int po) {
		super(h, n, p);
		this.power=po;
		this.shield=s;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void attack(Unit unit) {
		// TODO Auto-generated method stub
		int ranDmg=Game.r.nextInt(5);
		int dmg;
		if(ranDmg==0) {
			System.out.println("보스 크리티컬 데미지!!!!!");
			dmg=Game.r.nextInt(power+20)+20;
		}
		else {
			dmg=Game.r.nextInt(power)+1;
		}
		unit.setHp(unit.getHp()-dmg);
		System.out.printf("%s가 %d의 공격력으로 공격.\n",this.getName(),dmg);
		System.out.printf("[ 영웅Hp: %d, 몬스터Hp: %d ]",unit.getHp(),this.getHp());
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
		data+=Integer.valueOf(this.shield)+"/";
		data+=Integer.valueOf(this.power)+"\n";
		return data;
	}
}

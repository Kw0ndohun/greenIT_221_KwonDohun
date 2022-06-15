package zombi1_2;

public class Zombi extends Unit{
	private int power;
	private int exp;
	
	public Zombi(int h, String n, int p,int po) {
		super(h, n, p);
		this.power=po;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void attack(Unit unit) {
		// TODO Auto-generated method stub
		int dmg=Game.r.nextInt(power-3)+2;
		unit.setHp(unit.getHp()-dmg);
		System.out.printf("%s가 %d의 공격력으로 공격.\n",this.getName(),dmg);
		System.out.printf("[ 영웅Hp: %d, 몬스터Hp: %d ]\n",unit.getHp(),this.getHp());
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

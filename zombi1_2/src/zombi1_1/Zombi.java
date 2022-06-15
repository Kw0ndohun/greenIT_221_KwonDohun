package zombi1_1;

public class Zombi extends Unit{
	private int power;
	
	
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
		System.out.printf("[ 영웅Hp: %d, 몬스터Hp: %d ]",unit.getHp(),this.getHp());
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	
	
}

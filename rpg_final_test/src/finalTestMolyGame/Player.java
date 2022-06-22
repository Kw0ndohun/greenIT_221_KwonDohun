package finalTestMolyGame;

public class Player extends Unit{
	
	
	public Player(String n, int h, int p,int d){
		super.setName(n);
		super.setHp(h);
		super.setMaxHp(h);
		super.setPower(p);
		super.setDef(d);
	}

}

package goketmonGame;

public class UnitGgobugi extends Unit{
	
	
	
	public UnitGgobugi(){
		
	}
	@Override
	public void speech() {
		// TODO Auto-generated method stub
		System.out.println("꼬부기는 물대포를 사용했다");
	}
	
	@Override
	public void settingUnit(int hp, int power, int def) {
		super.setName("꼬부기");
		super.setHp(hp);
		super.setMaxHp(hp);
		super.setPower(power);
		super.setDef(def);
	}
} 

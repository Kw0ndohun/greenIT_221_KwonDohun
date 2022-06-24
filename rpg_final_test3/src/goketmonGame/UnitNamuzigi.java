package goketmonGame;

public class UnitNamuzigi extends Unit{
	
	
	
	public UnitNamuzigi(){
		
	}
	@Override
	public void speech() {
		// TODO Auto-generated method stub
		System.out.println("나무지기는 풀잎베기를 사용했다");
	}
	
	@Override
	public void settingUnit(int hp, int power, int def) {
		super.setName("나무지기");
		super.setHp(hp);
		super.setMaxHp(hp);
		super.setPower(power);
		super.setDef(def);
	}
} 

package goketmonGame;

public class UnitNamuzigi extends Unit implements Fn{
	
	
	
	public UnitNamuzigi(){
		
	}
	
	
	@Override
	public void settingUnit(int hp, int power, int def) {
		super.setName("²¿ºÎ±â");
		super.setHp(hp);
		super.setMaxHp(hp);
		super.setPower(power);
		super.setDef(def);
	}
} 

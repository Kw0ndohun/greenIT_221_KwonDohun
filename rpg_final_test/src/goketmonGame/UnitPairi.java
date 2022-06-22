package goketmonGame;

public class UnitPairi extends Unit {
	
	
	public UnitPairi(){
		
	}

	@Override
	public void settingUnit(int hp, int power, int def) {
		// TODO Auto-generated method stub
		super.setName("ÆÄÀÌ¸®");
		super.setHp(hp);
		super.setMaxHp(hp);
		super.setPower(power); 
		super.setDef(def);
	}

}

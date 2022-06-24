package goketmonGame;

public class UnitGgoret extends Unit {
	
	
	public UnitGgoret(){
		
	}
	@Override
	public void speech1() {
		// TODO Auto-generated method stub
		System.out.println("²¿·¿Àº ¸öÅë¹ÚÄ¡±â¸¦ »ç¿ëÇß´Ù");
	}
	
	@Override
	public void settingUnit(int hp, int power, int def) {
		// TODO Auto-generated method stub
		super.setName("²¿·¿");
		super.setHp(hp); 
		super.setMaxHp(hp);
		super.setPower(power);
		super.setDef(def);
	}

}

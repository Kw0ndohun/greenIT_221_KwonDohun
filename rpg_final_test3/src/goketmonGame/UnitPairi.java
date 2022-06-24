package goketmonGame;

public class UnitPairi extends Unit {
	
	
	public UnitPairi(){
		
	}
	
	@Override
	public void speech1() {
		// TODO Auto-generated method stub
		System.out.println("파이리는 화염방사를 사용했다");
	}
	
	@Override
	public void settingUnit(int hp, int power, int def) {
		// TODO Auto-generated method stub
		super.setName("파이리");
		super.setHp(hp);
		super.setMaxHp(hp);
		super.setPower(power); 
		super.setDef(def);
	}

}

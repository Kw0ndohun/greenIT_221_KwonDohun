package goketmonGame;
 
public class UnitPikachu extends Unit {
	
	
	
	public UnitPikachu(){
		
	}
	@Override
	public void speech1() {
		// TODO Auto-generated method stub
		System.out.println("피카츄는 백만볼트를 사용했다");
	}
	
	@Override
	public void settingUnit(int hp, int power, int def) {
		// TODO Auto-generated method stub
		super.setName("피카츄");
		super.setHp(hp);
		super.setMaxHp(hp);
		super.setPower(power);
		super.setDef(def);
	}

}

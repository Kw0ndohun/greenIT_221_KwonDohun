package goketmonGame;

public class UnitPairi extends Unit {
	
	
	public UnitPairi(){
		
	}
	
	@Override
	public void speech1() {
		// TODO Auto-generated method stub
		System.out.println("���̸��� ȭ����縦 ����ߴ�");
	}
	
	@Override
	public void settingUnit(int hp, int power, int def) {
		// TODO Auto-generated method stub
		super.setName("���̸�");
		super.setHp(hp);
		super.setMaxHp(hp);
		super.setPower(power); 
		super.setDef(def);
	}

}

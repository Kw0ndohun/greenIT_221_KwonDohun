package goketmonGame;
 
public class UnitPikachu extends Unit {
	
	
	
	public UnitPikachu(){
		
	}
	@Override
	public void speech1() {
		// TODO Auto-generated method stub
		System.out.println("��ī��� �鸸��Ʈ�� ����ߴ�");
	}
	
	@Override
	public void settingUnit(int hp, int power, int def) {
		// TODO Auto-generated method stub
		super.setName("��ī��");
		super.setHp(hp);
		super.setMaxHp(hp);
		super.setPower(power);
		super.setDef(def);
	}

}

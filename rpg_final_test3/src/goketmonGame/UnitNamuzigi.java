package goketmonGame;

public class UnitNamuzigi extends Unit{
	
	
	
	public UnitNamuzigi(){
		
	}
	@Override
	public void speech() {
		// TODO Auto-generated method stub
		System.out.println("��������� Ǯ�ٺ��⸦ ����ߴ�");
	}
	
	@Override
	public void settingUnit(int hp, int power, int def) {
		super.setName("��������");
		super.setHp(hp);
		super.setMaxHp(hp);
		super.setPower(power);
		super.setDef(def);
	}
} 

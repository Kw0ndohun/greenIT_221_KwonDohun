package unit;

public class UnitGgobugi extends Unit{
	
	
	
	public UnitGgobugi(){
		
	}
	@Override
	public void speech1() {
		// TODO Auto-generated method stub
		System.out.println("���α�� �������� ����ߴ�");
	}
	
	@Override
	public void settingUnit(int hp, int power, int def) {
		super.setName("���α�");
		super.setHp(hp);
		super.setMaxHp(hp);
		super.setPower(power);
		super.setDef(def);
	}
} 
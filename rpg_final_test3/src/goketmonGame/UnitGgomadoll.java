package goketmonGame;

public class UnitGgomadoll extends Unit {
	
	
	public UnitGgomadoll() {
		
	}
	@Override
	public void speech1() {
		// TODO Auto-generated method stub
		System.out.println("�������� ���̾� ��ġ�� ����ߴ�");
	}
	public void settingUnit(int h, int p, int d) {
		super.setName("������");
		super.setHp(h);
		super.setMaxHp(h);
		super.setPower(p);
		super.setDef(d);
	}

}

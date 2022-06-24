package goketmonGame;

public class UnitGgomadoll extends Unit {
	
	
	public UnitGgomadoll() {
		
	}
	@Override
	public void speech1() {
		// TODO Auto-generated method stub
		System.out.println("꼬마돌은 아이언 펀치를 사용했다");
	}
	public void settingUnit(int h, int p, int d) {
		super.setName("꼬마돌");
		super.setHp(h);
		super.setMaxHp(h);
		super.setPower(p);
		super.setDef(d);
	}

}

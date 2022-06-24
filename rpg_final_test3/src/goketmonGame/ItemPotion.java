package goketmonGame;

public class ItemPotion extends Item{

	public ItemPotion() {
		super.setName("상처약");
		super.setPrice(1000);
		super.setEx("상처를 30 회복한다.");
		super.setTarget(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Unit unit) {
		// TODO Auto-generated method stub
		int recovery=0;
		if(unit.getHp()+30<=unit.getMaxHp()) {
			recovery=unit.getHp()+30;
			unit.setHp(recovery);
		}
		else {
			recovery=unit.getMaxHp()-unit.getHp();
			unit.setHp(unit.getMaxHp());
		}
		System.out.println("체력이 "+30+" 회복됐다.");
	}

}

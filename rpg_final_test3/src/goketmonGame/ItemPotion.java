package goketmonGame;

public class ItemPotion extends Item{

	public ItemPotion() {
		super.setName("��ó��");
		super.setPrice(1000);
		super.setEx("��ó�� 30 ȸ���Ѵ�.");
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
		System.out.println("ü���� "+30+" ȸ���ƴ�.");
	}

}

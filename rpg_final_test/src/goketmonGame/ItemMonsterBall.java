package goketmonGame;

public class ItemMonsterBall extends Item{
	private UnitManager um=UnitManager.instance;
	
	public ItemMonsterBall() {
		super.setName("���ͺ�");
		super.setPrice(500);
		super.setEx("���͸� ���� �� ����Ѵ�.");
		super.setTarget(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Unit unit) {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"��(��) ����ߴ�!");
		//�ִ� ü�¿��� ����ü���� ����
		// ü���� ���� ���������� ���� catchPer(���� ȭ�֤�)�� ������ ��.
		for(int n=0; n<3; n++) {
			System.out.println("...");
			try {
				Thread.sleep(800);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		int catchPer=unit.getMaxHp()-unit.getHp();
		//ranCatchNum(��������Ȯ��)�� ������ �ִ� ü�±����� �������� ������ ����.
		int ranCatchNum=GameManager.ran.nextInt(unit.getMaxHp());
		// catchPer ������ ���ϴ� ranCatchNum�� ������ ��ȹ ����
		if(ranCatchNum<=catchPer) {
			System.out.println("�ų���!");
			System.out.println(unit.getName()+"��(��) ��Ҵ�");
			um.addMyGoketmon(unit);
			um.delMonster(unit);
			unit.setHp(unit.getMaxHp());
		}
		else {
			System.out.println("�̷�!");
			System.out.println(unit.getName()+"��(��) ������ Ƣ��Դ�");
		}
	}

}

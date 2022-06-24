package goketmonGame;

public class ItemMonsterBall extends Item{
	private UnitManager um=UnitManager.instance;
	
	public ItemMonsterBall() {
		super.setName("몬스터볼");
		super.setPrice(500);
		super.setEx("몬스터를 잡을 때 사용한다.");
		super.setTarget(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Unit unit) {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"를(을) 사용했다!");
		//최대 체력에서 현재체력을 빼서
		// 체력이 많이 빠졌을수록 높은 catchPer(잡을 화귤ㄹ)가 나오게 함.
		for(int n=0; n<3; n++) {
			System.out.println("...");
			try {
				Thread.sleep(800);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		int catchPer=unit.getMaxHp()-unit.getHp();
		//ranCatchNum(랜덤잡을확률)은 유닛의 최대 체력까지의 범위에서 임의의 숫자.
		int ranCatchNum=GameManager.ran.nextInt(unit.getMaxHp());
		// catchPer 범위에 속하는 ranCatchNum이 나오면 포획 성공
		if(ranCatchNum<=catchPer) {
			System.out.println("신난다!");
			System.out.println(unit.getName()+"을(를) 잡았다");
			um.addMyGoketmon(unit);
			um.delMonster(unit);
			unit.setHp(unit.getMaxHp());
		}
		else {
			System.out.println("이런!");
			System.out.println(unit.getName()+"은(는) 볼에서 튀어나왔다");
		}
	}

}

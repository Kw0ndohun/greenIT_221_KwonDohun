package goketmonGame;

public interface Fn {
	
	
	public default void attack(Unit target, Unit attacker) {
		speech();
		try {
			Thread.sleep(150);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("");
		target.setHp(target.getHp()-attacker.getPower());
		System.out.println(attacker.getName()+"�� "+target.getName()+"���� "+attacker.getPower()+"�� �������� ������!!!");
		if(target.getHp()<=0) {
			target.setHp(0);
			System.out.println(target.getName()+"�� ��������!");
		}
	}
	public default void speech() {
		
		
	}
}

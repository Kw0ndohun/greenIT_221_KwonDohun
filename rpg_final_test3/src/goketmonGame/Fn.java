package goketmonGame;

public interface Fn {
	
	//��ų
	public default void attack(Unit target, Unit attacker) {
		speech1();
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
	public default void attack2(Unit target, Unit attacker) {
		speech1();
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
	public default void attack3(Unit target, Unit attacker) {
		speech1();
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
	public default void attack4(Unit target, Unit attacker) {
		speech1();
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
	
	
	public default void speech1() {
		
		
	}
	public default void speech2() {
		
		
	}
	public default void speech3() {
		
		
	}
	public default void speech4() {
		
		
	}
}

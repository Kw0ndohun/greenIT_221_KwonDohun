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
		System.out.println(attacker.getName()+"가 "+target.getName()+"에게 "+attacker.getPower()+"의 데미지를 입혔다!!!");
		if(target.getHp()<=0) {
			target.setHp(0);
			System.out.println(target.getName()+"가 쓰러졌다!");
		}
	}
	public default void speech() {
		
		
	}
}

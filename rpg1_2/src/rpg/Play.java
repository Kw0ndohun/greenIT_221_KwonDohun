package rpg;

public class Play extends Thread {
	static int turn=1; 
	static int damage=Player.pl.setDamage(); 
	Monster mon=new Monster(100,10000);
	
	public void run() {
		while(true) {
			printScreen();
			setMonster();
			this.turn++;
			try {
				
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public void setMonster() {
		if(mon.getHp()==0) {
			int hp=mon.getMaxhp()+50;
			int money=mon.getMoney()+500;
			mon=new Monster(hp,money);
		}
	}
	
	public void printScreen() {
		System.out.println("[내 공격력:"+this.damage+"]");
		System.out.println("[적 체력:"+mon.getHp()+"]");
		if(turn%2!=0) {
			System.out.println("           ●○      ");
			System.out.println("_웃________◀▶_______");
		}
		else{
			int hp=mon.getHp()-this.damage;
			if(hp<0) {
				hp=0;
			}
			mon.setHp(hp);
			if(mon.getHp()==0) {
				System.out.printf("              %d!!!  \n",this.damage);
				System.out.println("               ※※ ");
				System.out.println("_>>>>>>>>웃____※※___");
				int money=Player.pl.getMoney()+mon.getMoney();
				Player.pl.setMoney(money);
			}
			else {
				System.out.printf("              %d!!!  \n",this.damage);
				System.out.println("               ●○  ");
				System.out.println("_>>>>>>>>웃____◀▶___");
			}
		}
		
	}
}

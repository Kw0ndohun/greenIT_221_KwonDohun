package zombi1_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();
	
	private ArrayList<Zombi> zomList=new ArrayList<Zombi>();
	private ArrayList<Boss> bossList=new ArrayList<Boss>();
	Hero hero = new Hero(200, "히어로", 1, 20);
	
	
	private int pos=1;
	
	public int getPos() {
		return pos;
	}
	
	public void setPos(int pos) {
		this.pos = pos;
	}
	//몬스터 생성
	public void setMonster() {
		for(int ranAddZom=r.nextInt(5)+1; ranAddZom>0; ranAddZom--) {
			int ranPos=r.nextInt(17)+2;
			Zombi zom = new Zombi(100, "좀비", ranPos, 12);
			zomList.add(zom);
		}
		Boss boss = new Boss(300, "쎈 좀비", 20, 40);
		bossList.add(boss);
	}
	
	public void checkMon(int pos) {
		for(int n=0; n<zomList.size(); n++) {
			if(zomList.get(n).getPos()==pos) {
				battle(zomList.get(n));
			}
		}
		for(int n=0; n<bossList.size(); n++) {
			if(bossList.get(n).getPos()==pos) {
				battle(bossList.get(n));
			}
		}
	}
	
	public void battle(Unit unit) {
		while(true) {
			
			System.out.println("[ 1.공격하기 2.물약먹기 ]");
			int sel=sc.nextInt();
			if(sel==1) {
				hero.attack(unit);
				unit.attack(hero);
			}
			else {
				hero.drinkPotion();
				unit.attack(hero);
			}
			
			if(hero.getHp()<=0) {
				System.out.println("히어로 사망.");
				break;
			}
			if(unit.getHp()<=0) {
				System.out.println("몬스터 사망.");
				break;
			}
		}
	}

	public void play() {
		while(true) {
			System.out.println("현재 위치:"+pos);
			
			System.out.println("[ 1.이동하기 2.물약먹기 ] \n입력:");
			int sel=sc.nextInt();
			
			if(sel==1) {
				pos++;
				hero.setPos(pos);
			}
			else {
				hero.drinkPotion();
			}
			
			
		}
	}
	
	public void run() {
		
	}
}

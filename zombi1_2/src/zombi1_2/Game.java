package zombi1_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();
	boolean run=true;
	static ArrayList<Zombi> zomList=new ArrayList<Zombi>();
	static ArrayList<Boss> bossList=new ArrayList<Boss>();
	static Hero hero = new Hero(200, "히어로", 1, 20);
	ArrayList<Unit> unitList=new ArrayList<Unit>();
	
	
//	void init() {
//		this.unitList.add(new Zombi(1,"dd",1,1));
//		this.unitList.get(0).getPos();
//	}


	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Game() {
		run();
	}
	static int pos=1;
	
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
		Boss boss = new Boss(300, "쎈 좀비", 20,100, 40);
		bossList.add(boss);
	}
	//몬스터 위치 확인
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
	//배틀
	public void battle(Unit unit) {
		System.out.println("몬스터를 만났다!!!!");
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
				run=false;
				break;
			}
			if(unit.getHp()<=0) {
				System.out.println("몬스터 사망.");
				break;
			}
		}
	}
	//플레이
	public void play() {
		while(run) {
			System.out.println("현재 위치:"+pos);
			System.out.println("[ 1.이동하기 2.물약먹기 3.세이브 4.로드 ] \n입력:");
			int sel=sc.nextInt();
			
			if(sel==1) {
				pos++;
				hero.setPos(pos);
			}
			else if(sel==2) {
				hero.drinkPotion();
			}
			else if(sel==3) {
				save();
			}
			else if(sel==4) {
				load();
			}
			else {
				System.out.println("잘못선택.");
			}
			
			cleanCorpse();
			checkMon(pos);
			
		}
		System.out.println("게임종료");
	}
	
	public String setSaveData() {
		String data="";
		data+=pos+"\n";
		data+=hero.data();
		for(int n=0; n<zomList.size(); n++) {
			data+=zomList.get(n).data();
		}
		data+="boss\n";
		for(int n=0; n<bossList.size(); n++) {
			data+=bossList.get(n).data();
		}
		return data;
	}
	
	public void cleanCorpse() {
		for(int n=0; n<zomList.size(); n++) {
			if(zomList.get(n).getHp()<=0) {
				zomList.remove(n);
			}
		}
		for(int n=0; n<bossList.size(); n++) {
			if(bossList.get(n).getHp()<=0) {
				bossList.remove(n);
			}
		}
	}
	
	public void save() {
			FileData.fd.save(setSaveData());
			System.out.println("세이브");
	}
	public void load() {
		FileData.fd.load();
	}
	
	public void run() {
		setMonster();
		play();
	}
	
	
}

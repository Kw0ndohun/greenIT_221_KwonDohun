package goketmonGame;

public class Stage {
	//랜덤세팅된 몬스터리스트를 받는 어레이 리스트 필요
	//ㅇㅇ
	static Stage instance=new Stage();
	private UnitManager um=UnitManager.instance;
	private MyGoketmon mg=MyGoketmon.instance;
	private boolean run;
	
	public Stage() {
		//몬스터 세팅
		um.setMonForStage();
		//몬스터 만났을 때 이펙트
	}
	
	public void battle() {
		this.run=true;
		meetMonEffect();
		while(this.run) {
			if(um.getMonList()==null) {
				System.out.println("승리!");
				break;
			}
			if(mg.getMyParty()==null) {
				System.out.println("패배.");
				break;
			}
			printUnit();
			playerTurn();
			monTurn();
		}
		um.getMonList().clear();
	}
	
	public void playerTurn() {
		//파티원 수만큼 턴 부여
		for(int n=0; n<mg.getMyParty().size(); n++) {
			System.out.println("=================[전투 메뉴]================");
			System.out.println("1.싸우다   2.가방 \n3.포켓몬   4.도망치다");
			
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				System.out.println("공격할 대상을 선택해주세요 : ");
				int selMon=GameManager.sc.nextInt()-1;
				if(selMon>=0&&selMon<um.getMonList().size()) {
					mg.getMyParty().get(n).attack(um.getMonList().get(selMon));
					checkDie();
				}
				else {
					System.out.println("잘못된 선택입니다.");
					n--;
					continue;
				}
			}
			else if(sel==2) {
				
			}
			else if(sel==3) {
				
			}
			else {
				int ranNum=GameManager.ran.nextInt(10)+1;
				if(ranNum>3) {
					System.out.println(mg.getMyParty().get(0).getName()+"는(은) 도망쳤다!");
					run=false;
				}
				else {
					System.out.println(mg.getMyParty().get(0).getName()+"는(은) 도망칠 수 없다!");
				}
			}
		}
	}
	
	public void monTurn() {
		for(int n=0; n<um.getMonList().size(); n++) {
			int ranIdx=GameManager.ran.nextInt(mg.getMyParty().size());
			um.getMonList().get(n).attack(mg.getMyParty().get(ranIdx));
			checkDie();
		}
	}
	
	public void printUnit() {
		System.out.println("=================[전투]================");
		System.out.println("=================[내 파티]================");
		for(int n=0; n<mg.getMyParty().size(); n++) {
			System.out.print("["+(n+1)+"]");
			mg.getMyParty().get(n).print();
		}
		System.out.println("=================[몬스터]================");
		for(int n=0; n<um.getMonList().size(); n++) {
			System.out.print("["+(n+1)+"]");
			um.getMonList().get(n).print();
		}
	}
	
	//몬스터 만났을 때 이펙트
	public void meetMonEffect() {
		for(int n=0; n<4; n++) {
			if(n%2==0) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			}
			else {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			}
			try {
				Thread.sleep(250);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("몬스터를 만났다!!!");
	}
	
	public void checkDie() {
		for(int n=0; n<um.getMonList().size(); n++) {
			if(um.getMonList().get(n).getHp()==0) {
				um.getMonList().remove(n);
				n--;
			}
		}
		for(int n=0; n<mg.getMyParty().size(); n++) {
			if(mg.getMyParty().get(n).getHp()==0) {
				mg.getMyParty().remove(n);
				n--;
			}
		}
	}
	
	
}

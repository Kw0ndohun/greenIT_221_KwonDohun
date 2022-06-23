package goketmonGame;

import java.util.ArrayList;
 
public class MyGoketmon {
	static MyGoketmon instance=new MyGoketmon();
	//내 고켓몬 리스트
	private ArrayList<Unit> goketmon=UnitManager.instance.getMyGoList();
	//내 고켓몬 관리창
	private ArrayList<Unit> myParty=new ArrayList<Unit>();
	//최대 파티원
	private final int MAXPARTY=2;
	
	public ArrayList<Unit> getGoketmon() {
		return goketmon;
	}
	public void setGoketmon(ArrayList<Unit> goketmon) {
		this.goketmon = goketmon;
	}
	public ArrayList<Unit> getMyParty() {
		return myParty;
	}
	public void setMyParty(ArrayList<Unit> myParty) {
		this.myParty = myParty;
	}
	public MyGoketmon() {
		//데리고 시작하는 두 마리 파티에 넣고 시작
		for(int n=0; n<2; n++) {
			myParty.add(goketmon.get(n));
			goketmon.get(n).setParty(true);
		}
	}
	//내 고켓몬 메뉴
	public void goketmonMenu() {
		while(true) {
			printMyGoketmonList();
			System.out.println("1.고켓몬 놓아주기 2.파티원 추가 3.파티원 제거 4.종료");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				delGoketmon();
			}
			else if(sel==2) {
				addMonForParty();
			}
			else if(sel==3) {
				delMonForParty();
			}
			else {
				break;
			}
		}
	}
	
	//고켓몬 리스트 출력
//	public void printAllGoketmon() {
//		int num=1;
//		for(Unit u:goketmon) {
//			System.out.print("["+num+"]");
//			u.print();
//			num++;
//		}
//	}
	//고켓몬 놓아주기
	public void delGoketmon() {
		System.out.println("놓아줄 고켓몬 선택:");
		int sel=GameManager.sc.nextInt()-1;
		if(sel>=0&&goketmon.size()>sel) {
			if(!goketmon.get(sel).isParty()) {
				System.out.println("놓아주기 완료.");
				goketmon.remove(sel);
			}
			else {
				System.out.println("파티를 해제해야 합니다.");
			}
		}
		else {
			System.out.println("잘못된 선택입니다.");
		}
	}
	//내 고켓몬리스트 출력
	public void printMyGoketmonList() {
		System.out.println("========내 고켓몬=========");
		for(int n=0; n<this.goketmon.size(); n++) {
			System.out.print("["+(n+1)+"]");
			this.goketmon.get(n).print();
		}
	}
	//파티리스트 출력
	public void printPartyList() {
		System.out.println("========내 파티=========");
		for(int n=0; n<this.myParty.size(); n++) {
			System.out.print("["+(n+1)+"]");
			this.myParty.get(n).print();
		}
	}
	
	//고켓몬 파티변경
//	public void changeParty() {
//		printPartyList();
//		System.out.println("변경할 고켓몬:");
//		int sel=GameManager.sc.nextInt()-1;
//		if(sel>=0&&sel<myParty.size()) {
//			myParty.remove(sel);
//			printMyGoketmonList();
//			System.out.println("추가할 고켓몬:");
//			sel=GameManager.sc.nextInt()-1;
//			
//		}
//		else {
//			System.out.println("잘못된 선택입니다.");
//		}
//	}
	//파티 고켓몬 추가
	public void addMonForParty() {
		//파티가 꽉 차지 않았을 때
		if(myParty.size()<this.MAXPARTY) {
			printMyGoketmonList();
			System.out.println("추가할 고켓몬:");
			int sel=GameManager.sc.nextInt()-1;
			if(sel>=0&&sel<this.goketmon.size()) {
				if(!goketmon.get(sel).isParty()) {
					goketmon.get(sel).setParty(true);
					this.myParty.add(this.goketmon.get(sel));
					printPartyList();
				}
				else {
					System.out.println("이미 파티중 입니다.");
				}
			}
			else {
				System.out.println("잘못된 선택입니다.");
			}
		}
		else {
			System.out.println("파티가 꽉 찼습니다.");
		}
	}
	//파티 고켓몬 제거
	public void delMonForParty() {
		printPartyList();
		System.out.println("파티에서 제거할 고켓몬:");
		int sel=GameManager.sc.nextInt()-1;
		if(sel>=0&&sel<myParty.size()) {
			myParty.get(sel).setParty(false);
			myParty.remove(sel);
			printPartyList();
		}
		else {
			System.out.println("잘못된 선택입니다.");
		}
	}
}

package goketmonGame;

import java.util.ArrayList;
 
public class MyGoketmon {
	static MyGoketmon instance=new MyGoketmon();
	//내 고켓몬 리스트
	private ArrayList<Unit> myGoketmon=UnitManager.myGoList;
	//내 고켓몬 관리창
	
	////
	
	//내 고켓몬 메뉴
	public void goketmonMenu() {
		while(true) {
			printAllGoketmon();
			System.out.println("1.고켓몬 놓아주기 2.고켓몬 파티변경");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				delGoketmon();
			}
			else if(sel==2) {
				
			}
		}
	}
	
	//고켓몬 리스트 출력
	public void printAllGoketmon() {
		int num=1;
		for(Unit u:myGoketmon) {
			System.out.print("["+num+"]");
			u.print();
			num++;
		}
	}
	//고켓몬 놓아주기
	public void delGoketmon() {
		System.out.println("놓아줄 고켓몬 선택:");
		int sel=GameManager.sc.nextInt();
		if(sel>0&&myGoketmon.size()+1>sel) {
			System.out.println("놓아주기 완료.");
			myGoketmon.remove(sel-1);
			printAllGoketmon();
		}
		else {
			System.out.println("잘못된 선택입니다.");
		}
	}
	
	//고켓몬 파티변경
}

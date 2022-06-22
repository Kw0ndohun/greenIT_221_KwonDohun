package goketmonGame;

import java.util.ArrayList;

public class MyGoketmon {
	//내 고켓몬 리스트
	ArrayList<Unit> myGoketmon=UnitManager.myList;
	//내 고켓몬 관리창
	
	
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
}

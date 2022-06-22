package goketmonGame; 

import java.util.ArrayList;

public class UnitManager{
	static UnitManager instance=new UnitManager();
	static ArrayList<Unit> monList=new ArrayList<Unit>();
	static ArrayList<Unit> myGoList=new ArrayList<Unit>();
	
	String packa="goketmonGame.";
	String[] mon= {"UnitGgobugi","UnitGgomadoll","UnitGgoret","UnitPairi","UnitPiKachu"};
	
	public UnitManager() {
		addMyGoketmon();
		addMyGoketmon();
	}
	
	//랜덤유닛생성
	public Unit ranAddUnit() {
		int num=GameManager.ran.nextInt(this.mon.length);
		try {
			Class<?> clazz=Class.forName(packa+mon[num]);
			Object ob=clazz.getDeclaredConstructor().newInstance();
			Unit temp=(Unit)ob;
			return temp;
		} catch (Exception e) {
			System.out.println("생성 실패");
			return null;
			// TODO: handle exception
		}
	}
	
	public void addMonster() {
		this.monList.add(ranAddUnit());
		System.out.println("몬 추가완료.");
	}
	public void addMyGoketmon() {
		this.myGoList.add(ranAddUnit());
		System.out.println("몬 추가완료.");
	}
	
	
}

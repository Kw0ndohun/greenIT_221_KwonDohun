package goketmonGame; 

import java.util.ArrayList;

public class UnitManager{
	static UnitManager instance=new UnitManager();
	private ArrayList<Unit> monList=new ArrayList<Unit>();
	private ArrayList<Unit> myGoList=new ArrayList<Unit>();
	
	
	
	public ArrayList<Unit> getMonList() {
		return monList;
	}

	public void setMonList(ArrayList<Unit> monList) {
		this.monList = monList;
	}

	public ArrayList<Unit> getMyGoList() {
		return myGoList;
	}

	public void setMyGoList(ArrayList<Unit> myGoList) {
		this.myGoList = myGoList;
	}
	String packa="goketmonGame.";
	String[] mon= {"UnitGgobugi","UnitGgomadoll","UnitGgoret","UnitPairi","UnitPikachu"};
	
	public UnitManager() {
		addMyGoketmon();
		addMyGoketmon();
	}
	
	//罚待蜡粗积己
	public Unit ranAddUnit() {
		int num=GameManager.ran.nextInt(this.mon.length);
		try {
			Class<?> clazz=Class.forName(packa+mon[num]);
			Object ob=clazz.getDeclaredConstructor().newInstance();
			Unit temp=(Unit)ob;
			System.out.println("积己");
			ob.
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("积己 角菩");
			return null;
			// TODO: handle exception
		}
//		Unit n=new Unit();
//		return n;
	}
	
	public void addMonster() {
		this.monList.add(ranAddUnit());
	}
	public void addMyGoketmon() {
		this.myGoList.add(ranAddUnit());
	}
	
	
}

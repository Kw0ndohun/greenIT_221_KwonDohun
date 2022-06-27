package unit; 

import java.util.ArrayList;

import goketmonGame.GameManager;

public class UnitManager{
	static UnitManager instance=new UnitManager();
	private ArrayList<Unit> monList=new ArrayList<Unit>();
	private ArrayList<Unit> myGoList=new ArrayList<Unit>();
	
	
	
	public static UnitManager getInstance() {
		return instance;
	}

	public static void setInstance(UnitManager instance) {
		UnitManager.instance = instance;
	}

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
	String packa="unit.";
	String[] mon= {"UnitGgobugi","UnitGgomadoll","UnitGgoret","UnitPairi","UnitPikachu","UnitNamuzigi"};
	
	public UnitManager() {
		
	}
	
	//ó�� ���� ������ ������ ����
	public void setUserMon() {
		for(int n=0; n<3; n++) {
			addMyGoketmon();
		}
	}
	
	public void printMonList() {
		for(int n=0; n<monList.size(); n++) {
			monList.get(n).print();
		}
	}
	
	//�������ֻ���
	public Unit ranAddUnit() {
		int num=GameManager.getRan().nextInt(this.mon.length);
		int ranHp=GameManager.getRan().nextInt(100)+100;
		int ranPower=GameManager.getRan().nextInt(30)+10;
		int ranDef=GameManager.getRan().nextInt(10)+5;
		try {
			Class<?> clazz=Class.forName(packa+mon[num]);
			Object ob=clazz.getDeclaredConstructor().newInstance();
			Unit temp=(Unit)ob;
			temp.settingUnit(ranHp,ranPower,ranDef);
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���� ����");
			return null;
			// TODO: handle exception
		}
	}
	
	//�����͸���Ʈ �߰�
	public void addMonster() {
		this.monList.add(ranAddUnit());
	}
	public void addMonster(Unit unit) {
		this.monList.add(unit);
	}
	//�� ���ϸ� �߰�
	public void addMyGoketmon() {
		this.myGoList.add(ranAddUnit());
	}
	public void addMyGoketmon(Unit unit) {
		this.myGoList.add(unit);
	}
	public void delMonster(Unit unit) {
		this.monList.remove(unit);
	}
	public void delMyGoketmon(Unit unit) {
		this.myGoList.remove(unit);
	}
	
	//�ʿ� ���� ����
	public void setMonForStage() {
		//�ִ� 2�������� �������� ����
		int num=GameManager.getRan().nextInt(2)+1;
		for(int n=0; n<num; n++) {
			addMonster();
		}
	}
	
}

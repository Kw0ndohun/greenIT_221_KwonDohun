package map;

import unit.UnitManager;

public class Map {
	//�ʿ� ���� ����
	private UnitManager um=UnitManager.getInstance();
	//�� ��ȣ/��ġ
	private int num;
	private boolean dangerMap=false;
	
	
	public boolean isDangerMap() {
		return dangerMap;
	}
	public void setDangerMap(boolean dangerMap) {
		this.dangerMap = dangerMap;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	
}

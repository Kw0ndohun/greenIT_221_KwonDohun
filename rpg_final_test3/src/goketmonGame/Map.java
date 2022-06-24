package goketmonGame;

public class Map {
	//맵에 몬스터 생성
	private UnitManager um=UnitManager.instance;
	//맵 번호/위치
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

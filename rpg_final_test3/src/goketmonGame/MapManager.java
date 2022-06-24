package goketmonGame;

import java.util.ArrayList;

public class MapManager {
	static MapManager instance=new MapManager();
	private final int MAPSIZE=10;
	private ArrayList<ArrayList<Map>> map=new ArrayList<ArrayList<Map>>();
	
	public ArrayList<ArrayList<Map>> getMap() {
		return map;
	}

	public void setMap(ArrayList<ArrayList<Map>> map) {
		this.map = map;
	}

	public MapManager(){
		setMap();
		setDangerMap();
	}
	
	// 10x10맵
	public void setMap() {
		ArrayList<Map> temp;
		for(int n=0; n<MAPSIZE; n++) {
			temp=new ArrayList<Map>();
			for(int i=0; i<MAPSIZE; i++) {
				Map m=new Map();
				m.setNum(0);
				temp.add(m);
			}
			map.add(temp);
		}
	}
	
	public void setDangerMap() {
		
		for(int n=0; n<MAPSIZE; n++) {
			for(int i=0; i<MAPSIZE; i++) {
				int ranDangerMap=GameManager.ran.nextInt(3);
				if(ranDangerMap<1) {
					map.get(n).get(i).setDangerMap(true);
				}
			}
		}
		
	}
	
	public void printMap() {
		System.out.println("==================[Map]=================");
		for(int n=0; n<map.size(); n++) {
			System.out.print("           ");
			for(int i=0; i<map.get(0).size(); i++) {
				if(map.get(n).get(i).getNum()==0) {
					if(map.get(n).get(i).isDangerMap()) {
						System.out.print("□ ");
					}
					else {
						System.out.print("■ ");
					}
				}
				else if(map.get(n).get(i).getNum()==5) {
					System.out.print("i ");
				}
			}
			System.out.println();
		}
	}
	
	
	
	
}

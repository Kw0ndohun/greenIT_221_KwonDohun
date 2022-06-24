package goketmonGame;

import java.util.ArrayList;

public class MapManager {
	static MapManager instance=new MapManager();
	private ArrayList<ArrayList<Map>> map=new ArrayList<ArrayList<Map>>();
	
	public MapManager(){
		setMap();
	}
	
	// 10x10맵
	public void setMap() {
		ArrayList<Map> temp;
		for(int n=0; n<10; n++) {
			temp=new ArrayList<Map>();
			for(int i=0; i<10; i++) {
				Map m=new Map();
				m.setNum(0);
				temp.add(m);
			}
			map.add(temp);
		}
	}
	
	public void printMap() {
		System.out.println("==================[Map]=================");
		for(int n=0; n<map.size(); n++) {
			System.out.print("           ");
			for(int i=0; i<map.get(0).size(); i++) {
				if(map.get(n).get(i).getNum()==0) {
					System.out.print("* ");
				}
				else if(map.get(n).get(i).getNum()==5) {
					System.out.print("i ");
				}
			}
			System.out.println();
		}
	}
	
	
	
	
}

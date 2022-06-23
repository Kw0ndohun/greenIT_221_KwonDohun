package goketmonGame;

import java.util.ArrayList;
 
public class ItemManager {
	static ItemManager instance=new ItemManager();
	private ArrayList<Item> itemList=new ArrayList<Item>();
	
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	
	public void addItem() {
		
	}
	public Item addMonsterBall() {
		ItemMonsterBall mon=new ItemMonsterBall();
		itemList.add(mon);
		return mon;
	}
	public Item addPotion() {
		ItemPotion po=new ItemPotion();
		itemList.add(po);
		return po;
	}
	
	
	
	//샵이랑 아이템 매니저가 이어져야함
	//몬스터볼이랑 회복약
	//클래스로 만들어서 매소드를 활용해서 효과?
	//넘버를 붙여 각 넘버 당 다른 효과가 발동되게?
	//몬스터볼이랑 회복약은 장비랑은 다르게 수량이 매우 많아지는데
	//하나하나를 객체로 생성???
	//
	// 넘버를 인식해서 효과> 아이템 종류가 적을 때만 단편적으로 가능
	// 객체를 만들어서 해야 하는데 그럼 인벤토리에서 출력할 때 애매해짐
	// 장비는 각각 출력되어야 하고 소모아이템은 겹쳐서 출력>>> 소모아이템 코드와 장비아이템 코드를 분리해서 
	// 소모아이템 코드는 총 객체 수를 카운트해서 출력하고 장비아이템은 각각이 출력되게
 }

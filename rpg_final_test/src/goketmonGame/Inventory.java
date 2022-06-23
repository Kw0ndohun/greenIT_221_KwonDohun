package goketmonGame;

import java.util.ArrayList;

public class Inventory {
	static Inventory instance=new Inventory();
	private ArrayList<Item> inven=new ArrayList<Item>();
	
	public ArrayList<Item> getInven() {
		return inven;
	}
	public void setInven(ArrayList<Item> inven) {
		this.inven = inven;
	}
	public void addItem(Item item) {
		
	}
	public void delItem() {
		
	}
	public void printItem() {
		System.out.println("=================[아이템 목록]=================");
		for(int n=0; n<this.inven.size(); n++) {
			System.out.print("["+(n+1)+"]");
			this.inven.get(n).printItem();
		}
	}
	public Item selectUseItem() {
		printItem();
		System.out.println("사용할 아이템:");
		int sel=GameManager.sc.nextInt()-1;
		return this.inven.get(sel);
	}
	
	public void invenMenu() {
		while(true) {
			printItem();
			System.out.println("1.아이템제거 2.아이템사용 3.뒤로가기");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				
			}
			else if(sel==2) {
				System.out.println("사용할 아이템:");
				int useItemIdx=GameManager.sc.nextInt()-1;
			}
			else {
				break;
			}
		}
	}
 
}

package rpg;

import java.util.ArrayList;

public class Inventory {
	static Inventory inven=new Inventory();
	ArrayList<Item> itemList=new ArrayList<Item>();
	
	public void invenMenu() {
		while(true) {
			System.out.println("1.착용 2.판매 3.뒤로가기");
			int sel=Shop.sc.nextInt();
			if(sel==1) {
				equipItem();
			}
			else if(sel==2) {
				sellItem();
			}
			else {
				break;
			}
		}
	}
	
	public void equipItem() {
		Guild.gl.printAllGuild();
		System.out.println("착용할 유닛을 선택해주세요. \n입력:");
		int selUnit=Shop.sc.nextInt()-1;
		printList();
		System.out.println("착용할 아이템을 선택해주세요. \n입력:");
		int selItem=Shop.sc.nextInt()-1;
		if(itemList.get(selItem).getKind()==Item.WEAPON) {
			if(Guild.gl.getGuildList().get(selUnit).getWeapon()!=null) {
				addItem(Guild.gl.getGuildList().get(selUnit).getWeapon());
			}
			Guild.gl.getGuildList().get(selUnit).setWeapon(itemList.get(selItem));
		}
		else if(itemList.get(selItem).getKind()==Item.ARMOR) {
			if(Guild.gl.getGuildList().get(selUnit).getArmor()!=null) {
				addItem(Guild.gl.getGuildList().get(selUnit).getArmor());
			}
			Guild.gl.getGuildList().get(selUnit).setArmor(itemList.get(selItem));
		}
		else if(itemList.get(selItem).getKind()==Item.RING) {
			if(Guild.gl.getGuildList().get(selUnit).getRing()!=null) {
				addItem(Guild.gl.getGuildList().get(selUnit).getRing());
			}
			Guild.gl.getGuildList().get(selUnit).setRing(itemList.get(selItem));
		}
		itemList.remove(selItem);
		Guild.gl.getGuildList().get(selUnit).printEquitedItem();
		printList();
	}
	
	public void sellItem() {
		printList();
		System.out.println("판매할 아이템(반값에 판매):");
		int sel=Shop.sc.nextInt()-1;
		if(sel<=0&&itemList.size()>sel) {
			int money=Player.pl.getMoney()-itemList.get(sel).getPrice()/2;
			Player.pl.setMoney(money);
			itemList.remove(sel);
			System.out.print("판매 완료. \n[현재소지금:");
			System.out.println(Player.pl.getMoney()+"]");
		}
		else {
			System.out.println("잘못된 선택입니다.");
		}
	}
	
	public void printList() {
		for(int n=0; n<itemList.size(); n++) {
			System.out.print("["+n+1+"]");
			itemList.get(n).print();
		}
	}
	
	public void addItem(Item item) {
		itemList.add(item);
	}
}

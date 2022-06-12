package rpg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Shop {
	static Shop shop=new Shop();
	ArrayList<Item> itemList=new ArrayList<Item>();
	static Random rans=new Random();
	static Scanner sc=new Scanner(System.in);
	
	public Shop() {
		setShop();
	}
	
	public void setShop() {
		String name="나무검";
		int price=1000;
		int kind=Item.WEAPON;
		int power=3;
		itemList.add(new Item(name,price,kind,power));
		name="철검";
		price=2000;
		kind=Item.WEAPON;
		power=5;
		itemList.add(new Item(name,price,kind,power));
		name="강철검";
		price=3000;
		kind=Item.WEAPON;
		power=7;
		itemList.add(new Item(name,price,kind,power));
		name="천옷";
		price=1000;
		kind=Item.ARMOR;
		power=4/2;
		itemList.add(new Item(name,price,kind,power));
		name="가죽옷";
		price=2000;
		kind=Item.ARMOR;
		power=6/2;
		itemList.add(new Item(name,price,kind,power));
		name="철갑옷";
		price=3000;
		kind=Item.ARMOR;
		power=10/2;
		itemList.add(new Item(name,price,kind,power));
		name="은반지";
		price=5000;
		kind=Item.RING;
		power=3;
		itemList.add(new Item(name,price,kind,power));
		name="금반지";
		price=10000;
		kind=Item.RING;
		power=5;
		itemList.add(new Item(name,price,kind,power));
	
	}
	
	public void shopMenu() {
		while(true) {
			System.out.println("1.무기구매 2.갑옷구매 3.반지구매 4.뒤로가기 \n입력:");
			int sel=sc.nextInt();
			if(sel==4) {
				break;
			}
			else {
				printList(sel);
				System.out.println("구매할 아이템:");
				int selIdx=sc.nextInt();
				int i=1;
				for(int n=0; n<itemList.size(); n++) {
					if(itemList.get(n).getKind()==sel) {
						if(i==selIdx) {
							String name =itemList.get(n).getName();
							int price =itemList.get(n).getPrice();
							int kind =itemList.get(n).getKind();
							int power =itemList.get(n).getPower();
							Inventory.inven.addItem(new Item(name,price,kind,power));
						}
						i++;
					}
				}
			}
		}
		
	}
	
	
	public void printList(int selKind) {
		int i=1;
		for(int n=0; n<itemList.size(); n++) {
			if(itemList.get(n).getKind()==selKind) {
				System.out.print("["+i+"]");
				itemList.get(n).print();
				i++;
			}
		}
		System.out.println();
	}
	
}

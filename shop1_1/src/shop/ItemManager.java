package shop;

import java.util.Scanner;
import java.util.Vector;

public class ItemManager {
	Scanner scan=new Scanner(System.in);
	Vector<String> category=new Vector<String>();
	Vector<Item> itemList=new Vector<Item>();
	Vector<Cart> jangList=new Vector<Cart>();
	
	ItemManager(){
		init();
	}
	
	void init() {
		category.add("과자");
		category.add("육류");
		category.add("음료수");
		category.add("술");
		Item temp=new Item("새우깡",1000,category.get(0));
		itemList.add(temp);
		temp=new Item("돼지고기",3000,category.get(1));
		itemList.add(temp);
		temp=new Item("칸쵸",1500,category.get(0));
		itemList.add(temp);
		temp=new Item("소고기",5000,category.get(1));
		itemList.add(temp);
		temp=new Item("콜라",1000,category.get(2));
		itemList.add(temp);
		temp=new Item("환타",1000,category.get(2));
		itemList.add(temp);
	}
	void printJang() {
		for(int i=0; i<jangList.size(); i++) {
			if(userList.get(userLog).id.equals(jangList.get(i).userId)) {
				jangList.get(i).print();
			}
		}
	}
}

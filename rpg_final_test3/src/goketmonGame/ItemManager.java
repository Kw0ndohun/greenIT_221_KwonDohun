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
	
	
	
	//���̶� ������ �Ŵ����� �̾�������
	//���ͺ��̶� ȸ����
	//Ŭ������ ���� �żҵ带 Ȱ���ؼ� ȿ��?
	//�ѹ��� �ٿ� �� �ѹ� �� �ٸ� ȿ���� �ߵ��ǰ�?
	//���ͺ��̶� ȸ������ ������ �ٸ��� ������ �ſ� �������µ�
	//�ϳ��ϳ��� ��ü�� ����???
	//
	// �ѹ��� �ν��ؼ� ȿ��> ������ ������ ���� ���� ���������� ����
	// ��ü�� ���� �ؾ� �ϴµ� �׷� �κ��丮���� ����� �� �ָ�����
	// ���� ���� ��µǾ�� �ϰ� �Ҹ�������� ���ļ� ���>>> �Ҹ������ �ڵ�� �������� �ڵ带 �и��ؼ� 
	// �Ҹ������ �ڵ�� �� ��ü ���� ī��Ʈ�ؼ� ����ϰ� ���������� ������ ��µǰ�
 }

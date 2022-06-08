package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
	Scanner sc=new Scanner(System.in);
	ArrayList<Item> itemList=new ArrayList<Item>();
	ArrayList<Cart> cartList=new ArrayList<Cart>();
	ArrayList<String> category=new ArrayList<String>();
	
	
	//������ �߰� ����,ī�װ� �߰� ����, ������ ����Ʈ, ī�װ� ����Ʈ
	//������ ���, ī�װ� ���
	//��ٱ���
	ItemManager(){
		init();
	}
	// �ʱ�ī�װ� ����
	void init() {
		category.add("����");
		Item temp=new Item("Ȩ����",1500,category.get(0));
		itemList.add(temp);
		category.add("�����");
		category.add("��Ȱ��ǰ");
		category.add("��");
	}
	//ī�װ� �߰�
	void addCategory() {
		System.out.println("�߰��� ī�װ�:");
		String add=sc.next();
		if(doubleCkeckCategory(add)) {
			category.add(add);
			System.out.println("�߰��Ϸ�");
		}
		else {
			System.out.println("�߰�����.");
		}
	}
	//ī�װ� ����
	void delCategory() {
		System.out.println("������ ī�װ�:");
		String del=sc.next();
		int delIdx=delCkeckCategory(del);
		if(delIdx>-1) {
			category.remove(delIdx);
			System.out.println("�����Ϸ�");
		}
		else {
			System.out.println("���� ī�װ��Դϴ�.");
		}
	}
	//ī�װ��� �ߺ�üũ
	boolean doubleCkeckCategory(String add) {
		for(int n=0; n<category.size(); n++) {
			if(category.get(n).equals(add)) {
				return false;
			}
		}
		return true;
	}
	//���� ī�װ��� �ߺ�üũ 
	int delCkeckCategory(String del) {
		for(int n=0; n<category.size(); n++) {
			if(category.get(n).equals(del)) {
				return n;
			}
		}
		return -1;
	}
	//������ �߰�
	void addItem() {
		System.out.println("�߰��� ������:");
		String add=sc.next();
		if(doubleCkeckItem(add)) {
			System.out.println("������ ī�װ� �Է�:");
			String cate=sc.next();
			if(!doubleCkeckCategory(cate)) {
				System.out.println("������ ���� �Է�:");
				int price=sc.nextInt();
				itemList.add(new Item(add,price,cate));
			}
			else {
				System.out.println("���� ī�װ��Դϴ�.");
			}
		}
		else {
			System.out.println("�ߺ��� �̸��Դϴ�.");
		}
	}
	//������ ����
	void delItem() {
		System.out.println("������ ������:");
		String del=sc.next();
		int delIdx=delCkeckItem(del);
		if(delIdx>-1) {
			itemList.remove(delIdx);
			System.out.println("�����Ϸ�");
		}
		else {
			System.out.println("���� �������Դϴ�.");
		}
	}
	//�����۸� �ߺ�üũ
	boolean doubleCkeckItem(String add) {
		for(int n=0; n<itemList.size(); n++) {
			if(itemList.get(n).name.equals(add)) {
				return false;
			}
		}
		return true;
	}
	//���� �����۸� üũ
	int delCkeckItem(String del) {
		for(int n=0; n<itemList.size(); n++) {
			if(itemList.get(n).name.equals(del)) {
				return n;
			}
		}
		return -1;
	}
	//��ü ���������
	void printItem() {
		for(int n=0; n<itemList.size(); n++) {
				System.out.print("["+n+"]");
				itemList.get(n).print();
		}
	}
	//���� ���������
	void printItem(int idx) {
		for(int n=0; n<itemList.size(); n++) {
			if(itemList.get(n).category.equals(category.get(idx))) {
				System.out.print("["+n+"]");
				itemList.get(n).print();
			}
		}
	}
	//ī�װ� ���
	void printCategory() {
		int cnt=1;
		for(String ct:category) {
			System.out.print("["+cnt+"]"+ct+" ");
			cnt++;
		}
	}
	//īƮ�� �߰��ϱ�
	void addCart(String userId,int idx) {
		cartList.add(new Cart(userId,itemList.get(idx).name,itemList.get(idx).price));
	}
	//īƮ���� �����ϱ�
	void delCart(int idx) {
		cartList.remove(idx);
	}
	//īƮ ���
	void printCart() {
		for(Cart cr:cartList) {
			cr.print();
		}
	}
	void printCart(User u) {
		for(int n=0; n<cartList.size(); n++) {
			if(cartList.get(n).userId.equals(u.id))
				cartList.get(n).print();
		}
	}
	//īƮ ����
	void buyCart(User u) {
		int sum=0;
		for(int n=0; n<cartList.size(); n++) {
			if(cartList.get(n).userId.equals(u.id)) {
				sum+=cartList.get(n).price;
			}
		}
		payment(sum,u);
	}
	//īƮ��� ����
	void payment(int sum, User u) {
		if(u.money>=sum) {
			u.money-=sum;
			clearCart(u);
			System.out.println("�����Ϸ�.");
		}
		else {
			System.out.println("�ݾ��� �����մϴ�.");
		}
	}
	//������ īƮ��� ����
	void clearCart(User u) {
		for(int n=0; n<cartList.size(); n++) {
			if(cartList.get(n).userId.equals(u.id)) {
				cartList.remove(n);
				n--;
			}
		}
	}
}

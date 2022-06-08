package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
	Scanner sc=new Scanner(System.in);
	ArrayList<Item> itemList=new ArrayList<Item>();
	ArrayList<Cart> cartList=new ArrayList<Cart>();
	ArrayList<String> category=new ArrayList<String>();
	
	
	//아이템 추가 제거,카테고리 추가 제거, 아이템 리스트, 카테고리 리스트
	//아이템 출력, 카테고리 출력
	//장바구니
	ItemManager(){
		init();
	}
	// 초기카테고리 설정
	void init() {
		category.add("과자");
		Item temp=new Item("홈런볼",1500,category.get(0));
		itemList.add(temp);
		category.add("음료수");
		category.add("생활용품");
		category.add("옷");
	}
	//카테고리 추가
	void addCategory() {
		System.out.println("추가할 카테고리:");
		String add=sc.next();
		if(doubleCkeckCategory(add)) {
			category.add(add);
			System.out.println("추가완료");
		}
		else {
			System.out.println("추가실패.");
		}
	}
	//카테고리 제거
	void delCategory() {
		System.out.println("제거할 카테고리:");
		String del=sc.next();
		int delIdx=delCkeckCategory(del);
		if(delIdx>-1) {
			category.remove(delIdx);
			System.out.println("삭제완료");
		}
		else {
			System.out.println("없는 카테고리입니다.");
		}
	}
	//카테고리명 중복체크
	boolean doubleCkeckCategory(String add) {
		for(int n=0; n<category.size(); n++) {
			if(category.get(n).equals(add)) {
				return false;
			}
		}
		return true;
	}
	//삭제 카테고리명 중복체크 
	int delCkeckCategory(String del) {
		for(int n=0; n<category.size(); n++) {
			if(category.get(n).equals(del)) {
				return n;
			}
		}
		return -1;
	}
	//아이템 추가
	void addItem() {
		System.out.println("추가할 아이템:");
		String add=sc.next();
		if(doubleCkeckItem(add)) {
			System.out.println("아이템 카테고리 입력:");
			String cate=sc.next();
			if(!doubleCkeckCategory(cate)) {
				System.out.println("아이템 가격 입력:");
				int price=sc.nextInt();
				itemList.add(new Item(add,price,cate));
			}
			else {
				System.out.println("없는 카테고리입니다.");
			}
		}
		else {
			System.out.println("중복된 이름입니다.");
		}
	}
	//아이템 제거
	void delItem() {
		System.out.println("제거할 아이템:");
		String del=sc.next();
		int delIdx=delCkeckItem(del);
		if(delIdx>-1) {
			itemList.remove(delIdx);
			System.out.println("삭제완료");
		}
		else {
			System.out.println("없는 아이템입니다.");
		}
	}
	//아이템명 중복체크
	boolean doubleCkeckItem(String add) {
		for(int n=0; n<itemList.size(); n++) {
			if(itemList.get(n).name.equals(add)) {
				return false;
			}
		}
		return true;
	}
	//삭제 아이템명 체크
	int delCkeckItem(String del) {
		for(int n=0; n<itemList.size(); n++) {
			if(itemList.get(n).name.equals(del)) {
				return n;
			}
		}
		return -1;
	}
	//전체 아이템출력
	void printItem() {
		for(int n=0; n<itemList.size(); n++) {
				System.out.print("["+n+"]");
				itemList.get(n).print();
		}
	}
	//유저 아이템출력
	void printItem(int idx) {
		for(int n=0; n<itemList.size(); n++) {
			if(itemList.get(n).category.equals(category.get(idx))) {
				System.out.print("["+n+"]");
				itemList.get(n).print();
			}
		}
	}
	//카테고리 출력
	void printCategory() {
		int cnt=1;
		for(String ct:category) {
			System.out.print("["+cnt+"]"+ct+" ");
			cnt++;
		}
	}
	//카트에 추가하기
	void addCart(String userId,int idx) {
		cartList.add(new Cart(userId,itemList.get(idx).name,itemList.get(idx).price));
	}
	//카트에서 제거하기
	void delCart(int idx) {
		cartList.remove(idx);
	}
	//카트 출력
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
	//카트 구매
	void buyCart(User u) {
		int sum=0;
		for(int n=0; n<cartList.size(); n++) {
			if(cartList.get(n).userId.equals(u.id)) {
				sum+=cartList.get(n).price;
			}
		}
		payment(sum,u);
	}
	//카트목록 결제
	void payment(int sum, User u) {
		if(u.money>=sum) {
			u.money-=sum;
			clearCart(u);
			System.out.println("결제완료.");
		}
		else {
			System.out.println("금액이 부족합니다.");
		}
	}
	//구매한 카트목록 제거
	void clearCart(User u) {
		for(int n=0; n<cartList.size(); n++) {
			if(cartList.get(n).userId.equals(u.id)) {
				cartList.remove(n);
				n--;
			}
		}
	}
}

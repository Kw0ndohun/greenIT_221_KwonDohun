package shop;

import java.util.Scanner;

public class Shop {
	ItemManager im=new ItemManager();
	UserManager um=new UserManager();
	Scanner sc=new Scanner(System.in);
	
	//메뉴들이 있는 클래스
	
	void menu() {
		while(true) {
			System.out.println("1.회원가입 2.회원탈퇴 3.로그인 4.로그아웃 \n10.관리자 0.종료");
			int sel=sc.nextInt();
			if(sel==1) {
				um.join();
			}
			else if(sel==2) {
				um.leave();
			}
			else if(sel==3) {
				if(um.login()) {
					loginMenu();
				}
			}
			else if(sel==4) {
				um.logOut();
			}
			else if(sel==10) {
				managerMenu();
			}
			else if(sel==0) {
				System.out.println("종료");
				break;
			}
		}
	}
	void loginMenu() {
		while(true) {
			System.out.println("1.쇼핑 2.장바구니 3.돌아가기");
			int sel=sc.nextInt();
			if(sel==1) {
				shopMenu();
			}
			else if(sel==2) {
				im.printCart();
			}
			else if(sel==3) {
				um.log=-1;
				break;
			}
		}
	}
	void shopMenu() {
		while(true) {
			im.printCategory();
			System.out.println("카테고리를 선택하시오(종료:-1):");
			int selCa=sc.nextInt()-1;
			if(selCa==-2) {
				break;
			}
			im.printItem(selCa);
			System.out.println("아이템을 선택하시오:");
			int selIt=sc.nextInt();
			//카트에 선택아이템 추가
			im.addCart(um.user.get(um.log).id,selIt);
		}
	}
	void managerMenu() {
		while(true) {
			System.out.println("1.아이템관리 2.카테고리관리 3.장바구니관리 4.유저관리 5.뒤로가기:");
			int sel=sc.nextInt();
			if(sel==1) {
				itemMenu();
			}
			else if(sel==2) {
				cateMenu();
			}
			else if(sel==3) {
				jangMenu();
			}
			else if(sel==4) {
				userMenu();
			}
			else if(sel==5) {
				
			}
		}
	}
	//관리자 아이템메뉴
	void itemMenu() {
		while(true) {
			System.out.println("1.전체아이템 2.아이템추가 3.아이템삭제 4.뒤로가기");
			int sel=sc.nextInt();
			if(sel==1) {
				im.printItem();
			}
			else if(sel==2) {
				im.addItem();
			}
			else if(sel==3) {
				im.delItem();
			}
			else if(sel==4) {
				break;
			}
		}
	}
	//관리자카테고리 메뉴
	void cateMenu() {
		while(true) {
			System.out.println("1.전체카테고리 2.카테고리추가 3.카테고리삭제 4.뒤로가기");
			int sel=sc.nextInt();
			if(sel==1) {
				im.printCategory();
			}
			else if(sel==2) {
				im.addCategory();
			}
			else if(sel==3) {
				im.delCategory();
			}
			else if(sel==4) {
				break;
			}
		}
	}
	//관리자카트메뉴
	void jangMenu() {
		while(true) {
			System.out.println("1.전체장바구니 2.장바구니제거 3.뒤로가기");
			int sel=sc.nextInt();
			if(sel==1) {
				im.printCart();
			}
			else if(sel==2) {
				System.out.println("제거할 장바구니:");
				int cho=sc.nextInt();
				im.delCart(cho);
			}
			else if(sel==3) {
				break;
			}
		}
	}
	//관리자 유저메뉴
	void userMenu() {
		while(true) {
			System.out.println("1.전체유저 2.유저추가 3.유저삭제 4.뒤로가기");
			int sel=sc.nextInt();
			if(sel==1) {
				um.printUser();
			}
			else if(sel==2) {
				um.addUser();
			}
			else if(sel==3) {
				um.delUser();
			}
			else if(sel==4) {
				break;
			}
		}
	}
	//구매자 카트메뉴
	void cartMenu() {
		while(true) {
			System.out.println("1.장바구니 2.삭제 3.구입 4.뒤로가기");
			int sel=sc.nextInt();
			if(sel==1) {
				im.printCart(um.user.get(um.log));
			}
			else if(sel==2) {
				System.out.println("삭제할 장바구니:");
				int delIdx=sc.nextInt();
				im.delCart(delIdx);
			}
			else if(sel==3) {
				im.buyCart(um.user.get(um.log));
			}
			else if(sel==4) {
				break;
			}
		}
	}
}

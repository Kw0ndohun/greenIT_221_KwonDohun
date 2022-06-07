package shop;

import java.util.Scanner;

public class Shop {
	Scanner scan=new Scanner(System.in);
	ItemManager im =new ItemManager();
	UserManager um=new UserManager();
	
	void mainMenu() {
		boolean run=true;
		while(run) {
			System.out.println("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃]"+"\n[100.관리자] [0.종료]");
			int sel= scan.nextInt();
			if (sel==1) {
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
			else if(sel==100) {
				managerMenu();
			}
		}
	}
	
	void cartMenu() {
		boolean run = true;
		while(run) {
			System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");
			int sel=scan.nextInt();
			if(sel==1) {
				im.pritJang(um.userList.get(um.userLog));
			}
			else if(sel==0) {
				break;
			}
		}
	}
	
	void shopMenu() {
		boolean run =true;
		while(run) {
			im.printCategory();
			System.out.println("[카테고리] 번호를 입력하세요. [종료.-1]");
			int calD=scan.nextInt();
			if(calD==-1)
				break;
			System.out.println("[아이템]번호를 입력하세요.");
			im.printItemList(calD);
			int itId=scan.nextInt();
			im.addCart(um.userList.get(um.userLog).id,calD,itID);
		}
	}
	
	void managerMenu() {
		boolean run = true;
		while(run) {
			System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기]");
			int sel=scan.nextInt();
			if(sel==1) {
				itemMenu();
			}
			else if(sel==2) {
				categoryMenu();
			}
			else if(sel==3) {
				setJang();
			}
			else if(sel==4) {
				userMenu();
			}
			else if(sel==0) {
				run=false;
			}
		}
	}
	
	void categoryMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체카테고리] [2.카테고리추가] [3.카테고리삭제] [0.뒤로가기]");
			int sel= scan.nextInt();
			if(sel==1) {
				im.printCategory();
			}
			else if(sel==2) {
				
			}
			else if(sel==3) {
				
			}
			else if(sel==0) {
				run=false;
			}
		}
	}
	
	void userMenu() {
		boolean run=true;
		while(run) {
			System.out.println("[1.전체유저] [2.유저추가] [3.유저삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			if(sel==1) {
				um.printUser();
			}
			else if (sel==2) {
				
			}
			else if (sel==3) {
				
			}
			else if (sel==0) {
				run=false;
			}
		}
	}
}

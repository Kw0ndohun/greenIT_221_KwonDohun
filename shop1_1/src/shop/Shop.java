package shop;

import java.util.Scanner;

public class Shop {
	Scanner scan=new Scanner(System.in);
	ItemManager im =new ItemManager();
	UserManager um=new UserManager();
	
	void mainMenu() {
		boolean run=true;
		while(run) {
			System.out.println("[1.����] [2.Ż��] [3.�α���] [4.�α׾ƿ�]"+"\n[100.������] [0.����]");
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
			System.out.println("[1.�� ��ٱ���] [2.����] [3.����] [0.�ڷΰ���]");
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
			System.out.println("[ī�װ�] ��ȣ�� �Է��ϼ���. [����.-1]");
			int calD=scan.nextInt();
			if(calD==-1)
				break;
			System.out.println("[������]��ȣ�� �Է��ϼ���.");
			im.printItemList(calD);
			int itId=scan.nextInt();
			im.addCart(um.userList.get(um.userLog).id,calD,itID);
		}
	}
	
	void managerMenu() {
		boolean run = true;
		while(run) {
			System.out.println("[1.�����۰���] [2.ī�װ�����] [3.��ٱ��ϰ���] [4.��������] [0.�ڷΰ���]");
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
			System.out.println("[1.��üī�װ�] [2.ī�װ��߰�] [3.ī�װ�����] [0.�ڷΰ���]");
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
			System.out.println("[1.��ü����] [2.�����߰�] [3.��������] [0.�ڷΰ���]");
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

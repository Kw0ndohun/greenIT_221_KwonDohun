package shop;

import java.util.Scanner;

public class Shop {
	ItemManager im=new ItemManager();
	UserManager um=new UserManager();
	Scanner sc=new Scanner(System.in);
	
	//�޴����� �ִ� Ŭ����
	
	void menu() {
		while(true) {
			System.out.println("1.ȸ������ 2.ȸ��Ż�� 3.�α��� 4.�α׾ƿ� \n10.������ 0.����");
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
				System.out.println("����");
				break;
			}
		}
	}
	void loginMenu() {
		while(true) {
			System.out.println("1.���� 2.��ٱ��� 3.���ư���");
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
			System.out.println("ī�װ��� �����Ͻÿ�(����:-1):");
			int selCa=sc.nextInt()-1;
			if(selCa==-2) {
				break;
			}
			im.printItem(selCa);
			System.out.println("�������� �����Ͻÿ�:");
			int selIt=sc.nextInt();
			//īƮ�� ���þ����� �߰�
			im.addCart(um.user.get(um.log).id,selIt);
		}
	}
	void managerMenu() {
		while(true) {
			System.out.println("1.�����۰��� 2.ī�װ����� 3.��ٱ��ϰ��� 4.�������� 5.�ڷΰ���:");
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
	//������ �����۸޴�
	void itemMenu() {
		while(true) {
			System.out.println("1.��ü������ 2.�������߰� 3.�����ۻ��� 4.�ڷΰ���");
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
	//������ī�װ� �޴�
	void cateMenu() {
		while(true) {
			System.out.println("1.��üī�װ� 2.ī�װ��߰� 3.ī�װ����� 4.�ڷΰ���");
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
	//������īƮ�޴�
	void jangMenu() {
		while(true) {
			System.out.println("1.��ü��ٱ��� 2.��ٱ������� 3.�ڷΰ���");
			int sel=sc.nextInt();
			if(sel==1) {
				im.printCart();
			}
			else if(sel==2) {
				System.out.println("������ ��ٱ���:");
				int cho=sc.nextInt();
				im.delCart(cho);
			}
			else if(sel==3) {
				break;
			}
		}
	}
	//������ �����޴�
	void userMenu() {
		while(true) {
			System.out.println("1.��ü���� 2.�����߰� 3.�������� 4.�ڷΰ���");
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
	//������ īƮ�޴�
	void cartMenu() {
		while(true) {
			System.out.println("1.��ٱ��� 2.���� 3.���� 4.�ڷΰ���");
			int sel=sc.nextInt();
			if(sel==1) {
				im.printCart(um.user.get(um.log));
			}
			else if(sel==2) {
				System.out.println("������ ��ٱ���:");
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

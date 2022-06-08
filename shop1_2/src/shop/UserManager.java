package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
	
	Scanner sc=new Scanner(System.in);
	static int log=-1;
	ArrayList<User> user=new ArrayList<User>();
	
	UserManager(){
		
	}
	//ȸ������
	void join() {
		System.out.println("����� ���̵� �Է��ϼ���:");
		String id=sc.next();
		if(doubleCk(id)) {
			user.add(new User(id,1000));
		}
	}
	//���̵� �ߺ��˻�
	boolean doubleCk(String id) {
		for(int n=0; n<user.size(); n++) {
			if(id.equals(user.get(n).id)) {
				return false;
			}
		}
		return true;
	}
	int loginCk(String id) {
		for(int n=0; n<user.size(); n++) {
			if(id.equals(user.get(n).id)) {
				return n;
			}
		}
		return -1;
	}
	//ȸ��Ż��
	void leave() {
		if(log!=-1) {
			user.remove(log);
			System.out.println("Ż��Ϸ�.");
			log=-1;
		}
	}
	//�α���
	boolean login() {
		if(log==-1) {
			System.out.println("���̵� �Է��Ͻÿ�:");
			String id=sc.next();
			if(loginCk(id)!=-1) {
				System.out.println("�α��� �Ϸ�!");
				log=loginCk(id);
				return true;
			}
			else {
				System.out.println("���� ���̵��Դϴ�.");
				return false;
			}
		}
		else {
			System.out.println("�α��� ���Դϴ�.");
			return false;
		}
	}
	//�α׾ƿ�
	void logOut() {
		if(log!=-1) {
			log=-1;
			System.out.println("�α׾ƿ� �Ϸ�.");
		}
	}
	
	void printUser() {
		for(User u:user) {
			u.print();
		}
	}
	void addUser() {
		System.out.println("�߰��� ���� ���̵�:");
		String id=sc.next();
		if(doubleCk(id)) {
			user.add(new User(id,1000));
			System.out.println("�߰��� �Ϸ�Ǿ����ϴ�.");
		}
		else {
			System.out.println("�ߺ��� ���̵�");
		}
	}
	void delUser() {
		System.out.println("������ ���� ��ȣ:");
		int delIdx=sc.nextInt();
		if(delIdx>-1&&delIdx<user.size()) {
			user.remove(delIdx);
		}
	}
}

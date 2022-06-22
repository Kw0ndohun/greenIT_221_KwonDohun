package finalTestMolyGame;

import java.util.ArrayList;

public class UserManager {
	//�����Ŵ��� �ν��Ͻ�
	static UserManager instance = new UserManager();
	//������ �������
	ArrayList<User> user=new ArrayList<User>();
	//�����޴� ����
	boolean run=true;
	
	//�����޴�
	public void UserMenu() {
		while(run) {
			System.out.println("1.ȸ������ 2.ȸ��Ż�� 3.���� \n�Է�:");
			selectMenu();
		}
	}
	//�����޴� ����
	public void selectMenu() {
		int sel=GameManager.sc.nextInt();
		if(sel==1) {
			addUser();
		}
		else if(sel==2) {
			delUser(GameManager.log);
		}
		else {
			run=false;
		}
	}
	
	//���� �߰�
	public void addUser() {
		System.out.println("����� ���̵�:");
		String id=GameManager.sc.next();
		if(checkId(id)) {
			System.out.println("����� ��й�ȣ:");
			String pw=GameManager.sc.next();
			int num=GameManager.ran.nextInt(8999)+1000;
			User u=new User(id,pw,num);
			user.add(u);
		}
	}
	
	//���� ����
	public void delUser(int log) {
		System.out.println("������ Ż���ϰڽ��ϱ�? \n Y/N :");
		String sel=GameManager.sc.next();
		if(sel.equals("Y")) {
			user.remove(log);
		}
		else {
			System.out.println("����Ǿ����ϴ�.");
		}
	}
	
	//���� id�ߺ�üũ
	public boolean checkId(String id) {
		for(User u:user) {
			if(u.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}
//	public void 

}

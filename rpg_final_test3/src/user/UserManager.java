package user;

import java.util.ArrayList;

import goketmonGame.GameManager;
import goketmonGame.Player;
import unit.UnitManager;

public class UserManager {
	//�����Ŵ��� �ν��Ͻ�
	static UserManager instance = new UserManager();
	//������ �������
	private ArrayList<User> user=new ArrayList<User>();
	//�����޴� ����
	boolean run=true;
	private UnitManager um=UnitManager.getInstance();
	private Player pl=Player.getInstance();
	
	
	//�����޴�
//	public void UserMenu() {
//		while(run) {
//			System.out.println("1.ȸ������ 2.ȸ��Ż�� 3.���� \n�Է�:");
//			selectMenu();
//		}
//	}
	//�����޴� ����
//	public void selectMenu() {
//		int sel=GameManager.sc.nextInt();
//		if(sel==1) { 
//			addUser();
//		}
//		else if(sel==2) {
//			delUser(GameManager.log);
//		}
//		else {
//			run=false;
//		}
//	}
	
	public static UserManager getInstance() {
		return instance;
	}

	public static void setInstance(UserManager instance) {
		UserManager.instance = instance;
	}

	public ArrayList<User> getUser() {
		return user;
	}

	public void setUser(ArrayList<User> user) {
		this.user = user;
	}

	//���� �߰�
	public void addUser() {
		System.out.println("����� ���̵�:");
		String id=GameManager.getSc().next();
		if(checkId(id)==-1) {
			System.out.println("����� ��й�ȣ:");
			String pw=GameManager.getSc().next();
			int num=GameManager.getRan().nextInt(8999)+1000;
			User u=new User(id,pw,num);
			user.add(u);
			um.setUserMon();
			pl.getMyGoketmonInstance().setMyParty();
		}
	}
	
	//���� ����
	public void delUser(int log) {
		System.out.println("������ Ż���ϰڽ��ϱ�? \n Y/N :");
		String sel=GameManager.getSc().next();
		if(sel.equals("Y")) {
			user.remove(log);
			GameManager.setLog(-1);
		}
		else {
			System.out.println("����Ǿ����ϴ�.");
		}
	}
	
	//���� id�ߺ�üũ
	public int checkId(String id) {
		for(int n=0; n<user.size(); n++) {
			if(user.get(n).getId().equals(id)) {
				return n;
			}
		}
		return -1;
	}

}

package stage;

import goketmonGame.GameManager;
import goketmonGame.Player;
import unit.UnitManager;
import user.UserManager;

public class StageMain {
	private UserManager um=UserManager.getInstance();
	static StageMain instance=new StageMain();
	private StageLobby sl=StageLobby.instance;
	private Player pl=Player.getInstance();
	private UnitManager unitM=UnitManager.getInstance();
	private boolean run=true;
	public void MainMenu() {
		run=true;
		while(run) {
			if(GameManager.getLog()!=-1) {
				 this.sl.lobbyMenu();
			 }
			System.out.println("1.ȸ������ 2.ȸ��Ż�� 3.�α��� 4.�α׾ƿ� 5.���� \n�Է�:");
			int sel=GameManager.getSc().nextInt();
			if(sel==1) {
				um.addUser();
			}
			else if(sel==2) {
				um.delUser(GameManager.getLog());
			}
			else if(sel==3) {
				login();
				
			}
			else if(sel==4) {
				logOut();
			}
			else {
				System.out.println("����");
				break;
			}
		}
	}
	// 
	public void login() {
		System.out.println("���̵�:");
		String id=GameManager.getSc().next();
		
		if(um.checkId(id)!=-1) {
			System.out.println("��й�ȣ:");
			String pw=GameManager.getSc().next();
			if(um.getUser().get(um.checkId(id)).getPw().equals(pw)) {
				System.out.println("�α��� �Ϸ�.");
				GameManager.setLog(um.checkId(id));
			}
			else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		}
		else {
			System.out.println("���� ���̵��Դϴ�.");
		}
	}
	
	public void logOut() {
		if(GameManager.getLog()!=-1) {
			System.out.println("�α׾ƿ�.");
			GameManager.setLog(-1);
			pl.getMyGoketmonInstance().getGoketmon().clear();
			pl.getMyGoketmonInstance().getMyParty().clear();
		}
		else {
			System.out.println("�α��� ������ �ʽ��ϴ�.");
		}
	}
	public static StageMain getInstance() {
		return instance;
	}
	public static void setInstance(StageMain instance) {
		StageMain.instance = instance;
	}
	
	
	//ȸ������
	//�α���
	//���� ����
}

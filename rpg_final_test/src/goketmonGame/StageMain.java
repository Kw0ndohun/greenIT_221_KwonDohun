package goketmonGame;

public class StageMain {
	private UserManager um=UserManager.instance;
	static StageMain instance=new StageMain();
	private boolean run=true;
	public void MainMenu() {
		run=true;
		while(run) {
			
			System.out.println("1.ȸ������ 2.ȸ��Ż�� 3.�α��� 4.�α׾ƿ� 5.���� \n�Է�:");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				um.addUser();
			}
			else if(sel==2) {
				um.delUser(GameManager.log);
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
		String id=GameManager.sc.next();
		
		if(um.checkId(id)!=-1) {
			System.out.println("��й�ȣ:");
			String pw=GameManager.sc.next();
			if(um.getUser().get(um.checkId(id)).getPw().equals(pw)) {
				System.out.println("�α��� �Ϸ�.");
				GameManager.log=um.checkId(id);
				run=false;
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
		if(GameManager.log!=-1) {
			System.out.println("�α׾ƿ�.");
			GameManager.log=-1;
		}
		else {
			System.out.println("�α��� ������ �ʽ��ϴ�.");
		}
	}
	
	
	//ȸ������
	//�α���
	//���� ����
}

package goketmonGame;

public class StageMain {
	private UserManager um=UserManager.instance;
	
	public void MainMenu() {
		while(true) {
			
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
				if(GameManager.log!=-1) {
					GameManager.log=-1;
				}
			}
			else {
				break;
			}
		}
	}
	//
	public void login() {
		System.out.println("���̵�:");
		String id=GameManager.sc.next();
	}
	
	
	//ȸ������
	//�α���
	//���� ����
}

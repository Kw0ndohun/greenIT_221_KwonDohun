package goketmonGame;

public class StageMain {
	private UserManager um=UserManager.instance;
	
	public void MainMenu() {
		while(true) {
			
			System.out.println("1.회원가입 2.회원탈퇴 3.로그인 4.로그아웃 5.종료 \n입력:");
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
		System.out.println("아이디:");
		String id=GameManager.sc.next();
	}
	
	
	//회원가입
	//로그인
	//게임 시작
}

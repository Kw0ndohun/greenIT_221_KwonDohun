package goketmonGame;

public class StageMain {
	private UserManager um=UserManager.instance;
	static StageMain instance=new StageMain();
	private boolean run=true;
	public void MainMenu() {
		run=true;
		while(run) {
			
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
				logOut();
			}
			else {
				System.out.println("종료");
				break;
			}
		}
	}
	// 
	public void login() {
		System.out.println("아이디:");
		String id=GameManager.sc.next();
		
		if(um.checkId(id)!=-1) {
			System.out.println("비밀번호:");
			String pw=GameManager.sc.next();
			if(um.getUser().get(um.checkId(id)).getPw().equals(pw)) {
				System.out.println("로그인 완료.");
				GameManager.log=um.checkId(id);
				run=false;
			}
			else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
		else {
			System.out.println("없는 아이디입니다.");
		}
	}
	
	public void logOut() {
		if(GameManager.log!=-1) {
			System.out.println("로그아웃.");
			GameManager.log=-1;
		}
		else {
			System.out.println("로그인 중이지 않습니다.");
		}
	}
	
	
	//회원가입
	//로그인
	//게임 시작
}

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
			System.out.println("1.회원가입 2.회원탈퇴 3.로그인 4.로그아웃 5.종료 \n입력:");
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
				System.out.println("종료");
				break;
			}
		}
	}
	// 
	public void login() {
		System.out.println("아이디:");
		String id=GameManager.getSc().next();
		
		if(um.checkId(id)!=-1) {
			System.out.println("비밀번호:");
			String pw=GameManager.getSc().next();
			if(um.getUser().get(um.checkId(id)).getPw().equals(pw)) {
				System.out.println("로그인 완료.");
				GameManager.setLog(um.checkId(id));
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
		if(GameManager.getLog()!=-1) {
			System.out.println("로그아웃.");
			GameManager.setLog(-1);
			pl.getMyGoketmonInstance().getGoketmon().clear();
			pl.getMyGoketmonInstance().getMyParty().clear();
		}
		else {
			System.out.println("로그인 중이지 않습니다.");
		}
	}
	public static StageMain getInstance() {
		return instance;
	}
	public static void setInstance(StageMain instance) {
		StageMain.instance = instance;
	}
	
	
	//회원가입
	//로그인
	//게임 시작
}

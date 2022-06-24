package goketmonGame;

import java.util.ArrayList;

public class UserManager {
	//유저매니저 인스턴스
	static UserManager instance = new UserManager();
	//생성된 유저목록
	private ArrayList<User> user=new ArrayList<User>();
	//유저메뉴 실행
	boolean run=true;
	
	
	
	
	//유저메뉴
//	public void UserMenu() {
//		while(run) {
//			System.out.println("1.회원가입 2.회원탈퇴 3.종료 \n입력:");
//			selectMenu();
//		}
//	}
	//유저메뉴 선택
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
	
	public ArrayList<User> getUser() {
		return user;
	}

	public void setUser(ArrayList<User> user) {
		this.user = user;
	}

	//유저 추가
	public void addUser() {
		System.out.println("사용할 아이디:");
		String id=GameManager.sc.next();
		if(checkId(id)==-1) {
			System.out.println("사용할 비밀번호:");
			String pw=GameManager.sc.next();
			int num=GameManager.ran.nextInt(8999)+1000;
			User u=new User(id,pw,num);
			user.add(u);
		}
	}
	
	//유저 삭제
	public void delUser(int log) {
		System.out.println("정말로 탈퇴하겠습니까? \n Y/N :");
		String sel=GameManager.sc.next();
		if(sel.equals("Y")) {
			user.remove(log);
			GameManager.log=-1;
		}
		else {
			System.out.println("종료되었습니다.");
		}
	}
	
	//유저 id중복체크
	public int checkId(String id) {
		for(int n=0; n<user.size(); n++) {
			if(user.get(n).getId().equals(id)) {
				return n;
			}
		}
		return -1;
	}

}

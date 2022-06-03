package atm;

import java.util.ArrayList;

public class UserManager {
	private int code=1000;
	public static UserManager instance = new UserManager();
	
	private UserManager() {
	}
	
	private static ArrayList<User> users = new ArrayList<User>();
	//회원가입
	public void joinId() {
		System.out.println("사용할 id:");
		String id=Bank.scan.next();
		System.out.println("사용할 pw:");
		String pw=Bank.scan.next();
		System.out.println("이름:");
		String name=Bank.scan.next();
		User user=new User(id,pw);
		
		if(doubleCheck(user)) {
			user=new User(id,pw,name,addCode());
			users.add(user);
			System.out.println("회원가입 완료.");
		}
		else {
			System.out.println("회원가입 실패.");
		}
		
	}
	//회원탈퇴
	public void delId() {
		System.out.println("제거할 id:");
		String id=Bank.scan.next();
		System.out.println("제거할 pw:");
		String pw=Bank.scan.next();
		User user=new User(id,pw);
		
		if(doubleCheck(user)) {
			if(userIdxCheck(user)>=0) {
				users.remove(userIdxCheck(user));
			}
		}
		else {
			System.out.println("없는 아이디입니다.");
		}
	}
	
	//중복검사
	public boolean doubleCheck(User user) {
		for(User u:users) {
			if(u.getId().equals(user.getId())) {
				return false;
			}
		}
		return true;
	}
	//log 검사
		public int userIdxCheck(User user) {
			int log=0;
			for(User u:users) {
				if(u.getId().equals(user.getId())) {
					return log;
				}
				log++;
			}
			return -1;
		}
	//유저코드 생성
	public int addCode() {
		code++;
		return code;
	}
	
	
}

package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
	
	Scanner sc=new Scanner(System.in);
	static int log=-1;
	ArrayList<User> user=new ArrayList<User>();
	
	UserManager(){
		
	}
	//회원가입
	void join() {
		System.out.println("사용할 아이디를 입력하세요:");
		String id=sc.next();
		if(doubleCk(id)) {
			user.add(new User(id,1000));
		}
	}
	//아이디 중복검사
	boolean doubleCk(String id) {
		for(int n=0; n<user.size(); n++) {
			if(id.equals(user.get(n).id)) {
				return false;
			}
		}
		return true;
	}
	int loginCk(String id) {
		for(int n=0; n<user.size(); n++) {
			if(id.equals(user.get(n).id)) {
				return n;
			}
		}
		return -1;
	}
	//회원탈퇴
	void leave() {
		if(log!=-1) {
			user.remove(log);
			System.out.println("탈퇴완료.");
			log=-1;
		}
	}
	//로그인
	boolean login() {
		if(log==-1) {
			System.out.println("아이디를 입력하시오:");
			String id=sc.next();
			if(loginCk(id)!=-1) {
				System.out.println("로그인 완료!");
				log=loginCk(id);
				return true;
			}
			else {
				System.out.println("없는 아이디입니다.");
				return false;
			}
		}
		else {
			System.out.println("로그인 중입니다.");
			return false;
		}
	}
	//로그아웃
	void logOut() {
		if(log!=-1) {
			log=-1;
			System.out.println("로그아웃 완료.");
		}
	}
	
	void printUser() {
		for(User u:user) {
			u.print();
		}
	}
	void addUser() {
		System.out.println("추가할 유저 아이디:");
		String id=sc.next();
		if(doubleCk(id)) {
			user.add(new User(id,1000));
			System.out.println("추가가 완료되었습니다.");
		}
		else {
			System.out.println("중복된 아이디");
		}
	}
	void delUser() {
		System.out.println("제거할 유저 번호:");
		int delIdx=sc.nextInt();
		if(delIdx>-1&&delIdx<user.size()) {
			user.remove(delIdx);
		}
	}
}

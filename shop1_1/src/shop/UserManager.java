package shop;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class UserManager {
	Random ran=new Random();
	Scanner scan =new Scanner(System.in);
	Vector<User> userList =new Vector<User>();
	int userLog=-1;
	
	UserManager(){
		
	}
	
	void join() {
		System.out.println("[가입] id를 입력하시오:");
		String id=scan.next();
		User temp=new User(id,0);
		userList.add(temp);
		System.out.println("[메세지]" + temp.id + "님 가입을 축하드립니다.");
	}
	
	boolean login() {
		userLog=-1;
		System.out.println("[로그인] id를 입력하시오:");
		String id= scan.next();
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				userLog=i;
				break;
			}
		}
		if(userLog==-1) {
			System.out.println("[메세지] 없는 아이디입니다.");
		}
		else {
			System.out.println("[메세지]"+ userList.get(userLog).id+"님 로그인");
			return true;
		}
		return false;
	}
	
	void logOut() {
		if(userLog !=-1) {
			System.out.println("[메세지]"+ userList.get(userLog).id+ "님 로그아웃.");
		}
		userLog=-1;
	}
	
	void printUser() {
		for(int i=0; i<userList.size(); i++) {
			System.out.print("["+i+"]");
			userList.get(i).print();
		}
	}
}

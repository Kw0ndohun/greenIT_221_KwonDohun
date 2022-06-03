package atm;

import java.util.Scanner;

public class Bank {
	public static Scanner scan = new Scanner(System.in);
	
	//뱅크 이름
	private static String name;
	//뱅크에서 로그인을 하기 때문에 로그가 뱅크에 있다
	public static int log = -1;
	//뱅크 객체 생성
	public static Bank instance = new Bank();
	//뱅크 기본 생성자를 프라이빗으로 해서 아무데서나 생성하지 못하게 함. 뱅크 객체 생성x 
	private Bank() {
		
	}
	//메뉴출력
	public void printMenu() {
		System.out.println("##그린뱅크##");
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.계좌개설");
		System.out.println("6.계좌제거");
		System.out.println("7.계좌조회");
		System.out.println("");
	}
	//메뉴선택
	public void selectMenu() {
		int sel=scan.nextInt();
		if(sel==1) UserManager.instance.joinId();
		else if(sel==2) UserManager.instance.delId();
		else if(sel==3) login();
		else if(sel==4) logout(this.log);
		else if(sel==5&&this.log>-1) AccountManager.instance.addAcc();
		else if(sel==6&&this.log>-1) AccountManager.instance.delAcc();
		else if(sel==7&&this.log>-1) AccountManager.instance.printAcc();
	}
	
	//로그인
	public int login() {
		System.out.println("아이디:");
		String id=scan.next();
		System.out.println("비번:");
		String pw=scan.next();
		boolean loginCk = UserManager.instance.loginCheck(id,pw);
		if(loginCk) {
			System.out.println("로그인 완료");
			return log;
		}
		System.out.println("로그인 실패");
		return -1;
	}
	//로그아웃
	public void logout(int log) {
		if(log>=0) {
			log=-1;
			System.out.println("로그아웃 완료.");
		}
		else {
			System.out.println("로그인 되어 있지 않습니다.");
		}
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void run() {
		// 실행 로직 
		while(true) {
			printMenu();
			selectMenu();
		}
		
	}
	
}

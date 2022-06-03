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
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void run() {
		// 실행 로직 
		while(true) {
		}
		
	}
	
}

package atm;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//회원 한 명당, 계좌 최대 3개
		// 1.회원가입/탈퇴
		//ㄴUser
		//UserManager (static)
		//2.계좌개설/해지
		//ㄴAccount
		//ㄴAccountManager (static)
		
		//3.atm 운영
		//ㄴ Bank (static)
		
		Bank.setName("Green");
		Bank.instance.run();
	}
}

package atm;

public class Main {
	public static void main(String[] args) {
		// 인코딩 설정 : UTF-8 !!!
		// atm 
		// ㄴ 회원 한 명 당, 계좌를 최대 3개까지 개설이 가능함 
		
		// 1. 회원가입/탈퇴
		// ㄴ User 
		// ㄴ UserManager (static)
		// 2. 계좌개설/해지 
		// ㄴ Account 
		// ㄴ AccountManager (static)
		
		// 3. atm운영
		// ㄴ Bank (.run()) (static)
		
		Bank.instance.setName("Green");
		Bank.instance.run();
		
		// atm1 	: 첫번째 프로젝트명 
		// atm1_2	: 두번째 프로젝트명 
		
	}

}

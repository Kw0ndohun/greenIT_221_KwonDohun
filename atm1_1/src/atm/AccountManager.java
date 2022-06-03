package atm;

import java.util.ArrayList;

public class AccountManager {
	int code=1000000;
	public static AccountManager instance = new AccountManager();
	private AccountManager() {}
	
	private ArrayList<Account> accs = new ArrayList<Account>();
	
	public void addAcc() {
		//한 명당 3개의 계좌 보유가능. 보유 계좌 체크
		if(UserManager.instance.getUserAccCnt()<3) {
			Account acc=new Account(UserManager.instance.getUserCode(),addAccCode());
			accs.add(acc);
			UserManager.instance.getUsers().get(Bank.log).getAccs().add(acc);
			System.out.println("계좌 개설 완료");
		}
		else {
			System.out.println("보유 가능한 계좌 수를 초과했습니다.");
		}
	}
	public int addAccCode() {
		code++;
		return code;
	}
	public void delAcc() {
		System.out.println("제거할 계좌의 인덱스를 입력하시오:");
		int idx=Bank.scan.nextInt();
		
		ArrayList<Account> list= UserManager.instance.getUsers().get(Bank.log).getAccs();
		Account delAcc=list.get(idx);
		
		try {
			accs.remove(delAcc);
			list.remove(delAcc);
			System.out.println("제거 완료");
		} catch (Exception e) {
			System.out.println("제거 실패");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public void printAcc() {
		for(int n=0; n<UserManager.instance.getUsers().get(Bank.log).getAccs().size(); n++) {
			System.out.println(UserManager.instance.getUsers().get(Bank.log).getAccs().get(n));
		}
	}
	
	
}

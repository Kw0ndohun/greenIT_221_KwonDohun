package atm;

import java.util.ArrayList;

public class AccountManager {
	int code=1000000;
	public static AccountManager instance = new AccountManager();
	private AccountManager() {}
	 UserManager um= UserManager.instance;
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
	//입금
	public void deposit() {
		System.out.println("입금할 계좌번호:");
		int accNum=Bank.scan.nextInt();
		
		if(findAccNum(accNum)>=0) {
			System.out.println("입금할 금액:");
			int inMoney=Bank.scan.nextInt();
			
		}
		
	}
	//출금
	public void withdraw() {
		System.out.println("출금할 계좌번호:");
		int accNum=Bank.scan.nextInt();
		if(findAccNum(accNum)>=0) {
			System.out.println("출금할 금액:");
			int outMoney=Bank.scan.nextInt();
			
		}
	}
	//이체
	public void transfer() {
		System.out.println("이체할 계좌번호:");
		int accNum=Bank.scan.nextInt();
		if(findAccNum(accNum)>=0) {
			System.out.println("이체할 금액:");
			int sendMoney=Bank.scan.nextInt();
			
		}
	}
	//get AccNum
	public int findAccNum(int accNum) {
		if(um.getAccCode(accNum)>=0) return um.getAccCode(accNum);
		else return -1;
	}
	
}

package atm;

public class Account {
	private int userCode;
	private int accNum;
	private int money;
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public Account(int userCode, int accNum) {
		this.userCode=userCode;
		this.accNum=accNum;
	}
	
	@Override
	public String toString() {
		return String.format("%d | 계좌번호: %d | %d원",this.userCode,this.accNum,this.money) ;
	}

}

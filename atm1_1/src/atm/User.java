package atm;

import java.util.ArrayList;

public class User {
	private int code, accCnt;
	private String id, pw;
	private String name;
	
	private ArrayList<Account> accs;
	
	
	public User(String id,String pw){
		this.id=id;
		this.pw=pw;
	}
	public User(String id,String pw,String name){
		this.id=id;
		this.pw=pw;
		this.name=name;
	}
	public User(String id,String pw,String name, int code){
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.code=code;
		accs=new ArrayList();
	}
	
	// getter & setter 
	public int getCode() {
		return code;
	}
	
	public int getAccCnt() {
		return accCnt;
	}

	public void setAccCnt(int accCnt) {
		this.accCnt = accCnt;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Account> getAccs(){
		return this.accs;
	}
	

}

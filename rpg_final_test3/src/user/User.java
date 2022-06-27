package user;

public class User {
	
	
	
	private String id;
	private String pw;
	private int num;
	
	
	public User(String id, String pw, int num) {
		this.id=id;
		this.pw=pw;
		this.num=num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public int getNum() {
		return num; 
	}


	public void setNum(int num) {
		this.num = num;
	}
	
	
	public void print() {
		System.out.println("["+this.num+"] "+this.id);
		
	}
	
}

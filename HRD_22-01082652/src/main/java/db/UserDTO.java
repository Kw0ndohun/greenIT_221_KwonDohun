package db;

import java.util.Date;


public class UserDTO {
	int custno;
	String custname;
	String phone;
	String address;
	long joindate;
	String  grade;
	String city;
	
	public UserDTO(int custno, String custname, String phone, String address,long joindate,String grade, String city){
		this.custno=custno;
		this.custname=custname;
		this.phone=phone;
		this.address=address;
		this.joindate=joindate;
		this.grade=grade;
		this.city=city;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getJoindate() {
		return joindate;
	}

	public void setJoindate(long joindate) {
		this.joindate = joindate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
//	UserDTO(String custname,){
//		
//	}
	
	
	
	
	
}

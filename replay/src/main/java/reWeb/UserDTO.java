package reWeb;

public class UserDTO {
	private String id, password, name;
	private int year, month, day;
	private String gender, email, coun, mobile;
	
	public UserDTO(String id, String password, String name, int year, int month,int day, String gender, String email,
			String coun, String mobile){
		this.id=id;
		this.password=password;
		this.name=name;
		this.year=year;
		this.month=month;
		this.day=day;
		this.gender=gender;
		this.email=email;
		this.coun=coun;
		this.mobile=mobile;
	}
	public UserDTO(String id, String password){
		this.id=id;
		this.password=password;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCoun() {
		return coun;
	}
	public void setCoun(String coun) {
		this.coun = coun;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}

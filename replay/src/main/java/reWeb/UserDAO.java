package reWeb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;


public class UserDAO {
	
	
	private static UserDAO instance=new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	private UserDAO() {
	}
	
	private Connection conn=null;
	private ResultSet rs=null;
	private PreparedStatement pstmt=null;
	
	private String url="jdbc:mysql://localhost:3306/usersDb";
	private String user="root";
	private String password="12341";
	
	private String sql="insert into users values(?,?,?,?,?,?,?,?)";
	private String sqlSeach="select * from users where id=? AND password=?";
	private String sqldelUser="delete * from users where id=?";
	
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection(url, user, password);
			
			return conn;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	// 유저 추가
	public boolean addUser(UserDTO userDto) {
		conn=getConnection();
		Date date=new Date(userDto.getYear()-1900,userDto.getMonth(),userDto.getDay());
		Timestamp birth=new Timestamp(date.getTime());
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			pstmt.setString(3, userDto.getName());
			pstmt.setTimestamp(4, birth);
			pstmt.setString(5, userDto.getGender());
			pstmt.setString(6, userDto.getEmail());
			pstmt.setString(7, userDto.getCoun());
			pstmt.setString(8, userDto.getMobile());
			pstmt.executeUpdate();
			conn=null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		return true;
	}
	//로그인 체크
	public boolean loginUser(UserDTO userDto) {
		conn= getConnection();
		try {
			pstmt=conn.prepareStatement(sqlSeach);
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				conn=null;
				return true;
			}
			else {
				conn=null;
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//회원 탈퇴
	public boolean delUser(String id) {
		conn= getConnection();
		try {
			pstmt=conn.prepareStatement(sqldelUser);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				conn=null;
				return true;
			}
			else {
				conn=null;
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}

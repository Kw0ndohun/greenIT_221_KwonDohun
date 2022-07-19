package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
	
	private static UserDAO instance=new UserDAO();
	public static UserDAO getDAO() {
		return instance;
	}
	private UserDAO() {
		
	}
	
	DBManager dbm=DBManager.getDBM();
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	
	//유저 생성
	public boolean addUser(UserDTO user) {
		Connection conn= dbm.getConnection();
		String sql=String.format("insert into users values('%d','%s','%s','%s','%s','%s','%s')",user.getCustno(),user.getCustname(),user.getPhone(),user.getAddress(),user.getJoindate(),user.getGrade(),user.getCity());
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	
	
	//유저제거
	public boolean delUser(int no) {
		Connection conn= dbm.getConnection();
		String sql=String.format("delete from users where custno='%d'",no);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	
	//유저 수정
	public boolean updateUser(UserDTO user) {
		Connection conn= dbm.getConnection();
		System.out.println(user.getCity());
		String sql=String.format("Update users set custname='%s',phone='%s',address='%s',grade='%s',city='%s' where custno='%d'",user.getCustname(),user.getPhone(),user.getAddress(),user.getGrade(),user.getCity(),user.getCustno());
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("성공");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("실패");
		return false;
	}
	//유저 카운트
	public int countUser() {
		Connection conn= dbm.getConnection();
		String sql=String.format("select * from users");
		int n=100000;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				n=rs.getInt("custno");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return n;
	}
	
	//유저 가져오기
		public ArrayList<UserDTO> getUserList() {
			Connection conn= dbm.getConnection();
			ArrayList<UserDTO> userlist=new ArrayList<UserDTO>();
			String sql=String.format("select * from users");
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					UserDTO user=new UserDTO(rs.getInt("custno"),rs.getString("custname"),rs.getString("phone"),rs.getString("address"),rs.getDate("joindate"), rs.getString("grade"),rs.getString("city"));
					userlist.add(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return userlist;
		}
		
		//유저 하나 가져오기
		public UserDTO getUser(int no) {
			Connection conn= dbm.getConnection();
			String sql=String.format("select * from users where custno='%d'",no);
			UserDTO user=null;
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					user=new UserDTO(rs.getInt("custno"),rs.getString("custname"),rs.getString("phone"),rs.getString("address"),rs.getDate("joindate"), rs.getString("grade"),rs.getString("city"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return user;
		}
	
}

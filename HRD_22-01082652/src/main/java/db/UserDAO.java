package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
	DBManager dbm=DBManager.getDbm();
	PreparedStatement pstmt;
	ResultSet rs;
	private static UserDAO instance=new UserDAO();
	public static UserDAO getUserDAO() {
		return instance;
	}
	private UserDAO() {
		
	}
	
	//우저추가
	public boolean addUser(UserDTO user) {
		Connection conn=dbm.getConnection();
		String sql=String.format("insert into users values('%d','%s','%s','%s','%s','%s','%s')", user.getCustno(),user.getCustname(),user.getPhone(),user.getAddress(),user.getJoindate(),user.getGrade(),user.getCity());
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("회원등록");
			return true;
		} catch (Exception e) {
			System.out.println("회원등록실패");
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			conn=null;
		}
		return false;
	}
	//유저삭제
	public boolean delUser(int custno) {
		Connection conn=dbm.getConnection();
		String sql=String.format("delete from users where custno='%d'",custno);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("회원제거");
			return true;
		} catch (Exception e) {
			System.out.println("회원제거실패");
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			conn=null;
		}
		return false;
	}
	//유저수정
	public boolean UpdateUser(UserDTO user) {
		Connection conn=dbm.getConnection();
		String sql=String.format("Update users set custname='%s',phone='%s',address='%s',grade='%s',city='%s' where custno='%d'",user.getCustname(),user.getPhone(),user.getAddress(),user.getGrade(),user.getCity(),user.getCustno());
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("회원제거");
			return true;
		} catch (Exception e) {
			System.out.println("회원제거실패");
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			conn=null;
		}
		return false;
	}
	
	//유저카운트
	public int countUser() {
		Connection conn=dbm.getConnection();
		String sql=String.format("select * from users");
		int no=100000;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				no++;
			}
			return no;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			conn=null;
		}
		return no;
	}
	//유저조회
	public ArrayList<UserDTO> viewUser() {
		Connection conn=dbm.getConnection();
		String sql=String.format("select * from users");
		ArrayList<UserDTO> userlist=new ArrayList<UserDTO>();
		UserDTO user;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				user=new UserDTO(rs.getInt("contno"),rs.getString("contname"),rs.getString("phone"),rs.getString("address"),rs.getLong("joindate"),rs.getString("grade"),rs.getString("city"));
				userlist.add(user);
			}
			return userlist;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			conn=null;
		}
		return null;
	}
	
}

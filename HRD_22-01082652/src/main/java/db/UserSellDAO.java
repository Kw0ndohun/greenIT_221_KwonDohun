package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserSellDAO {
	DBManager dbm=DBManager.getDbm();
	PreparedStatement pstmt;
	ResultSet rs;
	private static UserSellDAO instance=new UserSellDAO();
	public static UserSellDAO getUserSellDAO() {
		return instance;
	}
	private UserSellDAO() {
		
	}
	//판매정보추가
	public boolean addUserSell(UserSellDTO userSell) {
		Connection conn=dbm.getConnection();
		String sql=String.format("insert into userSell values('%d','%d','%d','%d','%d','%s','%s')", userSell.getCustno(),userSell.getSalenol(),userSell.getPcost(),userSell.getAmount(),userSell.getPrice(),userSell.getPcode(),userSell.getSdate());
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("회원판매등록");
			return true;
		} catch (Exception e) {
			System.out.println("회원판매등록실패");
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			conn=null;
		}
		return false;
	}
	
	
	//판매정보삭제
		public boolean delUserSell(int salenol) {
			Connection conn=dbm.getConnection();
			String sql=String.format("delete from userSell where salenol='%d'",salenol);
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.execute();
				System.out.println("판매정보제거");
				return true;
			} catch (Exception e) {
				System.out.println("판매정보제거실패");
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				conn=null;
			}
			return false;
		}
		
		//판매정보카운트
		public int countUserSell() {
			Connection conn=dbm.getConnection();
			String sql=String.format("select * from userSell");
			int no=20160000;
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
		//판매정보조회
		public ArrayList<UserSellDTO> viewUserSell() {
			Connection conn=dbm.getConnection();
			String sql=String.format("select * from userSell");
			ArrayList<UserSellDTO> userSellList=new ArrayList<UserSellDTO>();
			UserSellDTO userSell;
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					userSell=new UserSellDTO(rs.getInt("contno"),rs.getInt("salenol"),rs.getInt("pcost"),rs.getInt("amount"),rs.getInt("price"),rs.getString("pcode"),rs.getLong("sdate"));
					userSellList.add(userSell);
				}
				return userSellList;
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				conn=null;
			}
			return null;
		}
}

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
	//�Ǹ������߰�
	public boolean addUserSell(UserSellDTO userSell) {
		Connection conn=dbm.getConnection();
		String sql=String.format("insert into userSell values('%d','%d','%d','%d','%d','%s','%s')", userSell.getCustno(),userSell.getSalenol(),userSell.getPcost(),userSell.getAmount(),userSell.getPrice(),userSell.getPcode(),userSell.getSdate());
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("ȸ���Ǹŵ��");
			return true;
		} catch (Exception e) {
			System.out.println("ȸ���Ǹŵ�Ͻ���");
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			conn=null;
		}
		return false;
	}
	
	
	//�Ǹ���������
		public boolean delUserSell(int salenol) {
			Connection conn=dbm.getConnection();
			String sql=String.format("delete from userSell where salenol='%d'",salenol);
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.execute();
				System.out.println("�Ǹ���������");
				return true;
			} catch (Exception e) {
				System.out.println("�Ǹ��������Ž���");
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				conn=null;
			}
			return false;
		}
		
		//�Ǹ�����ī��Ʈ
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
		//�Ǹ�������ȸ
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

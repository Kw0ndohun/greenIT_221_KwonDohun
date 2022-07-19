package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SellInfoDAO {
	
	private static SellInfoDAO instance=new SellInfoDAO();
	public static SellInfoDAO getDAO() {
		return instance;
	}
	private SellInfoDAO() {
		
	}
	
	
	
	DBManager dbm=DBManager.getDBM();
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	
	//판매정보 생성
	public boolean addSellInfo(SellInfoDTO sellInfo) {
		Connection conn= dbm.getConnection();
		String sql=String.format("insert into sellInfo values('%d','%d','%d','%d','%d','%s','%s')", countInfo(),sellInfo.getSalenol(),sellInfo.getPcost(),sellInfo.getAmount(),sellInfo.getPrice(),sellInfo.getPcode(),sellInfo.getSdate());
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
	
	//판매정보 카운트
		public int countInfo() {
			Connection conn= dbm.getConnection();
			String sql=String.format("select * from sellInfo");
			int n=0;
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					n=rs.getInt("salenol");
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return n+1;
		}
		
		//판매정보 가져오기
		
		public ArrayList<SellInfoDTO> getInfoList() {
			Connection conn= dbm.getConnection();
			ArrayList<SellInfoDTO> infolist=new ArrayList<SellInfoDTO>();
			String sql=String.format("select * from sellInfo");
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					SellInfoDTO info=new SellInfoDTO(rs.getInt("custno"),rs.getInt("salenol"),rs.getInt("pcost"),rs.getInt("amount"),rs.getInt("price"),rs.getString("pcode"),rs.getDate("sdate")); 
					infolist.add(info);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return infolist;
		}
}

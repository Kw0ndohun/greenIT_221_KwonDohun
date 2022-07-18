package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
	
	private static DBManager instance=new DBManager();
	public static DBManager getDbm() {
		return instance;
	}
	private DBManager() {
		
	}
	
	
	public Connection getConnection() {
		String url="jdbc:oracle:thin:@localhost:1521";
		String id="system";
		String pw="1234";
		Connection conn;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection(url,id,pw);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}

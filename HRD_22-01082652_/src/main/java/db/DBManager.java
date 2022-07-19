package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	
	private static DBManager instance = new DBManager(); 
	public static DBManager getDBM() {
		return instance;
	}
	private DBManager() {
		
	}
	public static Connection getConnection(){
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@//localhost:1521/xe","c##system","1234");
			return conn;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	

}

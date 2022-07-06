package reWeb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class BoardDAO {
	
	
	private static BoardDAO instance=new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	private BoardDAO() {
		
	}
	
	
	private Connection conn=null;
	private ResultSet rs=null;
	private PreparedStatement pstmt=null;
	
	private String url="jdbc:mysql://localhost:3306/firstWeb";
	private String user="root";
	private String password="root";
	
	private String sqlBoardCnt="select count(*) from board";
	private String sqlBoard="select * from board";
	private String sqlBoardDel="delete from board where code=?";
	private String sqlBoardNo="select * from board where no=?";
	//private String sql="insert into board values(?,?,?,?,?,?,?,?)";
	private String sql="insert into board(title,contents,createdAt) values(?,?,?)";
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
	
	// 보드 추가
		public boolean addBoard(BoardDTO boardDto) {
			conn=getConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, boardDto.getTitle());
				pstmt.setString(2, boardDto.getContents());
				pstmt.setString(3, boardDto.getCreatedAt());
				pstmt.executeUpdate();
				conn=null;
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
				// TODO: handle exception
			}
		}
	
	//게시글 카운트
		public int boardCnt() {
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoardCnt);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
				else {
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		//게시글 가져오기
		public ResultSet board() {
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoard);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					return rs;
				}
				else {
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		//게시글 한개 가져오기
		public ResultSet boardNo(String no) {
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoardNo);
				pstmt.setString(1,no);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					return rs;
				}
				else {
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		//게시글 수정하기
		public ResultSet updateBoard() {
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoard);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					return rs;
				}
				else {
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		//게시글 삭제하기
		public void delBoard(int code) {
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoardDel);
				pstmt.setInt(1, code);
				rs=pstmt.executeQuery();
				if(rs.next()) {
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}

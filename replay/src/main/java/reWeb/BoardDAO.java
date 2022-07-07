package reWeb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

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
	private String sqlBoardDel="delete from board where no=?";
	private String sqlBoardNo="select * from board where no=?";
	private String sqlBoardUpdateTitle="update board set title=? where no=?";
	private String sqlBoardUpdateContents="update board set contents=? where no=?";
	private String sqlBoardUpdateView="update board set viewCnt=? where no=?";
	private String sqlBoardUpdateLike="update board set likeCnt=? where no=?";
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
		
		//보드 게시글 리스트 가져오기
		public ArrayList<BoardDTO> boardList() {
			ArrayList<BoardDTO> boardList=new ArrayList<BoardDTO>();
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoard);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					int getNo=rs.getInt("no");
					String title=rs.getString("title");
					String contents=rs.getString("contents");
					int viewCnt=rs.getInt("viewCnt");
					int likeCnt=rs.getInt("likeCnt");
					String createdAt=rs.getString("createdAt");
					String modifiedAt=rs.getString("modifiedAt");
					
					BoardDTO boardDto=new BoardDTO(getNo,title,contents,viewCnt,likeCnt,createdAt,modifiedAt);
					boardList.add(boardDto);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return boardList;
		}
		
//		//게시글 가져오기
//		public ArrayList<ResultSet> board() {
//			conn= getConnection();
//			ArrayList<ResultSet> rsSet=new ArrayList<ResultSet>();
//			try {
//				pstmt=conn.prepareStatement(sqlBoard);
//				rs=pstmt.executeQuery();
//				while(rs.next()) {
//					rsSet.add(rs);
//					System.out.println("?!"); 
//				}
//				conn=null;
//				rs=null;
//				return rsSet;
//			} catch (Exception e) {
//				e.printStackTrace();
//				return null;
//			}
//		}
		/*public ArrayList<ResultSet> board() {
			conn= getConnection();
			ArrayList<ResultSet> rsSet=new ArrayList<ResultSet>();
			try {
				pstmt=conn.prepareStatement(sqlBoard);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					rsSet.add(rs);
					System.out.println("?!");
				}
				conn=null;
				rs=null;
				return rsSet;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}*/
		//다음 게시글 가져오기
		/*public ResultSet boardMore() {
			try {
				if(rs.next()) {
					return rs;
				}
				else {
					return rs;
				}
			} catch (Exception e) {
				return null;
				// TODO: handle exception
			}
		}*/
		//게시글 내용 한개 가져오기
		public BoardDTO boardNo(String no) {
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoardNo);
				pstmt.setString(1,no);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					int getNo=rs.getInt("no");
					String title=rs.getString("title");
					String contents=rs.getString("contents");
					int viewCnt=rs.getInt("viewCnt");
					int likeCnt=rs.getInt("likeCnt");
					String createdAt=rs.getString("createdAt");
					String modifiedAt=rs.getString("modifiedAt");
					
					BoardDTO boardDto=new BoardDTO(getNo,title,contents,viewCnt,likeCnt,createdAt,modifiedAt);
					return boardDto;
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
		public boolean updateBoard(String no,String title, String con) {
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoardUpdateTitle);
				pstmt.setString(1, title);
				pstmt.setString(2, no);
				pstmt.executeUpdate();
				pstmt=conn.prepareStatement(sqlBoardUpdateContents);
				pstmt.setString(1, con);
				pstmt.setString(2, no);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		//게시글 삭제하기
		public boolean delBoard(String no) {
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoardDel);
				pstmt.setString(1, no);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		//게시글 조회수 ++
		public boolean BoardView(String no,int viewCnt) {
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoardUpdateView);
				pstmt.setInt(1, viewCnt+1);
				pstmt.setString(2, no);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		//게시글 좋아요 클릭
		public boolean BoardLike(String no,int likeCnt) {
			conn= getConnection();
			try {
				pstmt=conn.prepareStatement(sqlBoardUpdateLike);
				pstmt.setInt(1, likeCnt+1);
				pstmt.setString(2, no);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
}

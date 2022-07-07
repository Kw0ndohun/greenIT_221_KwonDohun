<%@page import="reWeb.BoardDTO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="reWeb.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="reWeb.UserDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
 <link rel="stylesheet" href="css/board.css">
</head>
<body>
<%
	BoardDAO dao=BoardDAO.getInstance();
	
	//sql
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	
	String sqlBoard="select * from board";
	
	ArrayList<BoardDTO> boardList=dao.boardList();
	//sql에서 가져온 데이터들을 1~끝까지 읽어 여기 형식에 넣어서 
	//테이블 바디에 추가해줘야함
	// 테이블 바디에 추가>?
	// sql에서 테이터를 가져와서 위의 변수들에 초기화해주고
	// 테이블바디를 늘려주면서 변수들을 넣어줘야함.
	// t바디 부분에서 반복문을 돌려서 td부분을 생성해주면 됨.
	
			
%>
    <h1>DOOOO BOARD</h1>
    <div class="boardListContainer">
        <table border="1">
            <thead>
             <tr>
                <th>no</th>
                <th>title</th>
                <th>view</th>
                <th>like</th>
                <th>(작성일)</th>
                <th>(수정일)</th>
           	</tr>
            </thead>
            <tbody>
				<%
            	//int boardCnt=dao.boardCnt();
            	int pages=1;
            	int boardCnt;
            	if(dao.boardCnt()<=pages*10){
            		boardCnt=dao.boardCnt();
            	}
            	else{
            		boardCnt=pages*10;
            	}
            	
            	//for(int n=pages-1; n<boardCnt; n++){
            		
            String url="boardView.jsp";
			/*try {
        	conn= dao.getConnection();
				pstmt=conn.prepareStatement(sqlBoard);
				rs=pstmt.executeQuery();
				while(rs.next()) {
				}
					conn=null;
					rs=null;
				} catch (Exception e) {
					e.printStackTrace();
				}
				*/
				for(int n=0; n<boardList.size(); n++){
					
				
            	%>
                <tr>
                    <td><%=boardList.get(n).getNo()%></td>
                    <td><a href="<%=url+"?no="+boardList.get(n).getNo()%>"><%=boardList.get(n).getTitle()%></a></td>
                    <td><%=boardList.get(n).getViewCnt()%></td>
                    <td><%=boardList.get(n).getLikeCnt()%></td>
                    <td><%=boardList.get(n).getCreatedAt()%></td>
                    <td><%=boardList.get(n).getModifiedAt()%></td>
                </tr>
                <% 
                
				}
            	//}
                %>
            </tbody>
        </table>

		<input type="button" value="뒤로가기" onclick="location.href='main.jsp'">
		<input type="hidden" id="log" name="log" value="<%=(String)session.getAttribute("log")%>">
        <input type="button" value="글쓰기" onclick="loginLogCk()">
    </div>
    <script src="script/board_validation.js"></script>
</body>
</html>
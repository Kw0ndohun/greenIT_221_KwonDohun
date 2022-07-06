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
	int no=1;
	int code=1001;
	String title="";
	int viewCnt=0;
	int likeCnt=0;
	String createdAt="";
	String modifiedAt="";
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
            	ResultSet rs=dao.board();
            	//int boardCnt=dao.boardCnt();
            	int pages=1;
            	int boardCnt;
            	if(dao.boardCnt()<=pages*10){
            		boardCnt=dao.boardCnt();
            	}
            	else{
            		boardCnt=pages*10;
            	}
            	
            	for(int n=pages-1; n<boardCnt; n++){
            		String url="boardView.jsp";
            	%>
                <tr>
                    <td><%=rs.getInt("no")%></td>
                    <td><a href="<%=url+"?no="+rs.getInt("no")%>"><%=rs.getString("title")%></a></td>
                    <td><%=rs.getInt("viewCnt")%></td>
                    <td><%=rs.getInt("likeCnt")%></td>
                    <td><%=rs.getString("createdAt")%></td>
                    <td><%=rs.getString("modifiedAt")%></td>
                </tr>
                <% 
            	}
                %>
            </tbody>
        </table>

		<input type="button" value="뒤로가기" onclick="main.jsp">
        <input type="button" value="글쓰기" onclick="loginLogCk(<%=session.getAttribute("log")%>)">
    </div>
    <script src="script/board_validation.js"></script>
</body>
</html>
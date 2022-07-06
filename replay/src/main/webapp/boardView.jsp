<%@page import="java.sql.ResultSet"%>
<%@page import="reWeb.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/board.css">
    <title>BOARD VIEW</title>
</head>
<body>
<%	
	BoardDAO dao=BoardDAO.getInstance();
	String no=request.getParameter("no");
	ResultSet rs=dao.boardNo(no);
%>
    <h1>DOOOO VIEW</h1>
    <div class="formContainer">
        <form method="post" action="">
            <input type="text" name="title" id="title" required placeholder="title" readonly value="<%=rs.getString("title")%>"><br>
            <textarea name="contents" placeholder="contents text" required readonly>
            <%=rs.getString("contents")%>
            
            </textarea><br>
            <input type="button" value="뒤로가기" onclick="board.jsp">
            <input type="button" value="글쓰기" onclick="boardWriteForm.jsp">
        </form>

    </div> 
</body>
</html>
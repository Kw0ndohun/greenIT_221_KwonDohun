<%@page import="java.sql.ResultSet"%>
<%@page import="reWeb.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/board.css">
    <title>BOARD UPDATE</title>
</head>
<body>
<%	
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
	BoardDAO dao=BoardDAO.getInstance();
	String no=request.getParameter("no");
	ResultSet rs=dao.boardNo(no);
%>
    <h1>DOOOO UPDATE</h1>
    <div class="formContainer">
        <form method="post" action="boardUpdateFormPro.jsp?no=<%=no%>">
            <input type="text" name="title" id="title" required placeholder="title" value="<%=rs.getString("title")%>"><br>
            <textarea name="contents" placeholder="contents text" required>
            <%=rs.getString("contents")%>
            </textarea><br>
            <input type="button" value="뒤로가기" onclick="location.href='board.jsp'">
            <input type="button" value="수정완료" onclick="boardContentsCheck(form)">
        </form>

    </div> 
    <script src="script/board_validation.js"></script>
</body>
</html>
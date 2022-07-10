<%@page import="reWeb.BoardDTO"%>
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

//
	BoardDAO dao=BoardDAO.getInstance();
	String no=request.getParameter("no");
	BoardDTO dto=dao.boardNo(no);
	dao.BoardView(no, dto.getViewCnt());
%>
    <h1>DOOOO VIEW</h1>
    <div class="formContainer">
        <form method="post" action="board.jsp">
            <input type="text" name="title" id="title" required placeholder="title" readonly value="<%=dto.getTitle()%>">
            <br>
            <textarea name="contents" placeholder="contents text" required readonly><%=dto.getContents()%>
            </textarea><br>
            <h4>조회수:<%=dto.getViewCnt()%></h4>
            <h4>좋아요:<%=dto.getLikeCnt()%></h4><br>
            <input type="button" value="뒤로가기" onclick="location.href='board.jsp'">
            <input type="button" value="좋아요!" onclick="<%=dao.BoardLike(no,dto.getLikeCnt())%>">
            <input type="button" value="삭제하기" onclick="location.href='./boardDelete?no=<%=no%>'">
            <input type="button" value="수정하기" onclick="location.href='./boardUpdateForm?no=<%=no%>'">
            <input type="button" value="글쓰기" onclick="location.href='./boardWriteForm'">
        </form>

    </div> 
</body>
</html>
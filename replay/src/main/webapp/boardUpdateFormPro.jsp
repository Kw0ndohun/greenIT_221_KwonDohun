<%@page import="reWeb.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<body>
	
	<%
	
	request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
	
		BoardDAO dao=BoardDAO.getInstance();
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		String no=request.getParameter("no");
		
		
		String url="";
		if(dao.updateBoard(no,title, contents)){
			url="board.jsp";
		}
		else{
			url="boardWriteForm.jsp";
		}
		response.sendRedirect(url);
	%>
</body>
</body>
</html>
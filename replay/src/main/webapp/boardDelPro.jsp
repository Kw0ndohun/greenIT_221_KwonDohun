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
	<%
	
	request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
	
		BoardDAO dao=BoardDAO.getInstance();
		String no=request.getParameter("no");
		
		
		String url="";
		if(dao.delBoard(no)){
			url="board.jsp";
		}
		else{
			url="boardView.jsp?no="+no;
		}
		response.sendRedirect(url);
	%>
</body>
</html>
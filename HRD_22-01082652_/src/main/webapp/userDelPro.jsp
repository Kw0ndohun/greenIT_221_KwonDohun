<%@page import="db.UserDAO"%>
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
	
	UserDAO dao=UserDAO.getDAO();
	
	int no=Integer.parseInt(request.getParameter("no"));	
	
	
	
	String url="";
	if(dao.delUser(no)){
		url="userInfo.jsp";
	}
	else{
		url="userInfo.jsp";
	}
	
	response.sendRedirect(url);
	%>
</body>
</html>
<%@page import="db.UserDAO"%>
<%@page import="java.util.Date"%>
<%@page import="db.UserDTO"%>
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
		
		UserDAO dao=UserDAO.getUserDAO();
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		Date date=new Date();
		long dd=System.currentTimeMillis();
		UserDTO user;
		user=new UserDTO(dao.countUser()+1,name,phone,address,dd,"A",city);
		String url="";
		
		if(dao.addUser(user)){
			url="index.jsp";
		}
		else{
			url="join.jsp";
		}
		
		response.sendRedirect(url);
	%>
</body>
</html>
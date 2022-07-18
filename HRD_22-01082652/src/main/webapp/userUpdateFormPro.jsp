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
		
		int no=Integer.parseInt(request.getParameter("custno"));
		String name=request.getParameter("custname");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		long date=Long.parseLong(request.getParameter("joindate"));
		String grade=request.getParameter("grade");
		
		
		long dd=System.currentTimeMillis();
		UserDTO user;
		user=new UserDTO(no,name,phone,address,date,grade,city);
		String url="";
		
		if(dao.UpdateUser(user)){
			url="userView.jsp";
		}
		else{
			url="index.jsp";
		}
		
		response.sendRedirect(url);
	%>
</body>
</html>
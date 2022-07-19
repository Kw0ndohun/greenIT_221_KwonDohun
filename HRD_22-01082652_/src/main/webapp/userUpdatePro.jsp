<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="db.UserDTO"%>
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
		
		UserDTO user;
		int no=Integer.parseInt(request.getParameter("no"));		
		System.out.println("no:"+no);
		String name=request.getParameter("name");		
		String phone=request.getParameter("phone");		
		String add1=request.getParameter("add1");		
		String add2=request.getParameter("add2");		
		String add3=request.getParameter("add3");
		String grade=request.getParameter("grade");
		String city=request.getParameter("city");
		String address;
		if(add1!=null){
			address=add1;
		}
		else if(add2!=null){
			address=add2;
		}
		else {
			address=add3;
		}
		user=new UserDTO(no,name,phone,address,grade,city);
		
		String url="";
		if(dao.updateUser(user)){
			url="index.jsp";
		}
		else{
			url="join.jsp";
		}
		
		response.sendRedirect(url);
	%>
</body>
</html>
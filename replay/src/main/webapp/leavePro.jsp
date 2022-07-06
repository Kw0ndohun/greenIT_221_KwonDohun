<%@page import="reWeb.UserDAO"%>
<%@page import="reWeb.UserDTO"%>
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
	UserDTO user=null;
	UserDAO dao=UserDAO.getInstance();
	
	//리퀘스트 리스폰스 인코딩을 지정
	request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    
    
    String id=String.valueOf(session.getAttribute("log"));
    String url="";
    if(dao.delUser(id)){
    	session.setAttribute("log",user.getId());
    	url="main.jsp";
    }
    else{
    	url="index.jsp";
    }
    response.sendRedirect(url);
    
    
    %>
</body>
</html>
<%@page import="java.util.ArrayList"%>
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
	<h1>유저조회</h1>
	<h3>회원번호/이름/전화/통신사/가입일자/등급/거주지</h3>
	<%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		UserDAO dao=UserDAO.getUserDAO();
		ArrayList<UserDTO> userlist=dao.viewUser();
		for(int n=0; n<userlist.size(); n++){
			
	%>
		
		<div><a href="userUpdateForm.jsp?no=<%=n%>"><%=userlist.get(n).getCustno()+"/"+userlist.get(n).getCustname()+"/"+userlist.get(n).getPhone()+"/"+userlist.get(n).getAddress()+"/"+userlist.get(n).getJoindate()+"/"+userlist.get(n).getGrade()+"/"+userlist.get(n).getCity() %></a></div>
		
	<%
	} 
	
	%>	
</body>
</html>
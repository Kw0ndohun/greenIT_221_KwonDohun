<%@page import="db.UserDTO"%>
<%@page import="java.util.ArrayList"%>
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
		<h3>회원번호/이름/번호/통신사/가입일/등급/거주지</h3>
	<% 
		UserDAO dao=UserDAO.getDAO();
	    ArrayList<UserDTO> userlist=dao.getUserList();
		
	     
	    for(int n=0; n<userlist.size(); n++){
	    	
	%>
		
		<div><%=userlist.get(n).getCustno()+"/"+userlist.get(n).getCustname()+"/"+userlist.get(n).getPhone()+"/"+userlist.get(n).getAddress()+"/"+userlist.get(n).getJoindate()+"/"+userlist.get(n).getGrade()+"/"+userlist.get(n).getCity() %><a href="userUpdate.jsp?no=<%=userlist.get(n).getCustno()%>">수정</a><a href="userDelPro.jsp?no=<%=userlist.get(n).getCustno()%>">제거</a></div><br>

	<%
	
	}
	    
	%>
</body>
</html>
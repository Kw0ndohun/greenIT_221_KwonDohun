<%@page import="db.UserDAO"%>
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
<h1>업데이트</h1>
<%
	int no=Integer.parseInt(request.getParameter("no"));
	UserDAO dao=UserDAO.getDAO();
	UserDTO user=dao.getUser(no);
	System.out.println(no);
%>
	<form method="post" action="userUpdatePro.jsp?no=<%=no%>">
		회원이름<input type="text" name="name" required value="<%=user.getCustname()%>"><br>
		번호<input type="text" name="phone" required value="<%=user.getPhone()%>"><br>
		통신사<br>skt<input type="checkbox" value="skt" name="add1">
		kt<input type="checkbox" value="kt" name="add2">
		lg<input type="checkbox" value="lg" name="add3"><br>
		등급<input type="text" name="grade" required value="<%=user.getGrade()%>"><br>
		거주지<input type="text" name="city" required value="<%=user.getCity()%>"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>
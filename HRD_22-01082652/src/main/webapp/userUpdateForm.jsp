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
	<h1>유저수정</h1>
	<%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		UserDAO dao=UserDAO.getUserDAO();
		ArrayList<UserDTO> userlist=dao.viewUser();
		int no=Integer.parseInt(request.getParameter("no"));
			
	%>
		<form method="post" action="userUpdateFormPro.jsp">
			No<input type="text" value="<%=userlist.get(no).getCustno() %>" readOnly name="custno">
			이름<input type="text" value="<%=userlist.get(no).getCustname() %>" name="custname" required>
			번호<input type="text" value="<%=userlist.get(no).getPhone() %>" name="phone" required>
			통신사<input type="text" value="<%=userlist.get(no).getAddress() %>" name="address" required>
			가입일자<input type="text" value="<%=userlist.get(no).getJoindate()%>" readOnly name="joindate">
			등급<input type="text" value="<%=userlist.get(no).getGrade()%>" name="grade" required>
			거주지<input type="text" value="<%=userlist.get(no).getCity()%>" name="city" required>
			<input type="submit" value="수정">
		</form>
		
	<%
	
	%>	
</body>
</html>
<%@page import="db.UserSellDTO"%>
<%@page import="db.UserSellDAO"%>
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
	<h1>유저판매조회</h1>
	<h3>회원번호/판매번호/단가/수량/가격/상품코드/판매일자</h3>
	<%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		UserSellDAO dao=UserSellDAO.getUserSellDAO();
		ArrayList<UserSellDTO> userlist=dao.viewUserSell();
		for(int n=0; n<userlist.size(); n++){
			 
	%>
		 
		<div><a href="userSellUpdateForm.jsp?no=<%=n%>"><%=userlist.get(n).getCustno()+"/"+userlist.get(n).getSalenol()+"/"+userlist.get(n).getPcost()+"/"+userlist.get(n).getAmount()+"/"+userlist.get(n).getPrice()+"/"+userlist.get(n).getPcode()+"/"+userlist.get(n).getSdate() %></a></div>
		
	<%
	} 
	
	%>	
</body>
</html>
<%@page import="db.UserSellDTO"%>
<%@page import="db.UserSellDAO"%>
<%@page import="java.util.Date"%>
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
		
		UserSellDAO dao=UserSellDAO.getUserSellDAO();
		
		int custno=Integer.parseInt(request.getParameter("custno"));
		int pcost=Integer.parseInt(request.getParameter("pcost"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		int price=Integer.parseInt(request.getParameter("price"));
		String pcode=request.getParameter("pcode");
		Date date=new Date();
		long dd=System.currentTimeMillis();
		UserSellDTO userSell;
		userSell=new UserSellDTO(custno,dao.countUserSell()+1,pcost,amount,price,pcode,dd);
		String url="";
		
		if(dao.addUserSell(userSell)){
			url="index.jsp";
		}
		else{
			url="addUserSell.jsp";
		}
		
		response.sendRedirect(url);
	%>
</body>
</html>
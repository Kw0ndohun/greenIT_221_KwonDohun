<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="db.SellInfoDTO"%>
<%@page import="db.SellInfoDAO"%>
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
		
		SellInfoDAO dao=SellInfoDAO.getDAO();
		
		SellInfoDTO info;
		int custno=Integer.parseInt(request.getParameter("custno"));		
		int pcost=Integer.parseInt(request.getParameter("pcost"));		
		int amount=Integer.parseInt(request.getParameter("amount"));		
		int price=Integer.parseInt(request.getParameter("price"));		
		String pcode=request.getParameter("pcode");		
		int tempyear=LocalDate.now().getYear();
		int tempmonth=LocalDate.now().getMonthValue();
		int tempday=LocalDate.now().getDayOfMonth();
		Date day=new Date(tempyear,tempmonth,tempday);
		
		info=new SellInfoDTO(custno,dao.countInfo(),pcost,amount,price,pcode,day);
		
		String url="";
		if(dao.addSellInfo(info)){
			url="index.jsp";
		}
		else{
			url="join.jsp";
		}
		
		response.sendRedirect(url);
		 %>
</body>
</html>
<%@page import="db.SellInfoDTO"%>
<%@page import="db.SellInfoDAO"%>
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
		<h3>회원번호/판매번호/코스트/수량/가격/코드/판매일</h3>
	<% 
		SellInfoDAO dao=SellInfoDAO.getDAO();
	    ArrayList<SellInfoDTO> infolist=dao.getInfoList();
		
	    
	    for(int n=0; n<infolist.size(); n++){
	    	
	%>
		
		<div><%=infolist.get(n).getCustno()+"/"+infolist.get(n).getSalenol()+"/"+infolist.get(n).getPcost()+"/"+infolist.get(n).getAmount()+"/"+infolist.get(n).getPrice()+"/"+infolist.get(n).getPcode()+"/"+infolist.get(n).getSdate()%></div><br>

	<%
	
	}
	    
	%>
</body>
</html>
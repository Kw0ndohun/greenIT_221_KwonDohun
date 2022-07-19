<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인덱스페이지</h1>
	<form>
		<input type="button" value="등록" onclick="location.href='join.jsp'">
		<input type="button" value="판매정보등록" onclick="location.href='SellInfo.jsp'">
		<input type="button" value="유저정보" onclick="location.href='userInfo.jsp'">
		<input type="button" value="판매정보" onclick="location.href='sellInformation.jsp'">
	</form>
</body> 
</html>
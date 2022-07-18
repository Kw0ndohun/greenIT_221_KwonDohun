<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>join</h1>
	<form method="post" action="joinPro.jsp">
		이름<input type="text" name="name" id="name">
		휴대폰<input type="text" name="phone" id="phone">
		통신사<input type="text" name="address" id="address">
		사는곳<input type="text" name="city" id="city">
		<input type="button" onclick="boxCheck(form)">
	</form>
	
</body>
	<script src="js/validation.js"></script>
</html>
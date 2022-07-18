<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>addUserSell</h1>
	<form method="post" action="addUserSellPro.jsp">
		회원번호<input type="text" name="no" id="no" required>
		단가<input type="text" name="pcost" id="pcost" required>
		수량<input type="text" name="amount" id="amount" required>
		가격<input type="text" name="price" id="price" required>
		상품코드<input type="text" name="pcode" id="pcode" required>
		<input type="submit" value="추가">
	</form>
	
</body>
	<script src="js/validation.js"></script>
</html>
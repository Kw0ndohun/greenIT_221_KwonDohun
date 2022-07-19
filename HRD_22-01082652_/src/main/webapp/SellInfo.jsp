<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="SellInfoPro.jsp">
		회원번호<input type="text" name="custno" required><br>
		단가<input type="text" name="pcost" required><br>
		수량<input type="text" name="amount" required><br>
		가격<input type="text" name="price" required><br>
		상품코드<input type="text" name="pcode" required><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>
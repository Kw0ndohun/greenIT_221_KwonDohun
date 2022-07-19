<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>등록</h1>
	<form method="post" action="joinPro.jsp">
		회원이름<input type="text" name="name" required><br>
		번호<input type="text" name="phone" required><br>
		통신사<br>skt<input type="checkbox" value="skt" name="add1">
		kt<input type="checkbox" value="kt" name="add2">
		lg<input type="checkbox" value="lg" name="add3"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>
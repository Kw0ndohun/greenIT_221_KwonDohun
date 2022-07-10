<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
	<link rel="stylesheet" href="css/form.css">
    <title>Index</title>
</head>
<body>
    <h1>INDEX</h1>
    <form>
        <div class="contents">
        </div>
        <div class="buttons">
        	<input type="button" value="로그인" onclick="location.href='./loginR'">
        	<input type="button" value="로그아웃" onclick="location.href='logoutPro.jsp'">
        	<input type="button" value="회원가입" onclick="location.href='./joinR'">
        	<input type="button" value="회원탈퇴" onclick="location.href='./leave'">
        </div>
    </form>
	
    <script src="script/validation.js"></script>
</body>
</html>
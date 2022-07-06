<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="css/form.css">
    <title>Login</title>
</head>
<body>
    <h1>LOGIN</h1>
    <form method="post" action="loginPro.jsp">
        <div class="contents">
        </div>
        <div class="buttons">
        	아이디<br>
        	<input type="text" class="idmsg" name="id" id="id" onblur="blurNulls(id)"><br>
        	<span style="display:none;color: red;" aria-live="assertive" id="idmsg">필수 정보입니다.</span>
        	비밀번호<br>
        	<input type="password" class="pwmsg" name="pw" id="pw" onblur="blurNulls(id)"><br>
        	<span style="display:none;color: red;" aria-live="assertive" id="pwmsg">필수 정보입니다.</span>
        </div>
        <div class="buttons">
        	<input type="button" value="로그인" onclick="loginCk(form)">
        	<input type="button" value="취소" onclick="location.href='lndex.jsp'">
        </div>
    </form>
    <script src="script/validation.js"></script>
 </body>
</html>
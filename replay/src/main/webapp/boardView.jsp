<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/board.css">
    <title>BOARD VIEW</title>
</head>
<body>
    <h1>DOOOO BOARD</h1>
    <div class="formContainer">
        <form method="post" action="">
            <input type="text" name="title" id="title" required placeholder="title" readonly value="<%=로딩된타이틀%>"><br>
            <textarea name="contents" placeholder="contents text" required readonly><%=로딩된 컨텐츠%></textarea><br>
            <input type="button" value="뒤로가기" onclick="">
            <input type="submit" value="글쓰기">
        </form>

    </div> 
</body>
</html>
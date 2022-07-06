<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/board.css">
    <title>BOARD WRITE</title>
</head>
<body>
    <h1>DOOOO BOARD</h1>
    <div class="formContainer">
 		<!-- 폼에 작성된 내용을 폼 프로로 보내서 검증 -->
        <form method="post" action="boardWriteFormPro.jsp">
            <input type="text" name="title" id="title" required placeholder="title"><br>
            <textarea name="contents" placeholder="contents text" required></textarea><br>
            <input type="button" value="뒤로가기" onclick="board.jsp">
            <input type="button" value="글쓰기" onclick="boardContentsCheck(form)">
        </form>
    </div>
    <script src="script/board_validation.js"></script>
</body>
</html>
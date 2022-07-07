<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalTime"%>
<%@page import="javax.xml.crypto.Data"%>
<%@page import="reWeb.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="reWeb.BoardDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardWriteFormPro</title>
</head>
<body>
	
	<%
	//라이트 폼에서 온 글쓰기 제목과 컨텐츠를 받아서 sql 보드 테이블에 넣어줘야함
	//no를 어딘가에서 기억해서 늘려주고
	//랜덤으로 코드 생성. ㄴㄴ 코드도 숫자 늘려주기
	
	request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
	
		BoardDAO dao=BoardDAO.getInstance();
		BoardDTO board=null;
		LocalDateTime now = LocalDateTime.now();
		String formatNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		
		board=new BoardDTO(title,contents,formatNow);
		
		
		String url="";
		if(dao.addBoard(board)){
			url="board.jsp";
		}
		else{
			url="boardWriteForm.jsp";
		}
		response.sendRedirect(url);
	%>
</body>
</html>
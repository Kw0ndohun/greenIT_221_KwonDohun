<%@page import="reWeb.UserDAO"%>
<%@page import="reWeb.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinPro</title>
</head>
<body>
<% 
	//유저 DTO(user폼을 가진 클래스) 를 만들고
	UserDTO user=null;
	//유저 DAO(DTO양식을 바탕으로 유저를 생성하는 클래스)의 인스턴스를 dao에 담고
	UserDAO dao=UserDAO.getInstance();
	
	//리퀘스트 리스폰스 인코딩을 지정
	request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    
    //받아온 파라미터들을 각 변수에 담아서 UserDTO양식에 담아 유저를 생성할 준비
    String id=request.getParameter("id");
    String pw=request.getParameter("pw");
    String name=request.getParameter("name");
    int year=Integer.parseInt(request.getParameter("year"));
    int month=Integer.parseInt(request.getParameter("month"));
    int day=Integer.parseInt(request.getParameter("day"));
    String gender=request.getParameter("gender");
    String email=request.getParameter("email");
    String coun=request.getParameter("coun");
    String mobile=request.getParameter("mobile");
    
    //UserDTO양식으로 생성 (유저생성)
    user=new UserDTO(id,pw,name,year,month,day,gender,email,coun,mobile);
    
    //유저 생성이 성공하면 보낼 url 선언
    String url="";
    if(dao.addUser(user)){
    	url="index.jsp";
    }
    else{
    	url="join.jsp";
    }
    //초기화된 url로 전송
    response.sendRedirect(url);
%>
    
</body>
</html>
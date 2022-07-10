package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reWeb.UserDAO;
import reWeb.UserDTO;

/**
 * Servlet implementation class joinAction
 */
//@WebServlet("/joinAction")
public class joinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//유저 DTO(user폼을 가진 클래스) 를 만들고
				UserDTO user=null;
				//유저 DAO(DTO양식을 바탕으로 유저를 생성하는 클래스)의 인스턴스를 dao에 담고
				UserDAO dao=UserDAO.getInstance();
				
			    
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
			    	url="./joinR";
			    }
			    //초기화된 url로 전송
			    request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//리퀘스트 리스폰스 인코딩을 지정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doGet(request, response);
		
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reWeb.UserDAO;
import reWeb.UserDTO;

/**
 * Servlet implementation class LoginAction
 */
//@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		UserDTO user=null;
		UserDAO dao=UserDAO.getInstance();
		
		//리퀘스트 리스폰스 인코딩을 지정
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    
	    String id=request.getParameter("id");
	    String pw=request.getParameter("pw");
	    
	    user=new UserDTO(id,pw);
	    HttpSession session= request.getSession();
	    String url="";
	    if(dao.loginUser(user)){
	    	session.setAttribute("log",user.getId());
	    	url="main.jsp";
	    }
	    else{
	    	url="index.jsp";
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	    
	    
		
		
	}

}

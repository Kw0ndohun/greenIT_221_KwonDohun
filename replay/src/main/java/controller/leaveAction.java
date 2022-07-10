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
 * Servlet implementation class leaveAction
 */
//@WebServlet("/leaveAction")
public class leaveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public leaveAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		UserDTO user=null;
		UserDAO dao=UserDAO.getInstance();
		
	    
	    HttpSession session= request.getSession();
	    String id=String.valueOf(session.getAttribute("log"));
	    String url="";
	    if(dao.delUser(id)){
	    	session.setAttribute("log",user.getId());
	    	url="main.jsp";
	    }
	    else{
	    	url="index.jsp";
	    }
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

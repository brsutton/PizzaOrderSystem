package com.yash.pos.usercontroller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This controller sets request states and redirects to the home page after user logout 
 * Servlet implementation class LogOutController
 */
@WebServlet("/LogOutController")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", null);
		request.setAttribute("infoMessage", "Hello Again, What Would You Like To Do???");
		request.setAttribute("state", "welcome");
		request.getSession().invalidate();
		getServletContext().getRequestDispatcher("/home").forward(request, response);
		
	}

	

}

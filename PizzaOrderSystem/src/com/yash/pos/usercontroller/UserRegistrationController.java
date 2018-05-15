package com.yash.pos.usercontroller;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.pos.model.User;
import com.yash.pos.service.UserService;
import com.yash.pos.servicefactory.ServiceFactory;


/**
 * Servlet implementation class UserController
 */
@WebServlet(name = "UserRegistrationController", urlPatterns = { "/UserRegistrationController" })
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = null;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setContact(request.getParameter("contact"));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));
		user.setLogin_name(request.getParameter("login_name"));
		user.setPassword(request.getParameter("password"));

		userService = ServiceFactory.getUserServiceImpl();
		boolean success = userService.register(user);
		request.setAttribute("msg", "Login To Continue..");
		request.setAttribute("state", "login");
		if (success) {
			
			request.setAttribute("infoMessage", "Success ! Your Registration Compleated...Please Login to Continue...");
			request.setAttribute("msg", "");
		} else {
			request.setAttribute("msg", "Error Something went wrong please try again.....");
			request.setAttribute("infoMessage", "");
		}
		getServletContext().getRequestDispatcher("/home").forward(request, response);

	}

}

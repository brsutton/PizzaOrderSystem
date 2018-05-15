package com.yash.pos.usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.pos.model.User;
import com.yash.pos.service.UserService;
import com.yash.pos.servicefactory.ServiceFactory;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet(name = "UserLoginController", urlPatterns = { "/UserLoginController" })
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = null;
	User user = null;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		userService = ServiceFactory.getUserServiceImpl();
		boolean valid = userService.authenticateUser(request.getParameter("loginName"),
				request.getParameter("password"));

		if (!valid) {
			request.setAttribute("msg", "Your login credentals are invalid...Please try again...");
			request.setAttribute("state", "login");
			request.setAttribute("infoMessage", "");

		} else {
			user = userService.getEmployeeByUserId(request.getParameter("loginName"));
			
			request.setAttribute("msg", "");
			request.setAttribute("state", "welcome");
			request.setAttribute("infoMessage", "Welcome " + user.getName());
			request.getSession().setAttribute("user_id", user.getId());
			request.getSession().setAttribute("loggedInUser", user);
		}
		getServletContext().getRequestDispatcher("/home").forward(request, response);
	}

}

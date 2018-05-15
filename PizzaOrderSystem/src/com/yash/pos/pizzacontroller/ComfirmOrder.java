package com.yash.pos.pizzacontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.pos.model.PizzaOrder;
import com.yash.pos.model.User;
import com.yash.pos.servicefactory.ServiceFactory;
import com.yash.pos.serviceimpl.OrderServiceImpl;

/**
 * This Servlet Controller Confirms the order has been placed and passes the request on
 * Servlet implementation class ComfirmOrder
 */
@WebServlet("/ComfirmOrder")
public class ComfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PizzaOrder order = (PizzaOrder) request.getSession().getAttribute("CurrentOrder");
		OrderServiceImpl osi = ServiceFactory.getOrderServiceImpl();
		User user = (User) request.getSession().getAttribute("loggedInUser");
		order.setStatus("Processing");
		order.setUserId(user.getId());
		osi.addOrder(order, user.getId());
		
		request.getSession().setAttribute("CurrentOrder", order);
		
		request.setAttribute("msg", "");
		request.setAttribute("state", "orderConfimed");
		request.setAttribute("infoMessage", "Congradulations Your Oder Has Been Placed!!!!");
		
		getServletContext().getRequestDispatcher("/home").forward(request, response);
	}

}

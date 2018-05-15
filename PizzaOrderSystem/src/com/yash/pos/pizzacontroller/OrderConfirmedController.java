package com.yash.pos.pizzacontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.pos.model.PizzaOrder;
import com.yash.pos.servicefactory.ServiceFactory;
import com.yash.pos.serviceimpl.OrderServiceImpl;

/**
 * This controller is the final step in order confirmation
 * Servlet implementation class OrderConfirmedController
 */
@WebServlet("/OrderConfirmedController")
public class OrderConfirmedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServiceImpl osi = ServiceFactory.getOrderServiceImpl();
		PizzaOrder order =  (PizzaOrder) request.getSession().getAttribute("CurrentOrder");
		PizzaOrder pizzaOrder = osi.getOrder(order.getId());
		request.getSession().setAttribute("CurrentOrder", pizzaOrder);
		
		request.setAttribute("msg", "");
		request.setAttribute("state", "orderConfimed");
		request.setAttribute("infoMessage", "Congradulations Your Oder Has Been Placed!!!!s&#^*$(@");
		
		getServletContext().getRequestDispatcher("/home").forward(request, response);
		
	}

}

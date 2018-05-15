package com.yash.pos.pizzacontroller;

import java.io.IOException; 
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.pos.model.PizzaOrder;
import com.yash.pos.service.OrderService;
import com.yash.pos.servicefactory.ServiceFactory;

/**
 * This Controller is used for displaying all the orders in the system
 * Servlet implementation class DisplayAllOrders
 */
@WebServlet("/DisplayAllOrders")
public class DisplayAllOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderService orderService = ServiceFactory.getOrderServiceImpl();
		
		ArrayList<PizzaOrder> orders = orderService.allOrders();
		
		request.getSession().setAttribute("allOrders", orders);

		request.setAttribute("msg", "");
		request.setAttribute("state", "showAllOrders");
		request.setAttribute("infoMessage", "<--Pick a order to Update-->");

		getServletContext().getRequestDispatcher("/home").forward(request, response);
	}

}

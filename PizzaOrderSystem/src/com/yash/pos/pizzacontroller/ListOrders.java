package com.yash.pos.pizzacontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.pos.model.PizzaOrder;
import com.yash.pos.servicefactory.ServiceFactory;
import com.yash.pos.serviceimpl.OrderServiceImpl;

/**
 * This Controller gets and sets the user orders to session attribute variables then redirects to the 
 * home page for displaying the user orders
 * Servlet implementation class ListOrders
 */
@WebServlet("/ListOrders")
public class ListOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderServiceImpl osi = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		osi = ServiceFactory.getOrderServiceImpl();
		int id = (int) request.getSession().getAttribute("user_id");
		ArrayList<PizzaOrder> pizzaOrders = osi.userOrders(id);
		request.getSession().setAttribute("userOrders", pizzaOrders);
		request.setAttribute("msg", "");
		request.setAttribute("state", "listUserOrders");
		request.setAttribute("infoMessage", "");
		getServletContext().getRequestDispatcher("/home").forward(request, response);
	}
}

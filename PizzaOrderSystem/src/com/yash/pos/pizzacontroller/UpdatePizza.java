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
 * This is used for updating the pizza status
 * This Controller Updates the status of the Pizza Order
 * Servlet implementation class PreparePizza
 */
@WebServlet("/UpdatePizza")
public class UpdatePizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaOrder pizzaOrder = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderServiceImpl osi = ServiceFactory.getOrderServiceImpl();
		String orderId = request.getParameter("orderId");
		if (orderId != "") {
			String status = orderId.substring(orderId.length() - 2, orderId.length());
			pizzaOrder = osi.getOrder(Integer.parseInt(orderId.substring(0, orderId.length() - 2)));
			setStatus(status);
			osi.updateOrder(pizzaOrder);
		}
		ArrayList<PizzaOrder> orders = osi.allOrders();
		request.getSession().setAttribute("allOrders", orders);
		request.setAttribute("msg", "");
		request.setAttribute("state", "showAllOrders");
		request.setAttribute("infoMessage", "<--Pick a order to Update-->");
		
		getServletContext().getRequestDispatcher("/home").forward(request, response);
	}

	/**
	 * Helper method to set the status of the pizza order
	 * @param status
	 */
	private void setStatus(String status) {
		switch (status) {
		case "PR":
			pizzaOrder.setStatus("Preparing");
			break;
		case "BA":
			pizzaOrder.setStatus("Baking");
			break;
		case "CU":
			pizzaOrder.setStatus("Cutting");
			break;
		case "BO":
			pizzaOrder.setStatus("Boxing");
			break;
		default:
			break;
		}
	}
}

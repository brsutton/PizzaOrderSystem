package com.yash.pos.pizzacontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.pos.model.PizzaOrder;
import com.yash.pos.model.User;

/**
 * This is used for the ordering process Servlet implementation class
 * OrderControler
 */
@WebServlet("/OrderControler")
public class OrderControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaOrder order = new PizzaOrder();
	int cost;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("pizzaState").equals("type")) {
			order.setSize(request.getParameter("pizzaSize"));
			order.setPizzaType(request.getParameter("pizzaType"));
			order.setStatus("ordering");
			request.getSession().setAttribute("CurrentOrder", order);
			request.setAttribute("state", "newOrder");
			request.setAttribute("pizzaState", "kindSet");
			request.setAttribute("msg", "");
			request.setAttribute("infoMessage", "Lets Order Pizza");
			request.setAttribute("state", "newOrder");
			getServletContext().getRequestDispatcher("/home").forward(request, response);

		} else if (request.getSession().getAttribute("pizzaState").equals("toppingsSet")) {
			order = (PizzaOrder) request.getSession().getAttribute("CurrentOrder");
			Enumeration<String> parNames = request.getParameterNames();
			String toppings = "";
			while (parNames.hasMoreElements()) {
				String s = parNames.nextElement();
				toppings += s + request.getParameter(s) + ",";
			}
			order.setToppings(toppings);
			figurePrice(request, response);
			order.setCost(cost);
			request.setAttribute("msg", "");
			request.setAttribute("infoMessage", "Lets Order Pizza");
			request.getSession().setAttribute("CurrentOrder", order);
			request.setAttribute("state", "newOrder");
			request.setAttribute("pizzaState", "toppingsSet");
			getServletContext().getRequestDispatcher("/home").forward(request, response);

		}
	}

	/**
	 * Calculates the price of the pizza
	 * 
	 * @param request
	 * @param response
	 */
	private void figurePrice(HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings("unchecked")
		ArrayList<String[]> pizzas = (ArrayList<String[]>) request.getSession().getAttribute("pizzaTypes");
		for (String[] pizza : pizzas) {
			if (pizza[0].equals(order.getPizzaType())) {
				String[] size = pizza[1].split(" ");
				switch (order.getSize()) {
				case "small":
					cost += (Integer.parseInt(size[0]));
					break;
				case "medium":
					cost += (Integer.parseInt(size[1]));
					break;
				case "large":
					cost += (Integer.parseInt(size[2]));
					break;
				default:
					break;
				}
			}
		}
		figureToppingCost(request, response);
	}

	/**
	 * Called to finish calculating price
	 * 
	 * @param request
	 * @param response
	 */
	private void figureToppingCost(HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings("unchecked")
		ArrayList<String[]> toppings = (ArrayList<String[]>) request.getSession().getAttribute("pizzaToppings");

		int count;
		String[] selectedToppings = order.getToppings().split(",");
		String tempTopping = "";
		for (String selectedTopping : selectedToppings) {
			if (selectedTopping.length() != 0) {
				count = Integer.parseInt(String.valueOf(selectedTopping.charAt(selectedTopping.length() - 1)));
				tempTopping = selectedTopping.substring(0, selectedTopping.length() - 1);

				for (String[] topping : toppings) {
					if (topping[0].equals(tempTopping)) {
						cost += Integer.parseInt(topping[1]) * count;
					}
				}
			}
		}

	}

}

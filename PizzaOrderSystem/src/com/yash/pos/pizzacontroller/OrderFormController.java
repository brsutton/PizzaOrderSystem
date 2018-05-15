package com.yash.pos.pizzacontroller;

import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This is used for setting up the order form the Menu Items are pulled from a file C://Brian//pos//pizzaOrder.txt
 * Servlet implementation class OrderFormController
 */
@WebServlet("/OrderFormController")
public class OrderFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String []> pizzaTypes = null;  
	private ArrayList<String []> pizzaToppings = null; 
	private int state = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pizzaToppings = new ArrayList<>(); 
		pizzaTypes = new ArrayList<>();
		File file = new File("C://Brian//pos//pizzaOrder.txt");
		Scanner input = new Scanner(file);
		String in = input.nextLine();
		
		while(in.equals("pizza")){
			
		String [] temp = {input.nextLine(),  input.nextLine()};
		pizzaTypes.add(temp);
		in = input.nextLine();
		}
		
		in = input.nextLine();
		while(in.equals("topping")){
		String [] temp = {input.nextLine(),  input.nextLine()};
		pizzaToppings.add(temp);
		in = input.nextLine();
		}
		
		request.getSession().setAttribute("pizzaTypes", pizzaTypes);
		request.getSession().setAttribute("pizzaToppings", pizzaToppings);
		request.getSession().setAttribute("pizzaState", "type");
		
		request.setAttribute("msg", "");
		request.setAttribute("info", "Order Some Pizza");
		request.setAttribute("state", "newOrder");
		getServletContext().getRequestDispatcher("/home").forward(request, response);
	}

	
}

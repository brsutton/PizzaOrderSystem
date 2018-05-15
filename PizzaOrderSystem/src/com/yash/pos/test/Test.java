package com.yash.pos.test;

import java.util.ArrayList;

//import com.sun.pisces.PiscesRenderer;
import com.yash.pos.model.PizzaOrder;
import com.yash.pos.model.User;
import com.yash.pos.orderdao.OrderDao;
import com.yash.pos.orderdaoimpl.OrderDaoImpl;
import com.yash.pos.service.UserService;
import com.yash.pos.serviceimpl.OrderServiceImpl;
import com.yash.pos.serviceimpl.UserServiceImpl;
import com.yash.pos.userdaohibernateimpl.UserDaoImpl;

public class Test {

	public static void main(String[] args) {

		

		/*UserService us = new UserServiceImpl();
		us.register(user);
*/
		
		/*System.out.println(us.authenticateUser(user.getLogin_name(), user.getPassword()));*/
		
		/*User user = new User();
		user.setLogin_name("Brian");
		user.setPassword("root");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.insertUser(user);*/
		
		/*OrderDao orderDao = new OrderDaoImpl();
		User user = userDaoImpl.getUserById("Brian");
		
		OrderServiceImpl us = new OrderServiceImpl();
		
		ArrayList<PizzaOrder> po = us.allOrders();
		
		for (PizzaOrder pizzaOrder : po) {
			System.out.println(pizzaOrder.getPizzaType());
		}*/
		
	/*	System.out.println(user.getId()+"-------------------------------------------------");
		PizzaOrder order = new PizzaOrder();
		order.setCost(4);
		order.setPizzaType("Mony");
		order.setSize("large");
		order.setToppings("none");
		order.setStatus("Prossesing");
		order.setUserId(user.getId());
		orderDao.insert(order, user.getId());*/
		
		/*String s = "234342BA";
		
		System.out.println(s.substring(s.length()-2,s.length()));*/
		
		OrderServiceImpl us = new OrderServiceImpl();
		OrderDao orderDao = new OrderDaoImpl();
		/*PizzaOrder order =  us.getOrder(98304);*/
		ArrayList<PizzaOrder> orders = us.userOrders(98304);
		System.out.println(orders);
		for (PizzaOrder pizzaOrder : orders) {
			System.out.println(pizzaOrder.getPizzaType());
		}
	}

}

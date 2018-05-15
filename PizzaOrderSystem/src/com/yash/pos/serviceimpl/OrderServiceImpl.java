package com.yash.pos.serviceimpl;

import java.util.ArrayList;

import com.yash.pos.model.PizzaOrder;
import com.yash.pos.orderdao.OrderDao;
import com.yash.pos.orderdaoimpl.OrderDaoImpl;
import com.yash.pos.service.OrderService;
import com.yash.pos.userdao.UserDao;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao = null;

	@Override
	public boolean addOrder(PizzaOrder order, int userId) {
		orderDao = new OrderDaoImpl();
		return orderDao.insert(order, userId);
	}

	@Override
	public PizzaOrder getOrder(int orderId) {
		orderDao = new OrderDaoImpl();
		return orderDao.getOrder(orderId);
	}

	@Override
	public ArrayList<PizzaOrder> allOrders() {
		orderDao = new OrderDaoImpl();
		return orderDao.getAllOrders();
	}

	@Override
	public boolean updateOrder(PizzaOrder pizzaOrder) {
		orderDao = new OrderDaoImpl();
		return orderDao.update(pizzaOrder);
	}

	@Override
	public ArrayList<PizzaOrder> userOrders(int userId) {
		orderDao = new OrderDaoImpl();
		return orderDao.getAllUserOrders(userId);
	}

}

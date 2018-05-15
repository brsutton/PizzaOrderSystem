package com.yash.pos.service;

import java.util.ArrayList;

import com.yash.pos.model.PizzaOrder;

public interface OrderService {
	/**
	 * Adds a new order to the database
	 * @param order
	 * @param userId
	 * @return
	 */
	public boolean addOrder(PizzaOrder order, int userId);
	/**
	 * gets a order from the database this is based on the orderId
	 * @param orderId
	 * @return
	 */
	public PizzaOrder getOrder(int orderId);
	/**
	 * Returns an arrayList of all orders in the system
	 * @return
	 */
	public ArrayList<PizzaOrder> allOrders();
	/**
	 * updates an order in the database
	 * @param pizzaOrder
	 * @return
	 */
	public boolean updateOrder(PizzaOrder pizzaOrder);
	/**
	 * Returns an arrayList of the Users orders
	 * @param userId
	 * @return
	 */
	public ArrayList<PizzaOrder> userOrders(int userId);
}

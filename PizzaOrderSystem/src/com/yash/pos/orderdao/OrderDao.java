package com.yash.pos.orderdao;

import java.util.ArrayList;

import com.yash.pos.model.PizzaOrder;

/**
 * This is the data access layer interface
 * @author Brian Sutton
 *
 */
public interface OrderDao {

	/**
	 * adds on order to the data base
	 * @param order
	 * @param userId
	 * @return
	 */
	public boolean insert(PizzaOrder order, int userId);
	/**
	 * gets a specific order from the database
	 * @param orderId
	 * @return
	 */
	public PizzaOrder getOrder(int orderId);
	/**
	 * gets all orders from the database
	 * @return
	 */
	
	public ArrayList<PizzaOrder> getAllUserOrders(int userId); 
	
	/**
	 * gets all orders in the database
	 * @return
	 */
	public ArrayList<PizzaOrder> getAllOrders();
	/**
	 * updates a Pizza Order with new details
	 * @param order
	 * @return
	 */
	public boolean update(PizzaOrder order);
	
}

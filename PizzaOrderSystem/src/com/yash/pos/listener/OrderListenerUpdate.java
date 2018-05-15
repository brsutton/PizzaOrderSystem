package com.yash.pos.listener;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.yash.pos.model.PizzaOrder;
import com.yash.pos.service.OrderService;
import com.yash.pos.servicefactory.ServiceFactory;

/**
 * This class will be used to listen for updates for the pizzas
 * Application Lifecycle Listener implementation class OrderListenerUpdate
 *
 */
@WebListener
public class OrderListenerUpdate implements HttpSessionAttributeListener {
	private ScheduledExecutorService scheduler;
	int userId;
	HttpSession session;
	HttpSessionBindingEvent attribute;
	/**
	 * Default constructor.
	 */
	public OrderListenerUpdate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent attribute) {
		if (attribute.getName().equals("user_id")) {
			session = attribute.getSession();
			userId = (int) attribute.getValue();
			this.attribute = attribute;
			scheduler = Executors.newSingleThreadScheduledExecutor();
			scheduler.scheduleAtFixedRate(new AutomateRefresh(), 0, 10, TimeUnit.SECONDS);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent arg0) {

	}

	public class AutomateRefresh implements Runnable {
		public void run() {
			System.out.println(userId);
			OrderService orderService = ServiceFactory.getOrderServiceImpl();
			ArrayList<PizzaOrder> pizzaOrders = orderService.userOrders(userId);

			for (PizzaOrder pizzaOrder : pizzaOrders) {
				if (pizzaOrder.getStatus().equals("Boxing")) {
					System.out.println("order is boxxing");
					session.setAttribute("pizzaReady", "ready");
					
					ServletContext application = attribute.getSession().getServletContext();
					application.setAttribute("pizzaReady", "ready");
					/*
					 * PopUpController controller = new PopUpController();
					 * HttpServletRequest request = null; HttpServletResponse
					 * resonce = null; try { controller.service(request,
					 * resonce); } catch (ServletException e) { // TODO
					 * Auto-generated catch block e.printStackTrace(); } catch
					 * (IOException e) { // TODO Auto-generated catch block
					 * e.printStackTrace(); }
					 */
				}
			}
		}
	}
}

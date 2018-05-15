package com.yash.pos.orderdaoimpl;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.yash.pos.hibernate.util.HibernateUtil;
import com.yash.pos.model.PizzaOrder;
import com.yash.pos.orderdao.OrderDao;

//import jdk.nashorn.internal.ir.RuntimeNode.Request;
/**
 * The implementation of the Order Dao
 * @author Brian Sutton
 *
 */
@SuppressWarnings("unchecked")
public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean insert(PizzaOrder order, int userId) {

		Session session = HibernateUtil.openSession();
		Transaction trans = null;
		try {
			trans = session.getTransaction();
			trans.begin();
			session.save(order);
			trans.commit();
		} catch (HibernateException ex) {
			if (trans != null) {
				trans.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public PizzaOrder getOrder(int orderId) {

		Session session = HibernateUtil.openSession();
		Transaction trans = null;
		PizzaOrder order = null;
		try {
			trans = session.getTransaction();
			trans.begin();

			Criteria criteria = session.createCriteria(PizzaOrder.class).add(Restrictions.eq("id", orderId));
			order = (PizzaOrder) criteria.uniqueResult();
			trans.commit();
		} catch (HibernateException ex) {
			if (trans != null) {
				trans.rollback();
			}
			ex.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<PizzaOrder> getAllOrders() {

		Session session = HibernateUtil.openSession();
		Transaction trans = null;
		ArrayList<PizzaOrder> orders = null;
		try {
			trans = session.getTransaction();
			trans.begin();

			Criteria criteria = session.createCriteria(PizzaOrder.class);
			orders = (ArrayList<PizzaOrder>) criteria.list();
			trans.commit();
		} catch (HibernateException ex) {
			if (trans != null) {
				trans.rollback();
			}
			ex.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return orders;

	}

	@Override
	
	public boolean update(PizzaOrder order) {
		Session session = HibernateUtil.openSession();
		Transaction trans = null;
		try {
			trans = session.getTransaction();
			trans.begin();
			session.update(order);
			trans.commit();
		} catch (HibernateException ex) {
			if (trans != null) {
				trans.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public ArrayList<PizzaOrder> getAllUserOrders(int userId){
		Session session = HibernateUtil.openSession();
		Transaction trans = null;
		ArrayList<PizzaOrder> orders = null;
		try {
			trans = session.getTransaction();
			trans.begin();

			Criteria criteria = session.createCriteria(PizzaOrder.class).add(Restrictions.eq("userId", userId));
			orders = (ArrayList<PizzaOrder>) criteria.list();
			trans.commit();
		} catch (HibernateException ex) {
			if (trans != null) {
				trans.rollback();
			}
			ex.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return orders;
	}

}

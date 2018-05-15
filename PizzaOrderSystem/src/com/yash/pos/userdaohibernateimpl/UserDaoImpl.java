package com.yash.pos.userdaohibernateimpl;

import java.util.List; 

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.yash.pos.hibernate.util.HibernateUtil;
import com.yash.pos.model.User;
import com.yash.pos.userdao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean insertUser(User user) {
		Session session = HibernateUtil.openSession();
		
		Transaction trans = null;
		
		
		try {
			trans = session.getTransaction();
			System.out.println("Insert Rann___--User----Before------");
			trans.begin();
			
			session.save(user);
			System.out.println("Insert Rann___--User------After----");
			trans.commit();
		} catch (HibernateException ex) {
			if (trans != null) {
				trans.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public void updateUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserById(String userId) {
		User user = null;
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("login_name", userId));
		try {
			user = (User) criteria.uniqueResult();			
		} catch (Exception e) {
			System.out.println(e.getMessage() +"  getUserByID Method..........^*&&^*^&");
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> showAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean authenticateUser(String userId, String password) {
		User user = getUserById(userId);
		if (user != null && user.getLogin_name().equals(userId) && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}

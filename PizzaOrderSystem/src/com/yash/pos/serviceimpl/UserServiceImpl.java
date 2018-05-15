package com.yash.pos.serviceimpl;

import java.util.List;

import com.yash.pos.model.User;
import com.yash.pos.service.UserService;
import com.yash.pos.userdao.UserDao;
import com.yash.pos.userdaohibernateimpl.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao userDao = null;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public boolean authenticateUser(String userId, String password) {
		return userDao.authenticateUser(userId, password);
	}

	@Override
	public User getEmployeeByUserId(String userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public List<User> getListOfUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean register(User user) {

		return userDao.insertUser(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

}

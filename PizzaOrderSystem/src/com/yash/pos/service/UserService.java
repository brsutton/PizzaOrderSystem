package com.yash.pos.service;

import java.util.List;

import com.yash.pos.model.User;


public interface UserService {
	
	public boolean authenticateUser(String userId, String password);

	public User getEmployeeByUserId(String userId);

	public List<User> getListOfUser();

	public boolean register(User user);
	
	public void deleteUser(int id);
}

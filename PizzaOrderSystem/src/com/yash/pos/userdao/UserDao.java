package com.yash.pos.userdao;

import java.util.List;

import com.yash.pos.model.User;


public interface UserDao {

	/**
	 * Adds a user to the database
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user);
	/**
	 * Updates a users info
	 * @param id
	 */
	public void updateUser(int id);
	/**
	 * deletes the user specified by the int id
	 * @param id
	 */
	public void deleteUser(int id);
	/**
	 * Gets and returns a user by the specified int id
	 * @param userId
	 * @return
	 */
	public User getUserById(String userId);
	/**
	 * returns a list of all users in the database
	 * @return
	 */
	public List<User> showAllUser();
	/**
	 * checks the database to see if the user is in the database
	 * @param user
	 * @return
	 */
	public boolean isUserExist(User user);
	/**
	 * Athenticates the user name and password
	 * @param userId
	 * @param password
	 * @return
	 */
	public boolean authenticateUser(String userId, String password);
	
}

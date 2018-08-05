package com.niit.dao;

import com.niit.model.User;

public interface RegisterDao {

	boolean registerUser(User user);
	boolean loginUser(String username, String password);
}

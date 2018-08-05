package com.niit.dao.impl;
import com.niit.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.niit.configuration.DBConnect;
import com.niit.dao.RegisterDao;
import com.niit.model.User;

public class RegisterDaoImpl implements RegisterDao{

	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
	DBConnect dbConnect;
	Connection connection;
	
	public RegisterDaoImpl() throws Exception {
		dbConnect=new DBConnect();
		connection=dbConnect.getConnection();
	}
	
	@Override
	public boolean registerUser(User user) {
		
		
		return false;
	}

	@Override
	public boolean loginUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

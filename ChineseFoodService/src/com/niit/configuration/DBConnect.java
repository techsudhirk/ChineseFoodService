package com.niit.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	Connection connection;
	
	
	
	
	public Connection getConnection() throws Exception
	{
		try {
			Class.forName ("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//jdbc:oracle:thin:@localhost:1521:XE
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "123");
		if(connection!=null)
		{
			System.out.println("connected");
			return connection;
			
		}
		else
		{
			System.out.println("not connected");
			return connection;
		}
	}
}

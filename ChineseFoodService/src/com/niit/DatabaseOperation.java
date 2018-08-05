package com.niit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperation {
  
	public Connection getConnection() throws ClassNotFoundException, SQLException
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
	
  public String register(Connection connection,UserModel model) throws SQLException
  {
	  int rollid;
	  String rollname;
	  String name,address,phone,email,username,password,auth;
	  name=model.getName();
	  address=model.getAddress();
	  phone=model.getPhone();
	  email=model.getEmail();
	  username=model.getUsername();
	  password=model.getPassword();
	  auth=model.getAuth();
	  PreparedStatement stmt=connection.prepareStatement("insert into customer values(?,?,?,?,?,?)");
	  stmt.setString(1,"");
	  stmt.setString(2,name);
	  stmt.setString(3,address);
	  stmt.setString(4,phone);
	  stmt.setString(5,email);
	  stmt.setString(6,username);
	//  stmt.setString(6,password);
	  stmt.executeQuery();
	  if(auth.equals("admin"))
	  {
		  rollid=1;
		  rollname="Admin";
	  }
	  else
	  {
		  rollid=2;
		  rollname="User";
	  }
	 
	  PreparedStatement stmt2=connection.prepareStatement("insert into LOGIN values(?,?,?)");
	  stmt2.setString(1, username);
	  stmt2.setString(2, password);
	  stmt2.setInt(3, rollid);
	  stmt2.executeQuery();
	  
	/*
	PreparedStatement stmt3=connection.prepareStatement("insert into roledata values(?,?)");
	  stmt3.setInt(1, rollid);
	  stmt3.setString(2, rollname);
	 stmt3.executeQuery();
	  */
	return "registered successfully";
	
  }
  public String Login(UserModel model,Connection connection)
  {
	  try {
		Statement stmt=connection.createStatement();
		String username="",password="",rolename="",auth="";
		int roleid=0;
		username=model.getUsername();
		password=model.getPassword();
		auth=model.getAuth();
		ResultSet rs=stmt.executeQuery("select * from login where username = '"+username+"' and password = '"+password+"'");
		while(rs.next())
		{
			roleid=rs.getInt("roleid");
			System.out.println(roleid);
		}
		
		Statement stmt2=connection.createStatement();
		ResultSet rs2=stmt2.executeQuery("select rolename from roledata where roleid="+roleid);
		while(rs2.next())
		{
			rolename=rs2.getString("rolename");
			System.out.println(rolename);
			System.out.println(auth);
		}
		if(rolename.equalsIgnoreCase(auth))
		{
		return rolename;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "invalid";
  }
  
}

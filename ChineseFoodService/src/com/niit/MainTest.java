package com.niit;

import java.sql.*;

public class MainTest {
public void doCon()
{
	ApplicationDAO dao=new ApplicationDAO();
	Connection con=dao.getConnection();
	if(con!=null)
	{
		System.out.println("done ");
	}
	else
	{
		System.out.println("not done");
	}
}
}
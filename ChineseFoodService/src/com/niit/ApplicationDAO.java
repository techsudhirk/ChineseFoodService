package com.niit;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {
	public Connection getConnection()
	{
		Connection con = null;
	
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return con;
	}
	public void closeConnection(Connection con)
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void create(Application ap,String imgName) throws IOException
    {
     Connection con=getConnection();
     try {
		PreparedStatement ps=con.prepareStatement("insert into item(name,price,availability,image) values(?,?,?,?)");
	   
		ps.setString(1,ap.getName());
		ps.setInt(2,ap.getPrice());
		ps.setInt(3, ap.getAvailability());
		ps.setString(4, imgName);
	
		ps.execute();
	} catch (SQLException e) {
		e.printStackTrace();
	}
    }
    public List<Application> selectAll()
    {
  	  List<Application> applications=new ArrayList<Application>();
  	  String sql="select * from item";
  	  Connection connection=getConnection();
  	  try
  	  {
  		  Statement statement=connection.createStatement();
  		  ResultSet results=statement.executeQuery(sql);
  		  while(results.next())
  		  {
  			//  int id=results.getInt("id");
  			  String name=results.getString("name");
  			  int price=results.getInt("price");
  			  int availability=results.getInt("availability");
  			  int id=results.getInt("id");
  			  String fileName=results.getString("image");
  			  String description=results.getString("description");
  			  Application application=new Application(name,price,availability,fileName,id);
  			  applications.add(application);
  		  }
  	  }
  	  catch(Exception ex)
  	  {
  		  ex.printStackTrace();
  	  }
  	  finally
  	  {
  		  closeConnection(connection);
  	  }
  	return applications;	  
    }
    
    public void delete(int id)
    {
    	Connection con=getConnection();
    	String sql="delete from item where id=?";
    	
        try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    public Application SelectOne(String id1)
    {
    Application appp=null;
    int id=Integer.parseInt(id1);
    String sql="select * from item where id=?";
    Connection con=getConnection();
    
    try {
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,id); 
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			String iname=rs.getString("name");
			int price=rs.getInt("price");
			int availability=rs.getInt("availability");
			appp=new Application(iname,price,availability,id);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		return appp;
    }
    public void update(String name,Application app)
    {
  	  String sql="update item set name=?,price=?,availability=? where id=?";
  	  Connection con=getConnection();
  	  try {
  		PreparedStatement ps=con.prepareStatement(sql);
  		ps.setString(1, app.getName());
  		ps.setInt(2, app.getPrice());
  		ps.setInt(3,app.getAvailability());
  		ps.setInt(4, app.getId());
  		ps.execute();
  	} catch (SQLException e) {
  		e.printStackTrace();
  	}
    }
public static void main(String args[])
{

	 
}
}

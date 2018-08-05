package com.niit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.OracleDriver;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name,address,phone,email,username,password,confirmpassword,auth;
		DatabaseOperation operation=new DatabaseOperation();
        try {
        	name=request.getParameter("firstname").toString()+" "+request.getParameter("lastname").toString();
        	auth=request.getParameter("type");
        	System.out.println(auth);
        	address=request.getParameter("address");
        	phone=request.getParameter("contactnumber");
        	email=request.getParameter("email");
        	username=request.getParameter("username");
        	password=request.getParameter("password");
        	confirmpassword=request.getParameter("confirmpassword");
        	if(password.equals(confirmpassword))
        	{
        	UserModel model=new UserModel();
        	model.setUsername(username);
        	model.setAddress(address);
        	model.setEmail(email);
        	model.setPassword(password);
        	model.setName(name);
        	model.setPhone(phone);
        	model.setAuth(auth);
			Connection connection=operation.getConnection();

			String result=operation.register(connection, model);
			PrintWriter writer=response.getWriter();
			writer.print("<h1>"+result+"</h1><br>");
			writer.print("<a href='index.html'>Click Here to Login</a>");
        	}
        	else
        	{
        		response.sendRedirect("index.html");
        	}
        	}
       
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

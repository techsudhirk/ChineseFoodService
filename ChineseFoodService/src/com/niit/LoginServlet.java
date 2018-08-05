package com.niit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username=request.getParameter("username").toString();
		String password=request.getParameter("password").toString();
		String auth=request.getParameter("type");
		UserModel model=new UserModel();
		model.setUsername(username);
		model.setPassword(password);
		model.setAuth(auth);
		DatabaseOperation operation=new DatabaseOperation();
	    
	    try {
			Connection connection=operation.getConnection();
			RequestDispatcher dispatcher;
			String result=operation.Login(model,connection);
			if(result.equals("Admin"))
			{
				dispatcher=request.getRequestDispatcher("Applications.jsp");
				dispatcher.forward(request, response);
			}
			else if(result.equals("User"))
			{
				dispatcher=request.getRequestDispatcher("index3.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				dispatcher=request.getRequestDispatcher("Invalid.html");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

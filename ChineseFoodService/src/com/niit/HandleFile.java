package com.niit;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
/**
 * Servlet implementation class HandleFile
 */
@WebServlet("/HandleFile")
public class HandleFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		// TODO Auto-generated method stub
		ApplicationDAO dao=new ApplicationDAO();
		String root=getServletContext().getRealPath("/images");
		MultipartRequest mr=new MultipartRequest(request,root);
		
		Enumeration files=mr.getFileNames();
		String name=(String) files.nextElement();
		String fileName=mr.getFilesystemName(name);
		
		HttpSession session=request.getSession();
		Application ap=(Application) session.getAttribute("values");
		String description =request.getParameter("des");
		System.out.println(description+"yes");
		
		dao.create(ap,fileName);
		out.println("product added with the image file");
		out.println("<a href='http://localhost:9005/ChineseFoodService/Applications.jsp'>click to go home</a>");
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

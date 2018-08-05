<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.niit.*"%>
    <%@ page import="com.oreilly.servlet.MultipartRequest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
<%
Application ap=new Application();
%>
<%
ApplicationDAO dao=new ApplicationDAO();
String name=request.getParameter("name");
 String price=request.getParameter("price");
 String availability=request.getParameter("availability");
 System.out.println(availability+"hello");
 String id=request.getParameter("id");
 String description=request.getParameter("description");
  ArrayList al=new ArrayList();
  al.add(id);
  al.add(availability);
  al.add(price);
String action=request.getParameter("action");
if("create".equals(action))
{
  //  int id1=Integer.parseInt(id);
	int avail=Integer.parseInt(availability);
	int iprice=Integer.parseInt(price);
	
	ap=new Application(name,iprice,avail,"",0);
	//dao.create(ap,"");
	session.setAttribute("values", ap);
    RequestDispatcher rd=request.getRequestDispatcher("uploading.jsp");
    rd.forward(request, response);
}
else if("delete".equals(action))
{
	//String iname=name;
	int id3=Integer.parseInt(al.get(0).toString());
	System.out.println(al.get(0));
	dao.delete(id3);
}
else if("select".equals(action))
{
	int price2=Integer.parseInt(price);
	int id1=Integer.parseInt(id);
	int availability1=Integer.parseInt(availability);
   ap=new Application(name,price2,availability1,id1);
   
   
}
else if("update".equals(action))
{
	int id3=Integer.parseInt(id);
	int availability1=Integer.parseInt(availability);
	int price1=Integer.parseInt(price);
	System.out.println("--"+id3+"--"+availability1);
	ap=new Application(id3,name,price1,availability1);
	
	dao.update(name,ap);
}
%>
<form enctype="multipart/form-data">
<table class="table">
<tr>
<td>id
<input type="text" name="id" class="form-control" value="<%=ap.getId()%>"/> 
</td>
<td>name
<input type="text" name="name" class="form-control" value="<%=ap.getName()%>"/> 
</td>
<td>price
<input type="text" name="price" class="form-control" value="<%=ap.getPrice()%>"/> 
</td>
<td>available items
<input type="text" name="availability" class="form-control" value="<%=ap.getAvailability()%>"/> 
</td>


<td>
<button name="action" value="create" class="btn btn-success" style="padding:20px">
&nbsp&nbspAdd Item &nbsp&nbsp&nbsp
</button>
</td>
<td>
<button name="action" value="update" class="btn btn-primary" style="padding:20px">
Update Item
</button>
</td>
</tr>

<%
List<Application> applications=dao.selectAll();
%>
<%for(Application app:applications){
%>
<tr>
<td>
<%=app.getId()%>
</td>
<td>
<%=app.getName()%>
</td>
<td>
<%=app.getPrice()%>
</td>
<td>
<%=app.getAvailability() %>
</td>
<td> <a class="btn btn-danger" href="Applications.jsp?action=delete&id=<%=app.getId()%>">Delete Item</a>  </td>
</td>
<td> <a href="Applications.jsp?action=select&name=<%=app.getName()%>&price=<%=app.getPrice()%>&availability=<%=app.getAvailability()%>&id=<%=app.getId()%>" class="btn btn-danger">Select Item</a>  </td>
<td>
<%
} 
%>
</tr>
</table>
</form>
</body>
</html>
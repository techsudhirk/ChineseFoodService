<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Your Order</title>
</head>
<body>
<%
String image=request.getParameter("image");

%>
 <form action="OrderSuccess.jsp">
  <h2>Enter your Delivery Address:</h2><input type="text" name="address"/>
  <input type="submit" value="Place Your Order"/>
  </form>

</body>
</html>
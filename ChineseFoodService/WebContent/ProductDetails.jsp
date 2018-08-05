<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>


    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/heroic-features.css" rel="stylesheet">
</head>
<body>
<%
String name=request.getParameter("name");
String price=request.getParameter("price");
String image=request.getParameter("image");
%>
<div class="jumbotron">
  <h1 class="display-4">Name: <%=name %></h1>
  <h1 class="display-4">Price: <%=price %></h1>
  
  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
  <hr class="my-4">
  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
  <p class="lead">
 <img src="images\<%=image%>" width="200" height="140" style="margin-bottom:5px"><br>
    <a class="btn btn-primary btn-lg" href="Order.jsp" role="button">Buy Now</a>  
  </p>
  
</div>

 
</body>
</html>
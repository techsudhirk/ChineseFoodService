<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.niit.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

 <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ChineseFoodStore</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/heroic-features.css" rel="stylesheet">

  </head>


<body>

<%
ApplicationDAO dao=new ApplicationDAO();
List<Application> applications=dao.selectAll();
%>
 <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">ChineseFoodStore</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
   
      <!-- Jumbotron Header -->
      <header class="jumbotron my-4">
        <h1 class="display-3">A Warm Welcome!</h1>
        <p class="lead">Welcome To ChineseFoodStore, Here you can get the best deals</p>
        <a href="#" class="btn btn-primary btn-lg">Latest Products</a>
      </header>

      <!-- Page Features -->
      <div class="row text-center">

<%for(Application app:applications){
%>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="images\<%=app.getImage()%>" width="300" height="250">
            <div class="card-body">
              <h4 class="card-title"><%=app.getName() %></h4>Rs.<%=app.getPrice() %>
              <p class="card-text"><%=app.getDescription() %></p>
            </div>
            <div class="card-footer">
          <form action="Order.jsp">
          
         
              <a href="Order.jsp?image=<%=app.getImage() %>&&price=<%=app.getPrice() %>&&name=<%=app.getName()%>" class="btn btn-primary" style="margin:3px;">Order Now</a>
             <a href="ProductDetails.jsp?image=<%=app.getImage() %>&&price=<%=app.getPrice() %>&&name=<%=app.getName()%>" class="btn btn-success">Product Details</a>
             

            </div>
          </div>
        </div>
      <% } %>
      
  
      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
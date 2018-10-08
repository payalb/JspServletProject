<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
<style>

.error {
color: red;
font-size: 0.8em;
}
.bgimg {
    background-image: url('./img/home.jpg');
    background-repeat: no-repeat;
 background-size:cover;
 color: white;
   
  /*   background-color: WhiteSmoke; */
}
</style>

</head>
<body  class='bgimg'>


<nav class="navbar navbar-expand-sm navbar-dark bg-primary" >
  <a class="navbar-brand" href="#">Flight Booking</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link" href="search.jsp" >Home</a>
      
      <c:if test="${sessionScope.username==null}">
  <a class="nav-item nav-link" href="login.jsp" > Login</a>
  <a class="nav-item nav-link" href="register.jsp" > Register</a>
  
  </c:if>
  <c:if test="${sessionScope.username!=null}">
 
  <c:if test="${\"admin\".equals(sessionScope.usertype)}">
   <a class="nav-item nav-link" href="listFlight" > List All Flight</a>
  </c:if>
  
    <a class="nav-item nav-link" href="bookHistory" > Booking History</a>
   <a class="nav-item nav-link" href="profile.jsp" > Edit Profile</a>
  <a class="nav-item nav-link" href="logout" > Logout</a>
  
  </c:if>
    </div>
  </div>
</nav>


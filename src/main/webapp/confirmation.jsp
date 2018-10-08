<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<main role="main" class="inner cover">
       
        <p class="lead">Booking successful!
        </p>
      </main>
	
	<table  class="table">

  <tbody>
  <tr><td>Booking id:</td><td>${sessionScope.bookId}</td></tr>
  <tr><td>First name:</td><td>${sessionScope.fname}</td></tr>
  <tr><td>Last name:</td><td>${sessionScope.lname}</td></tr>
  <tr><td>Flight number:</td><td>${sessionScope.f.getFlight_number()}</td></tr>
  <tr><td>Departure city:</td><td>${sessionScope.f.getDeparture_city()}</td></tr>
  <tr><td>Departure date:</td><td>${sessionScope.f.getDeparture_date()}</td></tr>
  <tr><td>Departure time:</td><td>${sessionScope.f.getDeparture_time()}</td></tr>
   <tr><td>Arrival city:</td><td>${sessionScope.f.getArrival_city()}</td></tr>
  <tr><td>Arrival date:</td><td>${sessionScope.f.getArrival_date()}</td></tr>
  <tr><td>Arrival time:</td><td>${sessionScope.f.getArrival_time()}</td></tr>
  <tr><td>Class:</td><td>${sessionScope.fclass}</td></tr>
  <tr><td>Number of seat:</td><td>${sessionScope.seat}</td></tr>
	</table>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

<table class="table" >
  <thead>
    <tr>
     <th scope="col">Booking id</th>
      <th scope="col">Flight no</th>
      <th scope="col">Arrival date</th>
       <th scope="col">Arrival time</th>
      
     
       <th scope="col">Departure time</th>
      <th scope="col">Departure date</th>
       <th scope="col">Departure city</th>
      <th scope="col">Arrival city</th>
     <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>

 
<c:forEach items="${blist}" var="li">
<tr >
      <td scope="row" id="fno">${li.getBooking_id()}</td>
    <td>${li.getFlight_number()}</td>
       <td>${li.getArrival_date()}</td>
      <td>${li.getArrival_time()}</td>
      <td>${li.getDeparture_date()}</td>
      <td>${li.getDeparture_time()}</td>
      <td>${li.getDeparture_city()}</td>
      <td>${li.getArrival_city()}</td> 
       <td><form action="deleteBooking" ><input type="hidden" id="val" name="bId" value="${li.getBooking_id()}"/>
       <input type="hidden" id="fno" name="fno" value="${li.getFlight_number()}"/>
       <button>Delete</button></form></td>
    </tr>
</c:forEach>
</tbody>
</table>
<c:if test="${blist.size()==0}">
 <h3>No booking available</h3>
  
  </c:if>
</div>

<!-- <script src="./JS/bookScript.js"></script> -->
</body>
</html>
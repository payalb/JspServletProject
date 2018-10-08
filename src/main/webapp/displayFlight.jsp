<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

<table class="table" id="parent-list">
  <thead class="thead-light">
    <tr>
      <th scope="col">Flight no</th>
      <th scope="col">Arrival time</th>
      <th scope="col">Arrival date</th>
      <th scope="col">Departure time</th>
      <th scope="col">Departure date</th>
      <th scope="col">Departure city</th>
      <th scope="col">Arrival city</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
 
<c:forEach items="${list}" var="li">
<tr >
      <td scope="row" id="fno">${li.flight_number}</td>
      <td>${li.arrival_time}</td>
      <td>${li.arrival_date}</td>
      <td>${li.departure_time}</td>
      <td>${li.departure_date}</td>
      <td>${li.departure_city}</td>
      <td>${li.arrival_city}</td>
      <td>
    <form action="bookFlight.jsp">
      <input type="hidden" id="val" name="val" value="${li.flight_number}"/><button class="btn btn-primary"id="book_flight">Book</button>
     </form> 
      </td>
    </tr>
</c:forEach>
</tbody>
</table>
<c:if test="${list.size()==0}">
  <h3>No flights available</h3>
  
  </c:if>
</div>

<!-- <script src="./JS/bookScript.js"></script> -->
</body>
</html>
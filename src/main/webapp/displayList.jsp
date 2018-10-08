<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<c:if test="${sessionScope.username !=null && \"admin\".equals(sessionScope.usertype)}">
<div>

<a href="addFlight.jsp" style="text-decoration: none;color:white;"><button type="button" class="btn btn-primary" style="margin:10px;">Add Flight</button></a>
</div>
<table class="table">
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
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>

<c:forEach items="${list}" var="li">
<tr>
      <th scope="row">${li.flight_number}</th>
      <td>${li.arrival_time}</td>
      <td>${li.arrival_date}</td>
      <td>${li.departure_time}</td>
      <th>${li.departure_date}</th>
      <td>${li.departure_city}</td>
      <td>${li.arrival_city}</td>
<td><form action="editFlightDetail" method="post"><input type="hidden" id="val" name="f" value="${li.flight_number}"/><c:set var="flist" value="${li}" scope="session" /><button class="btn btn-primary">Edit</button></form></td>
<td><form action="deleteFlight" method="post">
<input type="hidden" id="val" name="fno" value="${li.flight_number}"/> 
<button id="delete" class="btn btn-danger">Delete</button>
</form></td>
    </tr>
</c:forEach>
</tbody>
</table>
<c:if test="${list.size()==0}">
 <h3>No flights available</h3>
  
  </c:if>

</div>
 </c:if>
  <c:if test="${sessionScope.username==null }">
  <div>
<div>
 Please login to continue <a href="./login.jsp">login page</a>
  </div>
  </c:if>
 <%--  <%
session.setMaxInactiveInterval(2);
%> --%>

 <script type="text/javascript">
var Msg ='<%=session.getAttribute("alertMsg")%>';
    if (Msg != "null") {
 function alertName(){
 alert("Flight added");
 
 } 
 }
    $('#delete').on('click',function(){
    	alert('flight deleted');
    });
 </script>
 
 <script type="text/javascript"> window.onload = alertName; </script>
 <%-- ${sessionScope.removeAttribute("alertMsg")} --%>
</body>
</html>
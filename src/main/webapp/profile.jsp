<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

<c:if test="${sessionScope.username !=null}">
<form action="addProfile" method="post" >
  <div class="form-group">
    <label for="fname">First name</label>
    <input type="text" class="form-control" id="fname"  name="fname" placeholder="firstname" value="${sessionScope.p.getFirstName()}" >

  </div>
  
    <input type="hidden" class="form-control" id="pid"  name="pid" value="${sessionScope.p.getPassanger_id()}" >
    <input type="hidden" class="form-control" id="username"  name="username" value="${sessionScope.username}" >


<div class="form-group">
    <label for="lname">Last name</label>
    <input type="text" class="form-control" id="lname"  name="lname" placeholder="lastname" value="${sessionScope.p.getLastName()}" >

  </div>
  <div class="form-group">
    <label for="ssn">SSN</label>
    <input type="text" class="form-control" id="ssn"  name="ssn" value="${sessionScope.p.getSsn()}"  >

  </div>
   <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email"  name="email" value="${sessionScope.p.getEmail()}" >

  </div>
  <div class="form-group">
    <label for="age">Age</label>
    <input type="number" class="form-control" id="age"  name="age" value="${sessionScope.p.getAge()}"  >

  </div>
  <div class="form-group">
    <label for="street">Street Address</label>
    <input type="text" class="form-control" id="street"  name="street" value="${sessionScope.p.getStreet()}" >

  </div>
  <div class="form-group">
    <label for="apt">Apartment</label>
    <input type="number" class="form-control" id="apt"  name="apt" value="${sessionScope.p.getApartment_number()}"  >

  </div>
  <div class="form-group">
    <label for="city">City</label>
    <input type="text" class="form-control" id="city"  name="city" value="${sessionScope.p.getCity()}"  >

  </div>
  <div class="form-group">
    <label for="state">State</label>
    <input type="text" class="form-control" id="state"  name="state" value="${sessionScope.p.getState()}" >

  </div>
  <div class="form-group">
    <label for="zip">Zip code</label>
    <input type="number" class="form-control" id="zip"  name="zip" value="${sessionScope.p.getZip()}" >

  </div>
   <div class="form-group">
    <label for="thome">Telephone(Home)</label>
    <input type="text" class="form-control" id="thome"  name="thome" value="${sessionScope.p.getTel_home()}" >

  </div>
   <div class="form-group">
    <label for="toffice">Telephone</label>
    <input type="text" class="form-control" id="toffice"  name="toffice" value="${sessionScope.p.getTel_office()}" >

  </div>
  
    
   <button type="submit" class="btn btn-primary" style="margin:10px;">Update</button>
  

  </form>
   <a href="search.jsp"><button  class="btn btn-primary" style="margin:10px;">Cancel</button></a>
  </c:if>
  <c:if test="${sessionScope.username==null }">
  <div>
  <div>
 Please login to edit profile <a href="./login.jsp">login page</a>
  </div>
  </c:if>
  <script >
  $().ready(function(){
	  $('form').validate({
	  rules: {
	  
	  fname: {
	  	required: true,
	  	minlength: 2
	  },
	  lname: {
	  	required: true,
	  	minlength: 2
	  },
	  ssn:{
	  minlength:9,
	  maxlength:9
	  },
	  age:{
	  	min:18,
	  	max:100
	  	},
	  street: {
	  	required: true
	  },
	  apt: {
	  	required:true
	  },
	  city: {
	  	required:true
	  },
	  state: {
	  	required:true
	  },
		
	  },
	  messages: {
	  confirm_password: {
	  	equalTo: "please enter the same password"
	  }
	  }

	  });

	  });

  </script>
</div>
</body>
</html>
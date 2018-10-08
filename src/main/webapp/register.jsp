
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<div class="container">
<form action="registerUser" method="post" id="form" class="form-horizontal">
  <div class="form-group">
    <label for="uname">Username</label>
    <input type="text" class="form-control" id="uname"  name="uname" placeholder="Username">

  </div>
  
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="confirm_password">Confirm Password</label>
    <input type="password" class="form-control" id="confirm_password" name="confirm_password" placeholder="Confirm Password">
  </div>
 <div class="radio">
  <label><input type="radio" name="utype" value="customer" checked>customer</label>

  <label><input type="radio" name="utype" value="admin">admin</label>
</div>
<div class="form-group">
    <label for="fname">First name</label>
    <input type="text" class="form-control" id="fname"  name="fname" placeholder="firstname" required>

  </div>
  
    
    


<div class="form-group">
    <label for="lname">Last name</label>
    <input type="text" class="form-control" id="lname"  name="lname" placeholder="lastname" required>

  </div>
  <div class="form-group">
    <label for="ssn">SSN</label>
    <input type="text" class="form-control" id="ssn"  name="ssn" >

  </div>
   <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email"  name="email" >

  </div>
  <div class="form-group">
    <label for="age">Age</label>
    <input type="number" class="form-control" id="age"  name="age"  >

  </div>
  <div class="form-group">
    <label for="street">Street Address</label>
    <input type="text" class="form-control" id="street"  name="street" >

  </div>
  <div class="form-group">
    <label for="apt">Apartment</label>
    <input type="number" class="form-control" id="apt"  name="apt" >

  </div>
  <div class="form-group">
    <label for="city">City</label>
    <input type="text" class="form-control" id="city"  name="city" >

  </div>
  <div class="form-group">
    <label for="state">State</label>
    <input type="text" class="form-control" id="state"  name="state" >

  </div>
  <div class="form-group">
    <label for="zip">Zip code</label>
    <input type="number" class="form-control" id="zip"  name="zip" >

  </div>
   <div class="form-group">
    <label for="thome">Telephone(Home)</label>
    <input type="text" class="form-control" id="thome"  name="thome" >

  </div>
   <div class="form-group">
    <label for="toffice">Telephone</label>
    <input type="text" class="form-control" id="toffice"  name="toffice" >

  </div>
   
 <button type="submit" class="btn btn-primary">Register</button>
</form>
</div>
</div>
<script src="./JS/formvalidation.js">


</script>
</body>
</html>
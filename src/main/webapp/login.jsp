<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<c:if test="${ error!=null }">
	<div style="color:red">${error}</div>
</c:if>
<form action="validate" method="post" >
  <div class="form-group">
    <label for="uname">Username</label>
    <input type="text" class="form-control" id="uname" name="uname"  placeholder="Username">

  </div>
  
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
  </div>
 <div class="radio">
  <label><input type="radio" name="utype" value="customer" checked>customer</label>
</div>
<div class="radio">
  <label><input type="radio" name="utype" value="admin">admin</label>
</div>
  <button type="submit" class="btn btn-primary">Login</button>

</form>
</div>
<script>
$().ready(function(){
$('form').validate({
rules: {
uname: {
required: true,
minlength: 2
},
password: {
required: true,
minlength: 5
},
confirm_password: {
required: true,
minlength: 5,
equalTo: password
}
},
messages: {
confirm_password: {
	equalTo: "please enter the same password"
}
}

});
});

</script>
</body>
</html>
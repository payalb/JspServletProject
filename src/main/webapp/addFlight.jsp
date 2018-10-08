<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<form action="addFlightDetail" method="post" >
  <div class="form-group">
    <label for="fno">Flight number</label>
    <input type="number" class="form-control" id="fno" name="fno" required >

  </div>
  <div class="form-group">
    <label for="dtime">Departure time</label>
    <input type="text" class="form-control" id="dtime" name="dtime" placeholder="HH:MM:SS" required >

  </div>
  
  <div class="form-group">
    <label for="ddate">Departure date</label>
    <input type="date" class="form-control" id="ddate" name="ddate" required >

  </div>
  <div class="form-group">
    <label for="atime">Arrival time</label>
    <input type="text" class="form-control" id="atime" name="atime" placeholder="HH:MM:SS" required >

  </div>
  
  <div class="form-group">
    <label for="adate">Arrival date</label>
    <input type="date" class="form-control" id="adate" name="adate" required >

  </div>
   
  <div class="form-group">
    <label for="air_id">Airplane Id</label>
    <input type="number" class="form-control" id="air_id" name="air_id" required >

  </div>
  <div class="form-group">
    <label for="d_city">Departure city</label>
    <input type="text" class="form-control" id="d_city" name="d_city" required >

  </div>
  <div class="form-group">
    <label for="a_city">Arrival city</label>
    <input type="text" class="form-control" id="a_city" name="a_city" required >

  </div>
  <div class="form-group">
    <label for="eseat">Economy Seat</label>
    <input type="number" class="form-control" id="eseat" name="eseat" min=0 required >

  </div>
  <div class="form-group">
    <label for="fseat">First class Seat</label>
    <input type="number" class="form-control" id="fseat" name="fseat" min=0 required >

  </div>
  <div class="form-group">
    <label for="bseat">Business class Seat</label>
    <input type="number" class="form-control" id="bseat" name="bseat"  min=0 required >

  </div>

  <button type="submit" class="btn btn-primary" style="margin:10px">Add</button>
  
</form>
<a href="listFlight"> <button  class="btn btn-primary" style="margin:10px">Cancel</button></a>
</div>
</body>
</html>
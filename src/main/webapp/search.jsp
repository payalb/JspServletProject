<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<div>
				<form action="fetchAvailFlight" >
					
					
					<div class="form-group">
						<label for="from">From</label>
						<input type="text" class="form-control" id="from" name="from" />
					</div>
					<div class="form-group">
						<label for="to">To</label>
						<input type="text" class="form-control" id="to" name="to" />
					</div>
					<div class="form-group">
						<label for="ondate">On</label>
						<input type="date" class="form-control" id="ondate" required name="ondate" min="2018-08-19">
					</div>
					
					<button type="submit" class="btn btn-primary">Submit</button>
					<!-- <input type="submit" value="search" /> -->
				</form>
				
			</div>
			
		</div>
	


<script src="./JS/auto.js"></script>
</body>
</html>

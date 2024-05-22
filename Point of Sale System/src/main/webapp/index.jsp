<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@page import="java.sql.*, java.util.*, java.io.*, edu.uafs.model.*, edu.uafs.control.*" %>

<%
	

	OrderDetailsDAO orderDet = new OrderDetailsDAO();
	CustomerDAO cust = new CustomerDAO();
	OrderDAO order = new OrderDAO();
	

	if(request.getParameter("submit")!= null)
	{
		
		String bakeryItemID = request.getParameter("bakeryItem");
		String qty = request.getParameter("qty");
		String fname = request.getParameter("First name");
		String lname = request.getParameter("Last name");
		
		Customers customer = new Customers(1,fname,lname);
		cust.insert(customer);
		
		Orders ord = new Orders(1, "today", "now", 1);
		order.insert(ord);
		
		OrderDetails det = new OrderDetails(1, 1, Integer.parseInt(bakeryItemID), Integer.parseInt(qty));
		orderDet.insert(det);
	}



%>    

	
    
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Point of Sales System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
  </head>
  <body>
  	<div class="container">
  		<div class="row">
  		
  			<form action="index.jsp" method="POST">
  			
  			
  				<div style="margin-bottom: 10px;">
  					<h2>Orders</h2>
  				</div>
  			
  				<div style="margin-bottom: 20px;">
  					<label> Select Bakery Item(s)</label>
  					<select class="form-select" name="bakeryItem" multiple aria-label="select">
  					<option value="1">Cake</option>
  					<option value="2">Bread</option>
  					<option value="3">Doughnut</option>
  					<option value="4">Cupcake</option>
					</select>
				</div>
  				
  				<div style="margin-bottom: 20px;">
  					<label>Order Qty</label>
  					<input type="text" id="qty" name="qty" class="form-control" required>
  				</div>
  				
  				<div style="margin-bottom: 20px;">
  					<label>Total</label>
  					<input type="text" id="total" name="total" class="form-control" >
  				</div>
  				
  				<div class="input-group">
  					<span class="input-group-text">First and Last Name</span>
  					<input type="text" id="First name" name="First name" aria-label="First name" class="form-control" required>
  					<input type="text" id="Last name" name="Last name" aria-label="Last name" class="form-control" required>
				</div>
  				
  				<div style="margin-top: 20px;">
  					<button type="submit" id="submit" name="submit" class="btn btn-success">Add</button>
  				</div>
  			
  			
  			</form>
  		
  		</div>
  	</div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
  </body>
</html>
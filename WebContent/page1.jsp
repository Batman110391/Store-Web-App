<%@page import="it.cefi.model.Ordini"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.cefi.model.DatabaseAreaRiservata"%>
<%@page import="it.cefi.model.Prodotti"%>
<%@include file="WEB-INF/checkuser.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<jsp:include page="WEB-INF/head.jsp"></jsp:include>
		<title>Store Funko Pop</title>
	</head>
	<body>
	
		<div id="alert">
		</div>
		<div class="container">
			<h1>Store Funko Pop</h1>
			<h3 class="d-inline"> Hi, </h3> <h2 class="d-inline" id="name"><%=session.getAttribute("username")%></h2> 
			<div class="btn-group mb-5 mt-3 d-block" role="group" aria-label="Basic outlined example">
				<a class="btn btn-outline-primary" href="logout"> Logout </a>
			</div>
			<p class="d-flex justify-content-between">
			 <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseCart" role="button" aria-expanded="false" aria-controls="collapseCart">
			 Cart <span class="badge bg-secondary">0</span>
			 </a>
			 
			 <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseOrder" role="button" aria-expanded="false" aria-controls="collapseOrder">
			 Your Order
			 </a>
			 
			 </p>
			 <div class="collapse" id="collapseCart">
			  <div id="carts" class="card card-body">
					<div class='d-flex justify-content-between'> 
					<button id="buy" onclick="buy()" style="border-radius: 50%">BUY</button> <p>Tot: <span id="price_tot"> 0 </span> Euro </p> 
					</div>
					<hr>
			  </div>
			</div>
			
			  
			
			 <div class="collapse" id="collapseOrder">
			  <div id="carts" class="text-center card card-body">
			  <%
			  	ArrayList <Ordini> ordini = new ArrayList<Ordini>();
				DatabaseAreaRiservata.getOrder(ordini, session.getAttribute("username") ); %>
				
				<p> <strong>summary of your orders:</strong>  </p> 
				<p>tot ordini: <%= ordini.size() %></p>
				<hr>
				<table>
					<tr>
						<th> Id_order </th>
						<th> Date </th>
						<th> Name </th>
						<th> Quantity </th>
					</tr>
				
				<% for (Ordini o : ordini) {%> 
					<tr>
						<td><%= o.getId_prodotto() %></td>
						<td><%= o.getData() %></td>
						<td><%= o.getProdotto() %></td>
						<td><%= o.getQuantita() %></td>
					</tr>
				<%}%>
				</table>
			  </div>
			</div>
		
			<div class="card-group">
			
			  <%ArrayList <Prodotti> product = new ArrayList<Prodotti>();
				DatabaseAreaRiservata.insertProduct(product);
				 for (Prodotti p : product) {%> 
				  <div class="card">
				  <img src="<%= p.getImg() %>" class="card-img-top" alt="<%= p.getImg() %>">
				    <div class="card-body">
				      <h5 class="card-title"><%= p.getNome_prodotto() %></h5>
				      <p class="card-text">
				      Price: Euro <%= p.getPrezzo_unitario() %> </p>
				    </div>
				    <div class="card-footer">
				    <% if(p.getQuantita() > 0){%>
				    	<button onclick="addToCart('<%=p.getNome_prodotto()%>','<%= p.getQuantita()%>', '<%= p.getPrezzo_unitario() %>')" type="button" class="btn btn-primary"> Add to Cart </button>
				    <%}else{%>
				      	<button type="button" class="btn btn-warning">Out of stock</button>
				      <%}%>
				    </div>
				  </div>    
	          <% } %>
	        </div>
		</div>
		
		<script src="./jscript/negozio.js"></script>
	</body>
</html>
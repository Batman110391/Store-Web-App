<%@page import="it.cefi.model.Ordini"%>
<%@page import="it.cefi.model.Prodotti"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.cefi.model.DatabaseAreaRiservata"%>
<%@ include file="WEB-INF/checkuser.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<jsp:include page="WEB-INF/head.jsp"></jsp:include>
		<title>Administration Store Funko Pop</title>
	</head>
	<body>
	   <div id="alert"> </div>
		<div class="container text-center mt-5">
			<h1>Administration</h1>
			
			<div class="accordion" id="accordionExample">
			  <div class="accordion-item">
			    <h2 class="accordion-header" id="headingOne">
			      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
					Add Product
			      </button>
			    </h2>
			    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
			      <div class="accordion-body">
			      <form action="addproduct" method="post">
			        <table class="d-flex justify-content-center">
			        	<tr> 
			        		<th> image product </th>
			        		<th> quantity </th>
			        		<th> name_product </th>
			        		<th> price_product </th>
			        		<th> </th>
			        	</tr>
			        	<tr> 
			        		<td> <input class="text-center" name="img" type="text" placeholder="insert src uri" required="required"> </td>
			        		<td> <input class="text-center" name="quantita" type="number" min="1" required="required" value="1"> </td>
			        		<td> <input class="text-center" name="name_product" type="text" placeholder="insert name product" required="required"> </td>
			        		<td> <input class="text-center" name="price_product" type="number" step="0.01" min="0" required="required"> </td>
			        		<td> <input class="text-center" type="submit" value="Add"> </td>
			        	</tr>
			        </table>
			       </form>
			      </div>
			    </div>
			  </div>
			  <div class="accordion-item">
			    <h2 class="accordion-header" id="headingTwo">
			      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
			        Update Product
			      </button>
			    </h2>
			    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
			      <div class="accordion-body text-center">
			      	 <table class="d-flex justify-content-center">
			        	<tr> 
			        		<th> name_product </th>
			        		<th> img </th>
			        		<th> quantity </th>
			        		<th> price </th>
			        	</tr>
			        	<tr>
			        	 <td> 
			        	  <select id="names_products" onchange="changeProduct()">
			        	   <option> </option>
			        	  <% ArrayList <Prodotti> product = new ArrayList<Prodotti>();
						   DatabaseAreaRiservata.insertProduct(product);
						   ArrayList <String> utenti = new ArrayList<String>();
						   DatabaseAreaRiservata.getUtenti(utenti);
						   ArrayList <Ordini> orders = new ArrayList<Ordini>();
						   DatabaseAreaRiservata.getOrder(orders, "");
						 
						   for (Prodotti p : product) {%> 
						      	 <option value="<%=p.getNome_prodotto()%>"><%=p.getNome_prodotto()%></option>     
						   <%}%>
						   </select>
						  </td>
						  <td>
						  	 <input id="img_choice" type="text" class="text-center" required="required">
						     <select id="img_update" class="d-none" >
						     <%for (Prodotti p: product) {%>
						      <option value="<%=p.getNome_prodotto()%>" disabled="disabled"> <%=p.getImg()%></option>     
						     <%}%>
						     </select>
						  </td>
						  <td> 
						  	 <input id="quantity_choice" type="text" class="text-center" required="required">
						     <select id="quantity_update" class="d-none" > 
						     <%for (Prodotti p: product) {%>
						      <option value="<%=p.getNome_prodotto()%>" disabled="disabled"><%=p.getQuantita()%></option>     
						     <%}%>
						     </select>
						  </td>
						  <td>
						  	 <input id="price_choice" type="text" class="text-center" required="required">
						     <select id="price_update" class="d-none">
						     <%for (Prodotti p: product) {%>
						      <option value="<%=p.getNome_prodotto()%>" disabled="disabled"><%=p.getPrezzo_unitario() %></option>     
						     <%}%>
						     </select>
						  </td>
						  </tr>
			        </table>
			        <button onclick="updateProduct()"> Update</button>
			        <button onclick="deleteProduct()"> Delete</button>
			      </div>
			    </div>
			  </div>
			  <div class="accordion-item">
			    <h2 class="accordion-header" id="headingThree">
			      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
			        User List
			      </button>
			    </h2>
			    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
			      <div class="accordion-body">
			        <%for (String u : utenti) {%> 
					    <p> <%= u%> </p>     
					<%}%>
			      </div>
			    </div>
			  </div>
			   <div class="accordion-item">
			    <h2 class="accordion-header" id="headingFour">
			      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
			        Order control
			      </button>
			    </h2>
			    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
			      <div class="accordion-body">
			        <p> <strong>summary of your orders:</strong>  </p> 
					<p>tot ordini: <%= orders.size() %></p>
					<hr>
					<table class="mx-auto">
						<tr>
							<th> Id_order </th>
							<th> Date </th>
							<th> Name </th>
							<th> Quantity </th>
							<th> User </th>
						</tr>
					
					<% for (Ordini o : orders) {%> 
						<tr>
							<td><%= o.getId_prodotto() %></td>
							<td><%= o.getData() %></td>
							<td><%= o.getProdotto() %></td>
							<td><%= o.getQuantita() %></td>
							<td><%= o.getUtente() %></td>
						</tr>
					<%}%>
					</table>
			      </div>
			    </div>
			  </div>
			</div>
			
			<a href="index.jsp">Logout</a>
		</div>
		
		<script src="./jscript/administration.js"></script>
	</body>
</html>
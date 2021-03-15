<%@page import="it.cefi.model.DatabaseAreaRiservata"%>
<%@ include file="WEB-INF/checkuser.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<jsp:include page="WEB-INF/head.jsp"></jsp:include>
		<title>Store Funko Pop</title>
	</head>
	<body>
		<div class="container text-center mt-5">
			<h1>Store Funko Pop</h1>
			<h3 class="mt-5"> Thank you,  <%= session.getAttribute("username") %> </h3>
			
			<h5> your order was successful</h5>
			
			<div class="btn-group" role="group" aria-label="Basic outlined example">
				<a class="btn btn-outline-primary" href="page1.jsp"> back to the shop </a>
			</div>
		</div>
	</body>
</html>
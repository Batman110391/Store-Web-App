<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<jsp:include page="WEB-INF/head.jsp"></jsp:include>
		<title>Error</title>
	</head>
	<body>
		<div class="alert alert-danger text-center">
		  	<h3 class="text-center"><%= exception.getMessage() %></h3>
		  	<hr>
		  <a class="btn btn-danger" href="index.jsp">back to the home page</a>	
		</div>
	</body>
</html>
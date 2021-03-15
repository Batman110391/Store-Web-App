<!DOCTYPE html>
	<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<jsp:include page="WEB-INF/head.jsp"></jsp:include>
		<title>Form</title>
	</head>
	<body class="text-center">
	
	<div class="container mt-5">
		 <button id="btn_login" type="button" class="btn btn-primary">Login</button>
  		 <button id="btn_sign" type="button" class="btn btn-primary">Register</button>
  		 
		<form class="login mt-3" action="login" method="post">
			<label for="username"> Username </label>
			<input class="form-control text-center" type="text" name="username" id="username" required="required" autocomplete="off">
			<label for="password"> Password </label>
			<input class="form-control mb-3 text-center" type="password" name="password" id="password" required="required" autocomplete="off">
			<input class="btn btn-primary" type="submit" value="Go">
		</form>
		
		<form class="sign-in mt-3 d-none" action="signup" method="post">
			<label for="email"> Email </label>
			<input class="form-control text-center" type="email" name="email" id="email" required="required" autocomplete="off">
			<label for="username"> Username </label>
			<input class="form-control text-center" type="text" name="username" id="username" required="required" autocomplete="off">
			<label for="password"> Password </label>
			<input class="form-control mb-3 text-center" type="password" name="password" id="password" required="required" autocomplete="off">
			<input class="btn btn-primary" type="submit" value="Go">
		</form>
		
	</div>
		
		
	<script src="./jscript/home.js"></script>
	</body>
</html>
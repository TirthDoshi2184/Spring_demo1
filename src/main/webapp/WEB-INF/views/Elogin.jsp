<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

<div class='container-fluid'>

	<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
	<h2>Ecom Login</h2>
	<form action="elogin" method="post">	
	
	Email : <input type="text" name="email" class="form-control"/> 
	Password : <input type="password" name="password" class="form-control"/>
	<br>
	<input type="submit" value="Login" class="btn btn-success"/>
	
	</form>
	</div>
	</div>
</div>
<br>
${error}
</body>
</html>
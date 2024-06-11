<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>SignUp</h2>

	<form action="saveUser" method="post">
		FirstName : <input type="text" name="firstName">
		<br><br>
		Email : <input type="email" name="email">
		<br><br>
		Password :<input type="password" name="password">
		<br><br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>
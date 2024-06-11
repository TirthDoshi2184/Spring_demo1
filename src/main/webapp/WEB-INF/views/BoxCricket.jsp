<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Box Cricket Registration</h2>

	<form action="savereg" method="post">
		Name  : <input type="text" name="studentName" value="${studentNameValue }"/>
					<span>${studentNameError}</span>
		<br><Br>
		
		Playing Type :     
						Batsman <input type="radio" name="playerType" value="Batsman"/>
						Bowller <input type="radio" name="playerType" value="Bowller"/>
						AllRounder 	 <input type="radio" name="playerType" value="AllRounder"/>
						${playerTypeError}
						<br><br> 
						
		Food Preference : 
		
					<select name="foodPreference">
						<option value="-1">---Select Your Food Preference---</option>
						<option value="Regular" >Regular</option>
						<option value="Jain" >Jain</option>
					</select>	
					${foodPreferenceError}
					<br><br>
		Drink : 
				RB	<input type="checkbox" name="drink" value="rb"/> 
				MD<input type="checkbox" name="drink" value="md"/>
				TH<input type="checkbox" name="drink" value="th"/>
				LJ<input type="checkbox" name="drink" value="lj"/>
				Co <input type="checkbox" name="drink" value="co"/>
				
				<br><Br>
				<input type="submit" value="Register"/>

	</form>

</body>
</html>
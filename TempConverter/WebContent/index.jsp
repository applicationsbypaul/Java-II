<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Temperature converter</title>
</head>
<body>
	<h1>Temperature converter</h1>
	<form action="getTempServlet" method="post">
		<p>Please select Which to convert to:</p>
		<input type="radio" id="celsius" name="degree" value="Celsius">
		<label for="celsius">Fahrenheit to Celsius</label><br> 
		<input type="radio" id="fahrenheit" name="degree" value="Fahrenheit"required> 
		<label for="fahrenheit">Celsius to Fahrenheit</label> <br> 
			Enter the temperature to convert: 
		<input type="text" name="userDegree" size="3" required> 
		<input type="submit" value="Calculate Degree" />
	</form>
</body>
</html>
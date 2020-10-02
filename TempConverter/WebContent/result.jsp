<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body>
	<p>The conversion temperature is: ${userDegree.getDegree()}</p>
	<form action="convertBackServlet" method="post">
		<input type="button" value="Convert Back">
	</form>
	<a href="index.jsp">Select another degree</a>
</body>
</html>
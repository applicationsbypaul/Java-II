<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new car list</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
		List Name: <input type="text" name="listName"><br />
		Owner Name: <input type="text" name="ownerName"><br />
		Available Cars:<br /> 
		<select name="allCarsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allCars}" var="currentcar">
				<option value="${currentcar.id}">${currentcar.make}|
					${currentcar.model}|${currentcar.year}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create List and Add Items">
	</form>
	<a href="index.html">Go add new items instead.</a>
</body>
</html>
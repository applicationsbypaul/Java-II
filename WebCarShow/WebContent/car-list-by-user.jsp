<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Lists</title>
</head>
<body>
	<form method="post" action="listnavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentcar">
				<tr>
					<td><input type="radio" name="id" value="${currentcar.id}"></td>
					<td><h2>${currentcar.listName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Owner: ${currentcar.owner.ownerName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentcar.listOfCars}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.make}, ${listVal.model},
							${listVal.year}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList"> <input
			type="submit" value="delete" name="doThisToList"> <input
			type="submit" value="add" name="doThisToList">
	</form>
	<a href="addCarsForListServlet">Create a car new List</a>
	<a href="index.html">Insert a new car</a>
</body>
</html>
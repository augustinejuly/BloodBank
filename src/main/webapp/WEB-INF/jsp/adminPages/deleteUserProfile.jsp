<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleting User Profiles</title>
</head>
<body>

	<h2>Deleting User Profiles</h2>
	<p align="right"><a href="<c:url value='/blood'/>">Back to Home Page</a></p>
	<p align="right"><a href="<c:url value='/admin/delete'/>">Back to Admin Delete</a></p>
	<table border="1">
		<thead>
			<tr>
				<th>User Name</th>
				<th>User Type</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userProfileList}" var="up">
				<tr>
					<td><c:out value="${up.username}"/></td>
					<td><c:out value="${up.userType}"/></td>
					<td><a href="<c:url value='/admin/delete/currentUserProfile?username=${up.username}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
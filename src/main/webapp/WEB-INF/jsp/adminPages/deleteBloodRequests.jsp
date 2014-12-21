<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleting Blood Requests</title>
</head>
<body>

	<h2>Deleting Blood Requests</h2>
	<p align="right"><a href="<c:url value='/blood'/>">Back to Home Page</a></p>
	<p align="right"><a href="<c:url value='/admin/delete'/>">Back to Admin Delete</a></p>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Blood Group</th>
				<th>Blood Request Type</th>
				<th>Request Posted By</th>
				<th>User Type</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bloodRequests}" var="br">
				<tr>
					<td><c:out value="${br.bloodRequestId}"/></td>
					<td><c:out value="${br.bloodGroup.getBloodGroupName()}"/></td>
					<td><c:out value="${br.bloodRequestType}"/></td>
					<td><c:out value="${br.requestPostedBy.username}"/></td>
					<td><c:out value="${br.requestPostedBy.userType}"/></td>
					<td><a href="<c:url value='/admin/delete/currentBloodRequest?id=${br.bloodRequestId}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
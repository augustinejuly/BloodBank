<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blood Bank</title>
</head>
<body>
	<p>
		<a href="<c:url value='/admin/delete/userProfile'/>">Delete User
			Profiles</a>
	</p>
	<p>
		<a href="<c:url value='/admin/delete/bloodRequest'/>">Delete Blood
			Requests</a>
	</p>
	<p>
		<a href="<c:url value='/admin/delete/userCredential'/>">Delete
			UserCredentials</a>
	</p>
</body>
</html>
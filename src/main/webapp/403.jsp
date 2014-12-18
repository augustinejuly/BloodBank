<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Access Restricted</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache">
        <meta http-equiv="Expires" content="Mon, 22 Jul 1970 11:12:01 GMT">
	</head>
	<body>
		<H1>Sorry! You are not authorized!</H1>
		<p><a href="<c:url value='/login'/>">Back to Login</a></p>
		<p><a href="<c:url value='/blood'/>">Back to Home Page</a></p>
	</body>
</html>

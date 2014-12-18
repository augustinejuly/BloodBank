<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="fragments/head.jsp" />
<body>
	<jsp:include page="fragments/bodyHeader.jsp" />

	<div id="errorPageContainer" align="center">
		<h3>Looks like a technical error.</h3>
		<p>
			<a href="<c:url value='/blood'/>"><font color="#FFFFFF">Back to Home Page</font></a>
		</p>
	</div>

	<jsp:include page="fragments/footer.jsp" />
</body>
</html>
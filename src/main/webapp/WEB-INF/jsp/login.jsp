<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="fragments/head.jsp" />

<body>
	<jsp:include page="fragments/bodyHeader.jsp" />
	<H1 align="center">Login here ...</H1>
	<div id="formHolder" align="center">
		<form id="form" action="<c:url value='/login.do'/>" method="POST"
			class="basic-grey">

			<c:if test="${not empty param.err}">
				<div>
					<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				</div>
			</c:if>
			<c:if test="${not empty param.out}">
				<div>You've logged out successfully.</div>
			</c:if>
			<c:if test="${not empty param.time}">
				<!-- <div>You've been logged out due to inactivity.</div> -->
			</c:if>
			<table>
				<tr>
					<td><span><b>User Name</b> *</span></td>
					<td><input type="text" name="username" value="" /></td>
				</tr>
				<tr>
					<td><span><b>Password</b> *</span></td>
					<td><input type="password" name="password" value="" /></td>
				</tr>
				<tr></tr>
				<tr>
					<td>&nbsp;</td>
					<td><input value="Login" name="submit" type="submit"
						class="button" /></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>
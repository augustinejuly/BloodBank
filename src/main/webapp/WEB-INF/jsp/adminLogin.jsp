<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<jsp:include page="fragments/head.jsp" />

<body>
	<jsp:include page="fragments/bodyHeader.jsp" />
	<H1 align="center">Admin Form ...</H1>
	<div id="formHolder" align="center">
		<form:form modelAttribute="adminLogin" method="POST" cssClass="basic-grey">

			<table>
				<tr>
					<td><span><b>User Name</b> *</span></td>
					<td><form:input path="username" /></td>
					<td><form:errors path="username" cssClass="error" /></td>
				</tr>
				<tr>
					<td><span><b>Password</b> *</span></td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td><span><b>Choose Role</b> *</span></td>
					<td>
						<form:select path="role">
							<form:option value="USER">USER</form:option>
							<form:option value="ADMIN">ADMIN</form:option>
						</form:select>
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td><input type="reset" value="Reset" class="button" /></td>
					<td><input value="Submit" name="submit" type="submit" class="button" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>
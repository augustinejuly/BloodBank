<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="fragments/head.jsp" />
<body>
	<jsp:include page="fragments/bodyHeader.jsp" />
		<h2 align="center"><font color="#000000">Create new blood request ...</font></h2>
		<div id="formHolder" align="center">
			<form:form modelAttribute="bloodRequest" method="POST"
				cssClass="basic-grey">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table>
					<tr>
						<td><form:label path="bloodGroup">Blood Group *</form:label></td>
						<td><form:select path="bloodGroup">
								<form:option value="">Select Blood Group</form:option>
								<c:forEach items="${bg}" var="entry">
									<form:option value="${entry}">${entry.getBloodGroupName()}</form:option>
								</c:forEach>
							</form:select></td>
						<td><form:errors path="bloodGroup" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="bloodRequestType">Blood Request Type *</form:label></td>
						<td><form:select path="bloodRequestType">
								<form:option value="">Select Blood Request type</form:option>
								<form:options />
							</form:select></td>
						<td><form:errors path="bloodRequestType" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="numberOfUnits">Number of Units *</form:label>
						</td>
						<td><form:input path="numberOfUnits" /></td>
						<td><form:errors path="numberOfUnits" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="description">Description *</form:label>
						</td>
						<td><form:textarea path="description" /></td>
						<td><form:errors path="description" cssClass="error" /></td>
					</tr>
					<tr>
						<td><input type="reset" value="Reset" class="button" /></td>
						<td><input type="submit" value="Submit" class="button" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>
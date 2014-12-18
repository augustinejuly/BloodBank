<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="fragments/head.jsp" />

<body>
	<jsp:include page="fragments/bodyHeader.jsp" />
	<div id="formHolder" align="center">
		<form:form modelAttribute="memberForm" action="registerMember"
			method="POST" cssClass="basic-grey">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td><form:label path="memberProfile.memberFirstName">First Name *</form:label>
					</td>
					<td><form:input path="memberProfile.memberFirstName" /></td>
					<td><form:errors path="memberProfile.memberFirstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="memberProfile.memberLastName">Last Name *</form:label>
					</td>
					<td><form:input path="memberProfile.memberLastName" /></td>
					<td><form:errors path="memberProfile.memberLastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="username">User name *</form:label></td>
					<td><form:input path="username" /></td>
					<td><form:errors path="username" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password *</form:label></td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="confirmPassword">Confirm Password *</form:label>
					</td>
					<td><form:password path="confirmPassword" /></td>
					<td><form:errors path="confirmPassword" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="memberProfile.age">Age *</form:label></td>
					<td><form:input path="memberProfile.age" /></td>
					<td><form:errors path="memberProfile.age" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="memberProfile.gender">Gender *</form:label></td>
					<td><form:select path="memberProfile.gender">
							<form:option value="">Select Gender Type</form:option>
							<form:options />
						</form:select></td>
					<td><form:errors path="memberProfile.gender" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="memberProfile.bloodGroup">Blood Group *</form:label></td>
					<td>
						<form:select path="memberProfile.bloodGroup">
							<form:option value="">Select Blood Group</form:option>
							<c:forEach items="${bg}" var="entry">
								  <form:option value="${entry}">${entry.getBloodGroupName()}</form:option>
							</c:forEach>
						</form:select>
					</td>
					<td><form:errors path="memberProfile.bloodGroup" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="memberProfile.contactDetail.address">Address</form:label>
					</td>
					<td><form:input path="memberProfile.contactDetail.address" /></td>
					<td><form:errors path="memberProfile.contactDetail.address" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="memberProfile.contactDetail.city">City</form:label></td>
					<td><form:input path="memberProfile.contactDetail.city" /></td>
					<td><form:errors path="memberProfile.contactDetail.city" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="memberProfile.contactDetail.state">State</form:label>
					</td>
					<td><form:input path="memberProfile.contactDetail.state" /></td>
					<td><form:errors path="memberProfile.contactDetail.state" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="memberProfile.contactDetail.postalCode">Postal Code</form:label>
					</td>
					<td><form:input path="memberProfile.contactDetail.postalCode" /></td>
					<td><form:errors path="memberProfile.contactDetail.postalCode"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="memberProfile.contactDetail.phones">Phone Numbers *</form:label>
					</td>
					<td><form:input path="memberProfile.contactDetail.phones" /></td>
					<td><form:errors path="memberProfile.contactDetail.phones" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="memberProfile.contactDetail.email">Email *</form:label>
					</td>
					<td><form:input path="memberProfile.contactDetail.email" /></td>
					<td><form:errors path="memberProfile.contactDetail.email" cssClass="error" /></td>
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
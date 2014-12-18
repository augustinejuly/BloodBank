<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="fragments/head.jsp" />

<body>

	<jsp:include page="fragments/bodyHeader.jsp" />
	<div id="formHolder" align="center">
		<form:form modelAttribute="providerForm" action="registerProvider"
			method="POST" cssClass="basic-grey">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td><form:label path="providerProfile.providerName">Provider Name *</form:label>
					</td>
					<td><form:input path="providerProfile.providerName" /></td>
					<td><form:errors path="providerProfile.providerName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="username">Username *</form:label></td>
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
					<td><form:label path="providerProfile.contactDetail.address">Address</form:label>
					</td>
					<td><form:input path="providerProfile.contactDetail.address" /></td>
					<td><form:errors path="providerProfile.contactDetail.address" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="providerProfile.contactDetail.city">City</form:label></td>
					<td><form:input path="providerProfile.contactDetail.city" /></td>
					<td><form:errors path="providerProfile.contactDetail.city" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="providerProfile.contactDetail.state">State</form:label>
					</td>
					<td><form:input path="providerProfile.contactDetail.state" /></td>
					<td><form:errors path="providerProfile.contactDetail.state" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="providerProfile.contactDetail.postalCode">Postal Code</form:label>
					</td>
					<td><form:input path="providerProfile.contactDetail.postalCode" /></td>
					<td><form:errors path="providerProfile.contactDetail.postalCode"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="providerProfile.contactDetail.phones">Phone Numbers *</form:label>
					</td>
					<td><form:input path="providerProfile.contactDetail.phones" /></td>
					<td><form:errors path="providerProfile.contactDetail.phones" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="providerProfile.contactDetail.email">Email *</form:label>
					</td>
					<td><form:input path="providerProfile.contactDetail.email" /></td>
					<td><form:errors path="providerProfile.contactDetail.email" cssClass="error" /></td>
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
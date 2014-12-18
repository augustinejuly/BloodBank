<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="fragments/head.jsp" />

<body>
	<script type="text/javascript">
		$(function() {
			$("#tabs").tabs();
			$('#providerTable').dataTable();
			$('#memberTable').dataTable();
		});
	</script>
	<jsp:include page="fragments/bodyHeader.jsp" />

	<div id="tabHolder" align="center">
		<div id="tabs" style="width: 88%;">
			<ul style="background-color: #852606">
				<li><a href="#tabs-1">Members</a></li>
				<li><a href="#tabs-2">Providers</a></li>
			</ul>
			<div id="tabs-1">
				<table id="memberTable" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Gender</th>
							<th>Age</th>
							<th>Blood Group</th>
							<th>Phone</th>
							<th>Mail</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memberList}" var="member">
							<tr>
								<td><c:out value="${member.memberFirstName}"></c:out></td>
								<td><c:out value="${member.memberLastName}"></c:out></td>
								<td><c:out value="${member.gender}"></c:out></td>
								<td><c:out value="${member.age}"></c:out></td>
								<td><c:out value="${member.bloodGroup.getBloodGroupName()}"></c:out></td>
								<td><c:out value="${member.contactDetail.phones}"></c:out></td>
								<td><c:out value="${member.contactDetail.email}"></c:out></td>
								<td><c:out value="${member.contactDetail.fullAddress}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="tabs-2">
				<table id="providerTable" class="display" cellspacing="0"
					width="100%">
					<thead>
						<tr>
							<th>Hospital / Blood Bank</th>
							<th>Phone</th>
							<th>Mail</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${providerList}" var="provider">
							<tr>
								<td><c:out value="${provider.providerName}"></c:out></td>
								<td><c:out value="${provider.contactDetail.phones}"></c:out></td>
								<td><c:out value="${provider.contactDetail.email}"></c:out></td>
								<td><c:out value="${provider.contactDetail.fullAddress}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>
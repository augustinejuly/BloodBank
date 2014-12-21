<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
							<th>Blood Group</th>
							<th>Member Name</th>
							<th>Gender</th>
							<th>Age</th>
							<th>Posted Date</th>
							<th>Phone</th>
							<th>Mail</th>
							<th>Address</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memberList}" var="memberRequest">
							<tr>
								<td><c:out value="${memberRequest.bloodGroup.getBloodGroupName()}"/></td>
								<td><c:out value="${memberRequest.requestPostedBy.memberFirstName} , ${memberRequest.requestPostedBy.memberLastName}"/></td>
								<td><c:out value="${memberRequest.requestPostedBy.gender}"/></td>
								<td><c:out value="${memberRequest.requestPostedBy.age}"/></td>
								<%-- <td><c:out value="${memberRequest.postedTime}"/></td> --%>
								<td> <fmt:formatDate value="${memberRequest.postedTime}" type="both"/></td>
								<td><c:out value="${memberRequest.requestPostedBy.contactDetail.phones}"/></td>
								<td><c:out value="${memberRequest.requestPostedBy.contactDetail.email}"/></td>
								<td><c:out value="${memberRequest.requestPostedBy.contactDetail.fullAddress}"/></td>
								<td><c:out value="${memberRequest.description}"/></td>
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
							<th>Blood Group</th>
							<th>Hospital / Blood Bank</th>
							<th>Phone</th>
							<th>Mail</th>
							<th>Address</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${providerList}" var="providerRequest">
							<tr>
								<td><c:out value="${providerRequest.bloodGroup.getBloodGroupName()}"/></td>
								<td><c:out value="${providerRequest.requestPostedBy.providerName}"/></td>
								<td><c:out value="${providerRequest.requestPostedBy.contactDetail.phones}"/></td>
								<td><c:out value="${providerRequest.requestPostedBy.contactDetail.email}"/></td>
								<td><c:out value="${providerRequest.requestPostedBy.contactDetail.fullAddress}"/></td>
								<td><c:out value="${providerRequest.description}"/></td>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.bloodbank.mongo.model.BloodGroup"%>
<%@ page import="org.bloodbank.mongo.model.BloodRequestType" %>
<html>
<jsp:include page="fragments/head.jsp" />

<body>

	<jsp:include page="fragments/bodyHeader.jsp" />

	<div class="container">

		<div class="row">

			<!--             <div class="col-lg-12">
                <h2 class="page-header">Blood Bank</h2>
            </div>
 -->

			<c:forEach items="<%=BloodGroup.values()%>" var="bgs">
				<div class="col-lg-3 col-md-4 col-xs-6 thumb curvedbox">
					<h4>
						<font color="#FFFFFF"><c:out value="${bgs.bloodGroupName}">${bgs.bloodGroupName}</c:out></font>
					</h4>
					<a href="<c:url value='/bloodRequestDetail/demand?bgs=${bgs}'/>" />Demand (
						<%
							String key = ((BloodGroup)pageContext.getAttribute("bgs")).name() + BloodRequestType.DEMAND.name();
							out.write(   (String.valueOf(request.getAttribute(key))).toCharArray()  );
						%>)
					</a> <br> 
					<a href="<c:url value='/bloodRequestDetail/donate?bgs=${bgs}'/>">Available (
						<%
							key = ((BloodGroup)pageContext.getAttribute("bgs")).name() + BloodRequestType.DONATE.name();
							out.write(   (String.valueOf(request.getAttribute(key))).toCharArray()  );
						%>)
					</a>
				</div>
			</c:forEach>
		</div>

		<hr>
	</div>


	<jsp:include page="fragments/footer.jsp" />
</body>
</html>
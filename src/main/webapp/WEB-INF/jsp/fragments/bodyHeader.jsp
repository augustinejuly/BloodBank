<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/resources/images/header-logo.jpg" var="banner" />
<spring:url value="/resources/images/header-logo1.jpg" var="banner1" />
<spring:url value="/resources/images/header-logo2.jpg" var="banner2" />
<spring:url value="/resources/images/header-logo3.jpg" var="banner3" />

<%-- Menu begins here --%>

<div id="menuId">

<ul id="menu">
     
    <li><a href="<c:url value='/blood'/>" class="drop">Home</a>
	
		<div class="dropdown_2columns">
		  
			<div class="col_2">
                <h2>Blood Bank</h2>
            </div>
			
			 <div class="col_2">
                <p>The application will help people who are in need of blood of any particular group to meet people who can donate and vice versa.</p>             
                <p>It will also facilitate hospitals and blood bank organizations to distribute the excessive bloods to those who are in need of it.</p>           
            </div>
            
             <div class="col_2">
                <h2>Note</h2>
            </div>
             
            <div class="col_2">
                <p>This application is a POC in IBM Bluemix from Cognizant Technology Solutions.</p>
            </div>
			
		</div>
	
	</li><!-- End Home Item -->
 
    <li><a href="<c:url value='/blood/showRegisteredUsers'/>" class="drop">Registered Users</a></li>
	
	<li><a href="<c:url value='/blood/bloodRequest'/>" class="drop">Blood Request</a></li>
	
	<%
			boolean isAuthenticated = false; 
			HttpSession httpSession = request.getSession(false);
			if(httpSession != null && httpSession.getAttribute("username") != null) {
				isAuthenticated = true;
			}
		%>
		<c:choose>
  			<c:when test="<%= isAuthenticated %>">
		 		<li class="menu_right"><a href="<spring:url value="/logout?out=1" htmlEscape="true" />" class="drop">Logut</a></li>
 			</c:when>
  			<c:otherwise>
  				<li class="menu_right"><a href="<spring:url value="/login" htmlEscape="true" />" class="drop">Login</a></li>
  			</c:otherwise>
		</c:choose>
 
    <li class="menu_right"><a href="#" class="drop">Register Here</a>
     
         <div class="dropdown_3columns align_right">
             
            <div class="col_3">
                <h2>You may register as Member or Provider</h2>
            </div>
             
			<div id="divbox" align="center">
				<div class="col_1">
		 
					<ul class="greybox">
						<li><a href="<c:url value='/registerMember'/>">Member Registration</a></li>
					</ul>   
		 
				</div>
				 
				<div class="col_1">
		 
					<ul class="greybox">
						<li><a href="<c:url value='/registerProvider'/>">Provider Registration</a></li>
					</ul>   
		 
				</div>
             </div>
            <div class="col_3">
                <h2>What is a member or provider here ?</h2>
            </div>
             
            <div class="col_3">
                <p>
					<h3><b>Member</b></h3>
					If you are an individual seeking or willing to donate any particular group of blood. 
				</p>
                <p>
					<h3><b>Provider</b></h3>
					If you represent yourself as a hospital or any private blood bank organization seeking or willing to donate 
					any particular group of blood.
				</p>
            </div>
         
        </div>
         
    </li>
 
 
</ul>


	<%-- <ul id="menu-bar">
		<li class="active"><a href="<c:url value='/blood'/>">Home</a></li>
		<li><a href="#">Register Here</a>
			<ul>
				<li><a href="<c:url value='/registerMember'/>">Member
						Registration</a></li>
				<li><a href="<c:url value='/registerProvider'/>">Provider
						Registration</a></li>
			</ul></li>
		<li><a href="<c:url value='/blood/bloodRequest'/>">Blood
				Request</a></li>
		<li><a href="<c:url value='/blood/showRegisteredUsers'/>">Registered
				Users</a></li>
		<li><a href="#">About</a></li>
		
		<%
			boolean isAuthenticated = false; 
			HttpSession httpSession = request.getSession(false);
			if(httpSession != null && httpSession.getAttribute("username") != null) {
				isAuthenticated = true;
			}
		%>
		<c:choose>
  			<c:when test="<%= isAuthenticated %>">
		 		<li><a href="<spring:url value="/logout?out=1" htmlEscape="true" />">Logout</a></li>
 			</c:when>
  			<c:otherwise>
  				<li><a href="<spring:url value="/login" htmlEscape="true" />">Login</a></li>
  			</c:otherwise>
		</c:choose>
	</ul> --%>
</div>

<%-- Menu ends here --%>

<div id="bloodPics" class="imgContainer" style="width:95%" align="center">
	<table>
		<tr>
			<td><img id="logo1" src="${banner}" alt="pic1" class="blood" /></td>
			<td><img id="logo2" src="${banner1}" alt="pic2" class="blood" /></td>
			<td><img id="logo3" src="${banner2}" alt="pic3" class="blood" /></td>
			<td><img id="logo4" src="${banner3}" alt="pic4" class="blood" /></td>
		</tr>
	</table>
</div>


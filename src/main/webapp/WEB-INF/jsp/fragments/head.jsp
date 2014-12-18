<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Blood Bank</title>

<spring:url value="/resources/css/bloodbank.css" var="bloodBankCss" />
<link href="${bloodBankCss}" rel="stylesheet" />

<spring:url value="/resources/css/menu.css" var="menuCss" />
<link href="${menuCss}" rel="stylesheet" />

<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrapMinCss" />
<link href="${bootstrapMinCss}" rel="stylesheet" />

<spring:url value="/resources/css/form.css" var="formCss" />
<link href="${formCss}" rel="stylesheet" />

<spring:url value="/resources/js/jquery-1.11.1.min.js" var="jQuery" />
<script src="${jQuery}"></script>

<spring:url value="/resources/css/jquery-ui.css" var="jQueryCss" />
<link href="${jQueryCss}" rel="stylesheet" />

<spring:url value="/resources/js/jquery-ui.js" var="jQueryUi" />
<script src="${jQueryUi}"></script>

<spring:url value="/resources/css/jquery.dataTables.css" var="jQueryDataTableCss" />
<link href="${jQueryDataTableCss}" rel="stylesheet" />

<spring:url value="/resources/js/jquery.dataTables.min.js" var="jQueryDataTable" />
<script src="${jQueryDataTable}"></script>

<style type="text/css">
body {
	/* background: #AA3939; */
	background: #F5EFE5;
}
</style>



</head>

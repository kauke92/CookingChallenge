<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<title>My Secured Page</title>
</head>
<body>
	<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
		<td><a href="<c:url value="/login.htm"/>">Login</a></td>
	</sec:authorize>
	<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
		<td><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></td>
	</sec:authorize>
	<h3>${message}</h3>
	<a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>

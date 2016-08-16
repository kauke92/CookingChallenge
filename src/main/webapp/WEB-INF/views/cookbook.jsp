<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<%@ include file="/WEB-INF/views/include.jsp"%>

<title>CookBook</title>
</head>
<body>
	<h1>Welcome to the CookBook!</h1>

	<P>Select one of the options</P>
	<br>
	<a href="cookbook/recipe/addrecipe"><button>Create a new
			recipe</button></a>
	<br>
	<a href="cookbook/recipe/searchrecipe"><button>Search a
			recipe</button></a>
	<br>
	<a href="/elec5619"><button>Return home</button></a>
	<br>

	<h2>List of all recipes.</h2>
	<c:set var="count" value="1" scope="page" />
	<c:forEach items="${recipes}" var="prof">

		<label> ${count}. </label>
		<b>id:</b> "<c:out value="${prof.id}" />"
    	<b>title:</b> "<c:out value="${prof.title}" />"
    	<a href="cookbook/${prof.id}/viewrecipe"><button>View</button></a>
		<c:set var="count" value="${count + 1}" scope="page" />
		<br>

	</c:forEach>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<title>Search</title>
</head>
<body>
	<h1>Search</h1>

	<form method="POST">
		<fieldset>
			<table>
				<tr>
					<th><label for="recipe_search">Search:</label></th>
					<td><input type="text" name="search" value="${search}" /></td>
				</tr>
				<tr><input type="submit" name="action" value="Search" />
				</tr>
			</table>
		</fieldset>
	</form>
	<a href="/elec5619/cookbook"><button>Back</button></a>


	<h2>Search Results</h2>
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

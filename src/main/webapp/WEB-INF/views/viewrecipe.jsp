<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<title>Recipe</title>
</head>
<body>

	<h3>${recipe.title}</h3>
	<table>
		<tr>
			<th><label for="recipe_author">Author:</label></th>
			<td><c:out value="${recipe.author}" /></td>
		</tr>
		<tr>
			<th><label for="recipe_datecreated">Date Created:</label></th>
			<td><c:out value="${recipe.datecreated}" /></td>
		</tr>
		<tr>
			<th><label for="recipe_rating">Rating:</label></th>
			<td><c:out value="${recipe.rating}" /></td>
		</tr>
		<tr>
			<th><label for="recipe_description">Description:</label></th>
			<td><c:out value="${recipe.description}" /></td>
		</tr>
		<tr>
			<th><label for="recipe_ingredientlist">Ingredients:</label></th>
			<td><c:out value="${recipe.ingredientList}" /></td>
		</tr>
		<tr>
			<th><label for="recipe_instructions">Instructions:</label></th>
			<td><c:out value="${recipe.instructions}" /></td>
		</tr>
	</table>



	<a href="editrecipe"><button>Edit Recipe</button></a>
	<br>
	<a href="delete"><button>Delete Recipe</button></a>
	<br>
	<a href="/elec5619/cookbook"><button>Back</button></a>
	<br>

</body>
</html>
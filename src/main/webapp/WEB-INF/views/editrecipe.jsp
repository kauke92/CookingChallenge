<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit: ${recipe.title}</title>
</head>
<body>
	<h1>Edit: ${recipe.title}</h1>
	<h2>The fields marked with * are required</h2>
	<sf:form method="POST" modelAttribute="recipe">
		<fieldset>
			<table>
				<tr>
					<th><label for="recipe_title">*Title</label></th>
					<td><sf:input path="title" /></td>
					<td><sf:errors path="title" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="recipe_description">*Description</label></th>
					<td><sf:input path="description" /></td>
					<td><sf:errors path="description" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="recipe_ingredientlist">*Ingredients</label></th>
					<td><sf:input path="IngredientList" /></td>
					<td><sf:errors path="ingredientList"
							cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="instructions">*Instructions</label></th>
					<td><sf:input path="instructions" /></td>
					<td><sf:errors path="instructions" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><input type="submit" name="action" value="Cancel" /></th>
					<!-- This hidden field is required for Hibernate to recognize this recipe -->
					<td><sf:hidden path="id" />
					<td><sf:hidden path="author" />
					<td><sf:hidden path="rating" />
					<td><sf:hidden path="datecreated" />
					<td><input type="submit" name="action" value="Done" />
					<td>
				</tr>
			</table>

		</fieldset>
	</sf:form>

</body>
</html>
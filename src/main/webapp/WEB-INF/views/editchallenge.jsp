<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit an old challenge on this page</title>
	</head>
	<body>
		<h1>You can edit the challenge shown below</h1>
		<sf:form method="POST" modelAttribute="challenge">
			<fieldset>
				<table>
					<tr>
						<th><label for="challenge_titlec">Title:</label></th>
						<td><sf:input path="titlec"/></td>
					</tr>
					<tr>
						<th><label for="challenge_descriptionc">Description:</label></th>
						<td><sf:input path="descriptionc"/></td>
					</tr>
					<tr>
						<th><label for="challenge_rulesc">Rules:</label></th>
						<td><sf:input path="rulesc"/></td>
					</tr>
					<tr>
						<th><label for="challenge_ingredients">Ingredient:</label></th>
						<td><sf:textarea path="ingredients"/></td>
					</tr>
					<tr>
						<th><a href="/elec5619/challenge"><button>Cancel</button></a></th>
						<!-- This hidden field is required for Hibernate to recognize this Product -->
						<td><sf:hidden path="id"/>
						<td><input type="submit" value="Done"/></td>
					</tr>
				</table>			
			</fieldset>
		</sf:form>
		<br>
		<form><input type="button" value="Go Back" onClick="history.go(-1);return true;"></form>		
		<br>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit a review on this page</title>
</head>
<body>
	<h1>You can make review to the challenge here</h1>
	<sf:form method="POST" modelAttribute="review">
		<fieldset>
			<table>
				<tr>
					<th><label for="review_title">Title:</label></th>
					<td><sf:input path="title" /></td>
				</tr>
				<tr>
					<th><label for="review_description">Description:</label></th>
					<td><sf:input path="description" /></td>
				</tr>
				<tr>
					<th><label for="review_author">Author:</label></th>
					<td><sf:input path="author" /></td>
				</tr>

				<tr>
					<th><a href="/elec5619/challenge"><button>Cancel
							</button></a></th>

					<td><input type="submit" value="Done" /></td>
				</tr>

			</table>
		</fieldset>
	</sf:form>
	<br>
	<a href="/elec5619/challenge"><button>Back To Challenges
			Page</button></a>
	<br>
</body>
</html>



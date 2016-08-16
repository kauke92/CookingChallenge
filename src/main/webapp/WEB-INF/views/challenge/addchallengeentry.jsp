<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit your entry to this challenge!</title>
</head>
<body>
	<h1>Enter the details of your Challenge entry here</h1>
	<h2>The fields marked with * are required</h2>
	<sf:form method="POST" modelAttribute="challengeentry">
		<fieldset>
			<table>
				<tr>
					<th><label for="challengeentry_title">*Title of dish</label></th>
					<td><sf:input path="title" /></td>
					<td><sf:errors path="title" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="challengeentry_description">*Description of dish including how to make it</label></th>
					<td><sf:textarea path="description" /></td>
					<td><sf:errors path="description" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="challengeentry_pictures">*Pictures URL of your dish</label></th>
					<td><sf:input path="pictures" /></td>
					<td><sf:errors path="pictures" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="challengeentry_videourl">*Video URL of you creating your dish</label></th>
					<td><sf:input path="videourl" /></td>
					<td><sf:errors path="videourl" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="challengeentry_tag">*Tags of your dish?</label></th>
					<td><sf:textarea type="textarea" path="tag" /></td>
					<td><sf:errors path="tag" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="challengeentry_ingredientlist">*What ingredients did you use to make your dish?</label></th>
					<td><sf:textarea type="textarea" path="ingredientlist" /></td>
					<td><sf:errors path="ingredientlist" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>	
				<tr>
					<th><input type="submit" name="action" value="Cancel" /></th>
					<!-- This hidden field is required for Hibernate to recognize this challengeentry -->
					<td><sf:hidden path="id" />
					<td><input type="submit" name="action" value="Done" />
					<td>
				</tr>
			</table>

		</fieldset>
	</sf:form>

</body>
</html>
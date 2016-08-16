<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a user on this page</title>
</head>
<body>
	<h1>Enter your details to create a new account</h1>
	<h2>The fields marked with * are required</h2>
	<sf:form method="POST" modelAttribute="user">
		<fieldset>
			<table>
				<tr>
					<th><label for="user_firstname">*First Name</label></th>
					<td><sf:input path="firstname" /></td>
					<td><sf:errors path="firstname" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="user_lastname">*Last Name</label></th>
					<td><sf:input path="lastname" /></td>
					<td><sf:errors path="lastname" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="user_username">*Username</label></th>
					<td><sf:input path="username" /></td>
					<td><sf:errors path="username" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="user_password">*Password</label></th>
					<td><sf:input type="password" path="password" /></td>
					<td><sf:errors path="password" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="user_confirmpassword">*Confirm Password</label></th>
					<td><sf:input type="password" path="confirmpassword" /></td>
					<td><sf:errors path="confirmpassword" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="user_emailaddress">*Email Address</label></th>
					<td><sf:input path="emailaddress" /></td>
					<td><sf:errors path="emailaddress" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><label for="user_description">Description:</label></th>
					<td><sf:textarea path="description" /></td>
					<td><sf:errors path="description" cssStyle="color: #ff0000;"></sf:errors>
				</tr>
				<tr>
					<th><label for="user_location">Location</label></th>
					<td><sf:input path="location" /></td>
					<td><sf:errors path="location" cssStyle="color: #ff0000;"></sf:errors></td>
				</tr>
				<tr>
					<th><input type="submit" name="action" value="Cancel" /></th>
					<!-- This hidden field is required for Hibernate to recognize this user -->
					<td><sf:hidden path="id" />
					<td><input type="submit" name="action" value="Done" />
					<td>
				</tr>
			</table>

		</fieldset>
	</sf:form>

</body>
</html>
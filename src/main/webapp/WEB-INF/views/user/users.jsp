<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title><fmt:message key="searchuserstitle" /></title>

</head>
<body>
	<h1>
		<fmt:message key="searchuserstitle" />
	</h1>

	<h2>Navigate Users</h2>

	<form method="POST">
		<fieldset>
			<table>
				<tr>
					<td><th><label for="first_checkbox">Username:</label></th>
					<td><input type="checkbox" name="cbox" value="username" ${checkedlist.get(0)}></td>
				</tr>
				<tr>
					<td><th><label for="second_checkbox">First Name:</label></th>
					<td><input type="checkbox" name="cbox" value="firstname" ${checkedlist.get(1)}></td>
				</tr>
				<tr>
					<td><th><label for="third_checkbox">Last Name:</label></th>
					<td><input type="checkbox" name="cbox" value="lastname" ${checkedlist.get(2)}></td>
				</tr>
				<tr>
					<td><th><label for="fourth_checkbox">Location:</label></th>
					<td><input type="checkbox" name="cbox" value="location" ${checkedlist.get(3)}></td>
				</tr>
				<tr>
					<th><label for="user_search">Search:</label></th>
					<td><input type="text" name="search" value="${search}" /></td>	
				</tr>
				<input type="submit" name="action" value="Search" />
			</table>
		</fieldset>
	</form>
	<a href="/elec5619/"><button>Back</button></a>
	
	<c:forEach items="${users}" var="user">
		<fieldset>
			<table>
				
				<tr>
					<th><label for="user_username">Username</label></th>
					<td><c:out value="${user.username}" /></td>
				</tr>
				<tr>
					<th><label for="user_firstname">First Name</label></th>
					<td><c:out value="${user.firstname}" /></td>
				</tr>
				<tr>
					<th><label for="user_lastname">Last Name</label></th>
					<td><c:out value="${user.lastname}" /></td>
				</tr>
				<tr>
					<th><label for="user_description">Description:</label></th>
					<td><c:out value="${user.description}" /></td>
				</tr>
				<tr>
					<th><label for="user_emailaddress">Email Address</label></th>
					<td><c:out value="${user.emailaddress}" /></td>
				</tr>
				<tr>
					<th><label for="user_location">Location</label></th>
					<td><c:out value="${user.location}" /></td>
				</tr>
				<tr>
					<th><label for="user_datecreated">Date Created</label></th>
					<td><c:out value="${user.datecreated}" /></td>
				</tr>

			</table>
		</fieldset>
		<br>
	</c:forEach>

	<br>

	<br>
	<a href="/elec5619"><button>Home</button></a>
	<br>

</body>
</html>
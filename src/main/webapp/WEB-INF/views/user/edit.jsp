<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>

</head>

<body>

	<h1>Edit Profile:</h1>
	<h4>The fields marked with * are required</h4>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.nav-tabs li:eq(0) a').tab('show'); // Select first tab
		});
	</script>
	<ul class="nav nav-tabs">

		<li class="${activeTab.get(0)}"><a href="#1" data-toggle="tab"><c:out
					value="Account Settings" /></a></li>
		<li class="${activeTab.get(1)}"><a href="#2" data-toggle="tab"><c:out value="Settings" /></a></li>
	</ul>

	<div class="tab-content">
		<div class="${activePanel.get(0)}" id="1">
			<h1>
				<c:out value="Account Settings" />
			</h1>
			<p>
			<table class="table table-bordered table-hover table-striped">
				<sf:form method="POST" modelAttribute="user">
					<thead>
						<tr>
							<th>Title</th>
							<th>Link</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th><label for="user_firstname">*First Name</label></th>
							<td><sf:input path="firstname" />
							<br><sf:errors path="firstname" cssStyle="color: #ff0000;"></sf:errors></td>
						</tr>
						<tr>
							<th><label for="user_lastname">*Last Name</label></th>
							<td><sf:input path="lastname" />
							<br><sf:errors path="lastname" cssStyle="color: #ff0000;"></sf:errors></td>
						</tr>
						<tr>
							<th><label for="user_emailaddress">*Email Address</label></th>
							<td><sf:input path="emailaddress" />
							<br><sf:errors path="emailaddress"
									cssStyle="color: #ff0000;"></sf:errors></td>
						</tr>
						<tr>
							<th><label for="user_description">Description:</label></th>
							<td><sf:textarea path="description" />
							<br><sf:errors path="description" cssStyle="color: #ff0000;"></sf:errors>
						</tr>
						<tr>
							<th><label for="user_location">Location</label></th>
							<td><sf:input path="location" />
							<br><sf:errors path="location" cssStyle="color: #ff0000;"></sf:errors></td>
						</tr>
						<tr>
							<th><input type="submit" name="action" value="Cancel" /></th>
							<!-- This hidden field is required for Hibernate to recognize this user -->
							<sf:hidden path="id" />
							<td><button name="action" value="account" type="submit">Submit</button>
						</tr>
					</tbody>
				</sf:form>
			</table>

		</div>
		<div class="${activePanel.get(1)}" id="2">
			<h1>
				<c:out value="Change Password" />
			</h1>
			<p>
			<table class="table table-bordered table-hover table-striped">
				<sf:form method="POST" modelAttribute="user">
					<thead>
						<tr>
							<th>Title</th>
							<th>Link</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th><label for="user_password">*Password</label></th>
							<td><sf:input type="password" path="password" /> <br>
								<sf:errors path="password" cssStyle="color: #ff0000;"></sf:errors></td>
						</tr>
						<tr>
							<th><label for="user_confirmpassword">*Confirm
									Password</label></th>
							<td><sf:input type="password" path="confirmpassword" /> <br>
								<sf:errors path="confirmpassword" cssStyle="color: #ff0000;"></sf:errors></td>
						</tr>
						<tr>
							<th><input type="submit" name="action" value="Cancel" /></th>
							<!-- This hidden field is required for Hibernate to recognize this user -->
							<sf:hidden path="id" />
							<td><button name="action" value="password" type="submit">Submit</button>
							
						</tr>
					</tbody>
				</sf:form>
			</table>

		</div>

	</div>



	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>

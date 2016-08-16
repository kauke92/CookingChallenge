<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="searchsubmissions" /></title>
</head>
<body>
	<h1>
		<fmt:message key="searchsubmissions" />
	</h1>

	<h3>Your Submissions</h3>
	<c:forEach items="${submissions}" var="submission">
		<fieldset>
			<table>

				<tr>
					<th><label for="submission_title">Title of dish:</label></th>
					<td><c:out value="${submission.title}" /></td>
				</tr>
				<tr>
					<th><label for="submission_author">Author of dish:</label></th>
					<td><c:out value="${submission.author}" /></td>
				</tr>
				<tr>
					<th><label for="submission_description">Description of Dish</label></th>
					<td><c:out value="${submission.description}" /></td>
				</tr>
				<tr>
					<th><label for="submission_tag">Tags</label></th>
					<td><c:out value="${submission.tag}" /></td>
				</tr>
				<tr>
					<th><label for="submission_pictures">Pictures of dish</label></th>
					<td><c:out value="${submission.pictures}" /></td>
				</tr>
				<tr>
					<th><label for="submission_videourl">Video of dish</label></th>
					<td><c:out value="${submission.videourl}" /></td>
				</tr>
				<tr>
					<th><label for="submission_ingredientlist">List of Ingredients</label></th>
					<td><c:out value="${submission.ingredientlist}" /></td>
				</tr>
				<tr>
					<th><label for="submission_reviewlist">Review List</label></th>
					<td><c:out value="${submission.reviewlist}" /></td>
				
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
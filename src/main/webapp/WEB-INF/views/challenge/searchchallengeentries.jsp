<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="searchchallengeentries" /></title>
</head>
<body>
	<h1>
		<fmt:message key="searchchallengeentries" />
	</h1>

	<h3>ChallengeEntries</h3>
	<c:forEach items="${challengeentries}" var="challengeentry">
		<fieldset>
			<table>

				<tr>
					<th><label for="challengeentry_title">Title of dish:</label></th>
					<td><c:out value="${challengeentry.title}" /></td>
				</tr>
				<tr>
					<th><label for="challengeentry_author">Author of dish:</label></th>
					<td><c:out value="${challengeentry.user.username}" /></td>
				</tr>
				<tr>
					<th><label for="challengeentry_description">Description of Dish</label></th>
					<td><c:out value="${challengeentry.description}" /></td>
				</tr>
				<tr>
					<th><label for="challengeentry_tag">Tags</label></th>
					<td><c:out value="${challengeentry.tag}" /></td>
				</tr>
				<tr>
					<th><label for="challengeentry_pictures">Pictures of dish</label></th>
					<td><c:out value="${challengeentry.pictures}" /></td>
				</tr>
				<tr>
					<th><label for="challengeentry_videourl">Video of dish</label></th>
					<td><c:out value="${challengeentry.videourl}" /></td>
				</tr>
				<tr>
					<th><label for="challengeentry_ingredientlist">List of Ingredients</label></th>
					<td><c:out value="${challengeentry.ingredientlist}" /></td>
				</tr>
				<tr>
					<th><label for="challengeentry_reviewlist">Review List</label></th>
					<td><c:out value="${challengeentry.reviewlist}" /></td>
				
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
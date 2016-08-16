<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
	</head>
	<body>
		<h1>
			<fmt:message key="viewchallenge.heading" />
		</h1>
		
		
		<c:forEach items="${model.challenges}" var="challs">
				<h2>Challenge <i>ID: </i> <c:out value="${challs.id}" /> </h2>
				<br>
				<i>Title: </i> <c:out value="${challs.titlec}" />
				<br>
				<i>Description:</i> <c:out value="${challs.descriptionc}" />
				<br>
				<i>Rules: </i><c:out value="${challs.rulesc}" />
				<br>
				<i>Date Created: </i><c:out value="${challs.datecreatedc}" />
				<br>
				<i>Date Finishing:</i> <c:out value="${challs.datefinishedc}" />
				<br>
				<i>Ingredients:</i> <br>
				<ol>
				<c:forEach items="${challs.ingredients}" var="ingredient">
				<li><c:out value="${ingredient}" /></li>
				</c:forEach>
				</ol>
			<a href="submit/addreview/${challs.id}">Submit To Challenge</a>
			
			<br>
			<br>
			<br>
			<i>Reviews:</i> <br>
				 <ol>
				<c:forEach items="${model.reviews}" var="review">
				<li>
					Title: <c:out value="${review.title}" />
					<br>
					Author: <c:out value="${review.author}" />
					<br>
					Description: <c:out value="${review.description}" />
					<br>
					Date Created: <c:out value="${review.datecreated}" />				
					<br>
				
				
				</li>
				</c:forEach>
				</ol>
		</c:forEach> 
	
		<br>
		<a href="<c:url value="challenge"/>">Back to Challenges Page</a>
		<br>
	</body>
</html>

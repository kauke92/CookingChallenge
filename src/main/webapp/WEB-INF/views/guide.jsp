<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>View a guide</h2>
	Category: <a href="<c:url value="/guidelines/category/${guide.guideCategory}" />" >${categoryTitle}</a>
	<br /> Title : ${guide.guideTitle}
	<br /> Description: ${guide.guideDescription}
	<br /> Author : <a href="<c:url value="/user/${author.id}/profile"/>">${author.username } </a>
	<br />
	<a href="<c:url value="/guide/edit/${guide.id}"/>">Edit</a>
	<a href="<c:url value="/guide/delete/${guide.id}"/>">Delete</a>
	<a href="<c:url value="/guidelines"/>">GuideLines</a>
</body>
</html>
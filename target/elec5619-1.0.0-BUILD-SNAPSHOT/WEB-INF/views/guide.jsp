<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>View a guide</h2>
	Category: <a href="<c:url value="/guidelines/category/${guide.guideCategory}" />" >${categoryTitle}</a>
	<br /> Title : ${guide.guideTitle}
	<br /> Description: ${guide.guideDescription}
	<br />

	<a href="<c:url value="/guidelines.htm"/>">GuideLines</a>
</body>
</html>
<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title><fmt:message key="title"/></title></head>
<body>
  <h1><fmt:message key="guidelines.heading"/></h1>
  <p><fmt:message key="guidelines.greeting"/> </p>
  <h3>Category <c:out value="${guideCategory.guideCategoryName}"></c:out></h3>
  <c:forEach items="${guides}" var="guide">
  	
    Title <a href="<c:url value="/guide/${guide.id }" />"> <c:out value="${guide.guideDescription}"/>  </a>
    <br> Description <c:out value="${guide.guideTitle}"/><br><br>
    
    
  </c:forEach>
   <br>
  <a href="<c:url value="/guide/add"/>">
   <button>Add your own</button>
  </a>
  
  <br><a href="<c:url value="/guidelines"/>">GuideLines</a>
</html>
<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title><fmt:message key="title"/></title></head>
<body>
  <h1><fmt:message key="guidelines.heading"/></h1>
  <p><fmt:message key="guidelines.greeting"/> </p>
  <h2>Guides</h2>
  
  <h3>Select a category</h3>
  <c:forEach items="${model.guideCategories}" var= "car" >
  	<h4></h4><br><a href="<c:url value="/guidelines/category/${car.id }" />" > <c:out value="${car.guideCategoryName }"/> </a> </br></h4>
  </c:forEach>
  
  
  <!--<c:forEach items="${model.guides}" var="guide">
  	
    Title <c:out value="${guide.guideDescription}"/> 
    <br> Description <c:out value="${guide.guideTitle}"/><br><br>
    
  </c:forEach> -->
  <br>
  <a href="<c:url value="/guide/add"/>">
   <button>Add your own</button>
  </a>

 
</html>
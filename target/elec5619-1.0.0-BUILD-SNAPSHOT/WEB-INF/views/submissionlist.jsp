<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1>
    	<fmt:message key="heading"/>
    </h1>
    <p>
    	<fmt:message key="greeting"/>
    	<c:out value="${model.now}"/>
    </p>
    <h3>Account Settings</h3>
    <c:forEach items="${model.users}" var="prof">
    	<c:out value="${prof.username}"/>
    	<br>
    	<c:out value="${prof.password}"/>
    	<br>
    	<c:out value="${prof.confirmpassword}"/>
    	<br>
    	<c:out value="${prof.firstname}"/>
    	<br>
    	<c:out value="${prof.lastname}"/>
    	<br>
    	<c:out value="${prof.description}"/>
    	<br>
    	<i>$<c:out value="${prof.price}"/></i>
    	<br>
    	<a href="user/edituser/${prof.id }">edit</a>
    	<br>
    	<a href="user/delete/${prof.id }">delete</a>
    	<br>
    	<br>
    </c:forEach>
    
    <!--  link to the increase price page -->
    <br>
    	<a href="<c:url value="priceIncrease.htm"/>">Increase Prices</a>
    <br>
  </body>
</html>
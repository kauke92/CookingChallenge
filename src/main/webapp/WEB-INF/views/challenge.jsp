<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
					<title><fmt:message key="title" /></title>

	</head>

	<body>
	
	
	
	

	
	<section class="wrapper">
	
	
			  <div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa fa-bars"></i> Challenge</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
						<li><i class="fa fa-square-o"></i>Challenge</li>
					</ol>
				</div>
			</div>
	
	<h1>
			<fmt:message key="heading" />
		</h1>
		<p>
			<fmt:message key="greeting" />
			<c:out value="${model.now}" />
		</p>
		<h3>Challenges</h3>
		
		<c:forEach items="${model.challenges}" var="challs">
				
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
			<a href="challenge/editchallenge/${challs.id}">edit</a>
			<a href="challenge/delete/${challs.id }">delete</a>
			<a href="challenge/view/${challs.id }">view</a>
			<br>
			<br>
			<br>
		</c:forEach>
	
		<br>
	<a href="challenge/addchallenge"><button>Add Challenge</button></a>
	<br>
	</section>
      
	
		
	</body>
</html>

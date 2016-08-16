<%@ include file="/WEB-INF/views/include.jsp"%> 
<%@ include file="/WEB-INF/views/sideAndTop.jsp"%> 

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add a new challenge on this page</title>
	</head>
	<body>
	      <section id="main-content">
	
	<section class="wrapper">
	<div class="col-lg-12">
	                      <section class="panel">
                          <header class="panel-heading">
                             Form Elements
                          </header>
                          <div class="panel-body">
                              <form class="form-horizontal " method="get">
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Title</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Description</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Duration</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Rules</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Ingredients</label>
                                      <div class="col-sm-10">
                                      		<textarea class="form-control"></textarea>
                                      </div>
                                  </div>
                              </form>
                          </div>
                      </section>
                      </div>
                   </section>   
	<section class="wrapper">
		<h1>Hi, you can add a new challenge on this page</h1>
		<form action="addchallenge" method="post">
		<br>
		Title: <input type="text" name="title" required/>
		<br>
		Description: <input type="text" name="description" required/>
		<br>
		Duration: <input type="text" name="duration" required/>
		
		<br>
		Rules: <input type="text" name="rules" required/>
		
		<br>
		Ingredients: <br><textarea rows="4" cols="50" name="ingredients"></textarea>
			<input type="submit" value="Add"/>
		</form>
		
		<br>
		<form><input type="button" value="Go Back" onClick="history.go(-1);return true;"></form>		
		<br>
		</section>
		</section>
	</body>
</html>
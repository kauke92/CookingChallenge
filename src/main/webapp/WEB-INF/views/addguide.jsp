<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transactional//EN" "http"//w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" conten="text/html; charset=ISO-8859-1">
		<tittle> Add a new add on this page </tittle>
		<style>
			.error{color:red;}
		</style>
	</head>
	
	<body>
		
		
		<form:form method="POST" commandName="guide">
			<!-- <form:errors path="*" cssClass="errorblock" element="div" /> -->
			
			<table>
				<tr>
					<td> Category : </td>
					<td><form:select path="guideCategory">
						<form:options items="${categoryList}" />
					</form:select></td>
					<td><form:errors path="guideCategory" cssClass="error"/></td>
				</tr>
				<tr>
					<td> Title : </td>
					<td> <input type="text" name="guideTitle"/> </td>
					<td><form:errors path="guideTitle" cssClass="error"/></td>
				</tr>
				
				<tr>
					<td> Description : </td>
					<td> <input type="text" name="guideDescription"/> </td>
					<td><form:errors path="guideDescription" cssClass="error"/></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit"/> </td>
				</tr>
				
			</table>
		</form:form>
			
		
		
		
		<!--<form action="add" method="post">
			Title: <input type="text" name="guideTitle"/>
			Description: <input type="text" name="guideDescription">
			<input type="submit" value="Add"/>
		</form>
		<td width="60%">
					<form:errors path="guideTitle" cssClass="error"/>
		</td> -->
			
	</body>
</html>

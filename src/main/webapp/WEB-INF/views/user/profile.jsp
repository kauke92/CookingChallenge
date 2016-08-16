<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1>
    	<fmt:message key="profileheading">
    		<fmt:param value="${user.username}"/>
    	</fmt:message>
    </h1>
  <!--  <p>
    	<fmt:message key="greeting"/>
    </p> -->
    <h3>Account Settings</h3>
    <table>
					<tr>
						<th><label for="user_description">Description:</label></th>
						<td><c:out value="${user.description}"/></td>
					</tr>
					<tr>
						<th><label for="user_username">Username</label></th>
						<td><c:out value="${user.username}"/></td>
					</tr>
					<tr>
						<th><label for="user_firstname">First Name</label></th>
						<td><c:out value="${user.firstname}"/></td>
					</tr>
					<tr>
						<th><label for="user_lastname">Last Name</label></th>
						<td><c:out value="${user.lastname}"/></td>
					</tr>
					<tr>
						<th><label for="user_emailaddress">Email Address</label></th>
						<td><c:out value="${user.emailaddress}"/></td>
					</tr>
					<tr>
						<th><label for="user_location">Location</label></th>
						<td><c:out value="${user.location}"/></td>
					</tr><tr>
						<th><label for="user_datecreated">Date Created</label></th>
						<td><c:out value="${user.datecreated}"/></td>
					</tr>
			
				</table>
    
    
    	<a href="/elec5619/challengeentry/${user.id}/submit"><button>Submit Challenge Entry</button></a>
    	
    	<a href="/elec5619/challengeentry/${user.id}/searchchallengeentries"><button>Your Challenge Entries</button></a>
    	<br>
    	<a href="edituser"><button>Edit Account</button></a>
    	
    	<a href="delete"><button>Delete Account</button></a>
    	<br>
    	
    
  </body>
</html>
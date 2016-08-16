<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<title>Home</title>
</head>
<body>
	<h1>Welcome to Great-Ful Cooking!</h1>

	<P>The time on the server is ${serverTime}.</P>


	<div class="col-md-3">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href="elec5619">Home</a></li>
			<li><a href="user/add"">Sign Up</a></li>
			<li><a href="about">About</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">User <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="user">Sign Up</a></li>
					<li><a href="user/users">Search Users</a></li>
				</ul></li>
			<li><a href="cookbook">Cookbook</a></li>
			<li><a href="guidelines">Guides</a></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Competition <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="challenge">Current Challenge</a></li>
					<li><a href="#">Previous Challenges</a></li>
					<li><a href="#">Submit Entry</a></li>
					<li><a href="#">Your Submissions</a></li>
					<li><a href="challengeentry/allchallengeentries">Search
							Submissions</a></li>
				</ul></li>
		</ul>
	</div>

	<a href="user/users"><button>Search Users</button></a>
	<a href="challengeentry/allchallengeentries"><button>Search
			ChallengeEntries</button></a>
	<br>
	<a href="user/add"><button>Sign Up</button></a>
	<br>
	<a href="about"><button>About</button></a>
	<br>
	<a href="cookbook"><button>Cookbook</button></a>
	<br>
	<a href="guidelines"><button>Guides</button></a>
	<br>
	<a href="challenge"><button>Challenge</button></a>
	<br>
</body>
</html>

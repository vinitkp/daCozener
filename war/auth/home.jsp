<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>

<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<html>
<head>
<title>Welcome to online tambola | Play the game</title>
<!-- Included CSS Files (Compressed) -->
<link rel="stylesheet" href="/stylesheets/foundation.min.css">
<link rel="stylesheet" href="/stylesheets/app.css">
<link rel="stylesheet" href="/stylesheets/tambola.css">
<link href='http://fonts.googleapis.com/css?family=Skranji'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Life+Savers'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Bubbler+One'
	rel='stylesheet' type='text/css'>



<!-- IE Fix for HTML5 Tags -->
<!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>

	<%
	if(session.getAttribute("name") == null)
		response.sendRedirect("/index.jsp?status=002");
%>
	<br />
	<br />
	<br />
	<br />
	<br />
	<!--  header -->
	
	<div class="row color-six">
		<div class="eight columns">
			<!--<div class="welcome">-->
			<h4>Hi <b><%= session.getAttribute("name") %></b>,</h4><br />
		</div>
		<div class="two columns offset-by-two">
			<a href="/logout" class="radius nice blue button">Logout</a>
		</div>
	</div>
	<div class="row color-six">
		<hr />
		<h5>Welcome to the First Phase of COZENER:"TAMBOLA/HOUSIE"</h5>
	</div>
	<!-- main body -->
	<div class="row color-six">
	<div class="five columns centered">
		<img src="http://4.bp.blogspot.com/_-2xZsYWDiIM/TIe6TIDim4I/AAAAAAAACLw/VHcuDIScRq8/s1600/tambola.JPG">
	</div>
	</div>
	<div class="row color-six">
	<!--<div style="border-left:1px solid #000;height:500px"></div>-->
		<div id="body-left" class="eight columns body-left">
			<!-- code here to tell the user about the rules and the button to start the game. -->
			Hi, there
			<p>Tambola is game of luck and your responsiveness.You will be
				presented with a 3x10 grid which will contain 15 numbers. Every 10
				seconds you will be presented with a number. If that number is on
				your grid. Click on the cell of the grid to strike out that number.

			</p>
			<p>There are 4 patterns to find on your grid making you eligible
				of a prize.
			<ul>
				<li><h3>Top Row - 20 points</h3></li>
				<li><h3>Middle Row - 20 points</h3></li>
				<li><h3>Bottom Row - 20 points</h3></li>
				<li><h3>Full House- 50 points</h3></li>
			</ul>
<%//game.jsp?name=<%=session.getAttribute("name")%> 
		
			<a id="demo" class="medium nice button blue" href="#">Wild Card Questions</a> 
			<a id="play" class="medium nice button blue"	href="/gamestart">Start Playing</a>
		</div>


		<div class="four columns">
			<!--  code here for advertisements or perks or leader board -->

		</div>
	</div>


<!--footer-->
		<div class="row color-six">
			<div class="eight columns centered">
				<hr />
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;An event under <a href="http://synapse.daiict.ac.in/2013/">SYNAPSE</a>.Website created by Vinit Pandey and Abhishek Kumar.<a href="../contact.jsp">Contact Us</a></font>
				<br />
				<br />
			</div>
		</div>

	<script src="/javascripts/jquery.js"></script>
		<script src="/javascripts/modernizr.foundation.js"></script>

</body>
</html>
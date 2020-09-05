<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!-- convert html form element into Spring form element -->
<html>
<head>
<meta charset="UTF-8">
<title>H+ Sport</title>
	<link rel="stylesheet" href="/css/style.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<header id="home" class="header">
		<nav class="nav" role="navigation">
			<div class="container nav-elements">
				<div class="branding">
					<a href="#home"><img src="images/hpluslogo.svg"
						alt="Logo - H Plus Sports"></a>
				</div>
				<!-- branding -->
				<ul class="navbar">
					<li><a href="/home">home</a></li>
					<li><a href="/goToSearch">search</a></li>
					<li><a href="">linkedIn</a></li>

				</ul>
				<!-- navbar -->
			</div>
			<!-- container nav-elements -->
		</nav>
		
		<!-- <div class="container tagline">
    <h1 class="headline">Our Mission</h1>
    <p>We support and encourage <em>active and healthy</em> lifestyles, by offering <em>ethically sourced</em> and <em>eco-friendly</em> nutritional products for the <em>performance-driven</em> athlete.</p>
  </div>container tagline -->
	</header>
	<!-- #home -->




	<section id="registration" class="section">
	 <div class="container tagline">
	 <em>Register User</em><br/> <!-- for:error=== To show error msg next to the text box Spring tag for error -->
    		 <form:form method="post" action="/registeruser"  modelAttribute="newuser">  <!-- #data binding  -->
    			<label>Username</label> <form:input path="username" type="text" /><form:errors path="username" cssClass="error"> </form:errors><br/>
    			<label>Password</label> <form:input path="password" type="password" /> <form:errors path="password" cssClass="error"> </form:errors><br/>
    			<label>First Name</label> <form:input path="firstName" type="text" /> <form:errors path="firstName" cssClass="error"> </form:errors><br/>
    			<label>Last Name</label> <form:input path="lastName" type="text" /><br/>
    			<label>What do you want to do? </label> 
				<form:radiobutton  path="activity" id="activity" value="Playing a sport" />Play a Sport?
				<form:radiobutton  path="activity" id="activity" value="Gym" />Hit the Gym?<form:errors path="activity" cssClass="error"> </form:errors>
				<br/> 
				
    			<label>Date of birth</label>
    			<form:input path="dateOfBirth" type="date" /> <form:errors path="dateOfBirth" cssClass="error"> </form:errors><br/>
    			<label>Gender</label>
    			<form:select path="gender" items="${genderItems}" > </form:select> <!-- see the HomeController for ModelAttribute -->
    			<input type="submit" value="Submit" id="submit">
    		</form:form>
		</div>
	</section>
	<footer class="footer">
		<div class="container">
			<nav class="nav" role="navigation">
				<div class="container nav-elements">
					<div class="branding">
						<a href="#home"><img src="images/hpluslogo.svg"
							alt="Logo - H Plus Sports"></a>
						<p class="address">
							100 Main Street<br> Seattle, WA 98144
						</p>
					</div>
				</div>
			</nav>
			<p class="legal">H+ Sport is a fictitious brand created by
				lynda.com solely for the purpose of training. All products and
				people associated with H+ Sport are also fictitious. Any resemblance
				to real brands, products, or people is purely coincidental.
				Information provided about the product is also fictitious and should
				not be construed to be representative of actual products on the
				market in a similar product category.</p>
		</div>
		<!-- container -->
	</footer>
	<!-- footer -->




</body>
</html>
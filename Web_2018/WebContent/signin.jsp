<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign in</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div class="container">
		<p>
			<img src="images/user.png">
		</p>
		<form action="handingLogin" method="post">
			<div class="top">LOGIN</div>
			<div class="center" id="m-top">
				<input type="text" name="username" placeholder="Username">
				<br>
				<% if (request.getAttribute("email_err") !=null){ 
						out.print("<font color=\"red\">"+(String)request.getAttribute("email_err")+"</color>"); } %>
			</div>
			<div class="center">
				<input type="password" name="password" placeholder="Password">
				<br>
				<% if (request.getAttribute("pass_err") !=null){ 
						out.print("<font color=\"red\">"+(String)request.getAttribute("pass_err")+"</color>"); } %>
			</div>
			<div class="center">
				<input type="Submit" name="submit" value="SIGN IN">
			</div>
			<div class="on-bottom"></div>
			<p class="bottom">
				<a href="forgot.jsp">Forgot Password ?</a>&nbsp&nbsp&nbsp&nbsp <a
					href="signup.jsp">Create an Account</a>
			</p>
			<p>
				Designed by <a href="https://www.facebook.com/ngoduyphuc"> NDP </a>&copy
				All right reserved .
			</p>
		</form>
	</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Panayiotis
  Date: 08/11/2019
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Panayiotis Yiannoukkos">

	<link rel="stylesheet" href="./css/master.css">
	<title>Welcome</title>
</head>
<body>
<div class="sign-up-form">
	<h1>Sign Up Now</h1>
	<form action="register" method="post">
		<input type="text" name="userName" class="input-box" placeholder="Your Username" required="required"><br>
		<input type="password" name="password" class="input-box" placeholder="Your Password" required="required"><br>
		<input type="email" name="email" class="input-box" placeholder="Your Email" required="required"><br>
		<input type="submit" class="signup-btn" value="Sign Up">
		<hr>
		<p class="or">OR</p>
		<p>
			Do you have an account? <a href="./login.jsp">Sign in</a>
		</p>
	</form>
</div>
</body>
</html>
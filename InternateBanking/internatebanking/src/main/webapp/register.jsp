<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

<link rel="stylesheet" href="css/register.css">

</head>
<body>

<div class="form-container">

    <h2>Create Account</h2>

    <form action="register" method="post">
    
        Name:<br>
        <input type="text" name="name" required="required"><br>
        
        Email:<br>
        <input type="email" name="email" required="required"><br>
        
        Password:<br>
        <input type="password" name="password" required="required"><br>
        
        <input type="submit" value="Register">
    
    </form>

    <div class="links">
        <a href="login.jsp">Already have an account? Login</a>
    </div>

</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>
<body>
<h1 align="center">LoginForm</h1><br><hr>
<h2 align="center">${msg }</h2>
<div align="center">
<form action="login.do" method="post">
UserName : <input type="text" name="userName"/>&nbsp;&nbsp;&nbsp;
&nbsp;PassWord : <input type="password" name="password"/>
&nbsp;<input type="submit" value="Login"/>
</form>
</div>
</body>
</html>
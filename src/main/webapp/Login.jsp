<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="color:red">${msg}</h1>
<h1>Welcome to Login Page</h1>
<form action="login" method="post">


Email<input type="text" name="email"><br>
Password<input type="text" name="pwd"><br>
<button>Login</button><button type="reset">Cancel</button><br>
<a href="Load">New?User Click here to SignUp</a>



</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="x" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>

<x:form action="update" modelAttribute="emp" method="post">
     Id:<x:input path="id"/><br>
	   Name:<x:input path="name"/><br>
	     Email:<x:input path="email"/><br>
	       Mobile:<x:input path="mobile"/><br>
	         Password:<x:input path="password"/><br>
	         <x:button>Update</x:button>
	   
	   </x:form>
 
</body>
</html>
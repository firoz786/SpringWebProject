<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Add</title>
</head>
<body>
<div align ="center">
	<form:form action="studentSave" modelAttribute="student" method ="POST">
		<h3>Add Student</h3>
		<form:hidden path="id"/>
		<label>Name : </label>
		<form:input  path="name"/>
		<br>
		<label>Mobile : </label>
		<form:input  path="mobile"/>
		<br>
		<label>Country : </label>
		<form:input  path="country"/>
		<br>
		<input type="submit"  value ="Submit"/>
	</form:form>
</div>
</body>
</html>
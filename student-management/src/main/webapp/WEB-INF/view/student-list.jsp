<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<link rel="stylesheet" type="text/css"
	href="/student-management/URLToReachResourcesFolder/css/my-style-sheet.css">

</head>
<body>
	<h1 align="center">Firoz Alam Express</h1>
	<div align="center">
		<form action="showAddStudentPage">
			<input type="submit" value="ADD">
		</form>
		<table border="2">
			<thead>
				<tr>
					<td>id</td>
					<td>name</td>
					<td>mobile</td>
					<td>country</td>
				</tr>
			</thead>
			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobile}</td>
					<td>${student.country}</td>
					<td><a href="updateStudent?userId=${student.id}">Update</a></td>
					<td><a href="deleteStudent?userId=${student.id}"
						onclick="if (!(confirm('Are you sure you want to DLT this record??'))) return false">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<img src="/student-management/URLToReachResourcesFolder/images/Developer photo.PNG" alt="fake photo ">
	</div>
</body>
</html>
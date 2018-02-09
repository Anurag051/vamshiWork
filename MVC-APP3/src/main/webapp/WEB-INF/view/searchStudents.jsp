<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>SearchStudents</title>
</head>
<body>
	<center>
		<form action="searchStudents.do" method="post">
			<input type="text" placeholder="studentId" name="studentId" />&nbsp;
			<input type="text" placeholder="name" name="name" />&nbsp; <input
				type="text" placeholder="course" name="course" />&nbsp; <input
				type="text" placeholder="mobile" name="mobile" />&nbsp; <input
				type="submit" value="search" />&nbsp;
		</form>
	</center>
</body>
</html>

<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<title>SearchStudents</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<jsp:include page="searchStudents.jsp" /><br>
<br>
<body>
	<center>
		<c:choose>
			<c:when test="${searchResults.size()>0 }">
				<table bgcolor="#00FF00">
				<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>MOBILE</th>
							<th>COURSE</th>
							<th>CITY</th>
							<th>STATE</th>
						</tr>
					<c:forEach items="${searchResults}" var="searchResults">
						
						<tr>
							<td>${searchResults.studentId}</td>
							<td>${searchResults.name}</td>
							<td>${searchResults.mobile}</td>
							<td>${searchResults.course}</td>
							<td>${searchResults.city}</td>
							<td>${searchResults.state}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<c:out value="no Records Found" />
			</c:otherwise>
		</c:choose>

	</center>
</body>
</html>

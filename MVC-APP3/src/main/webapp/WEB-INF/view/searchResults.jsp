<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<title>SearchStudents</title>
</head>
<jsp:include page="searchStudents.jsp" />
<body>
	<center>
		<c:choose>
			<c:when test="${serchResults.size()>0 }">
				<table border="1">
					<c:forEach items="${serchResults}" var="serchResults">
						<tr>
							<td>${serchResults.studentId}</td>
							<td>${serchResults.name}</td>
							<td>${serchResults.mobile}</td>
							<td>${serchResults.course}</td>
							<td>${serchResults.city}${serchResults.state}</td>
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

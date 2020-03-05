<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty list }">
			<a href="excel">Export To Excel</a>|<a href="pdf">Export To Pdf</a>
			<table border="1">
				<tr>
					<th>USER ID</th>
					<th>USER TYPE</th>
					<th>CODE</th>
					<th>USER FOR</th>
					<th>EMAIL</th>
					<th>CONTACT</th>
					<th>ID TYPE</th>
					<th>*IF OTHER</th>
					<th>ID NUMBER</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.userId}</td>
						<td>${ob.userType}</td>
						<td>${ob.userCode}</td>
						<td>${ob.userFor}</td>
						<td>${ob. userEmail}</td>
						<td>${ob.userContact}</td>
						<td>${ob.userIdType}</td>
						<td>${ob.ifOther}</td>
						<td>${ob.userIdNum}</td>
						<td><a href="delete?uid=${ob.userId}">DELETE</a></td>
						<td><a href="edit?uid=${ob.userId}">EDIT</a></td>
						<td><a href="view?uid=${ob.userId}">VIEW</a></td>

					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<H3>NO DATA FOUND!!!</H3>
		</c:otherwise>
	</c:choose>
	${message}
</body>

</html>
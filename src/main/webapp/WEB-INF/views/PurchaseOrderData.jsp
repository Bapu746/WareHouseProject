<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty list }">
			<a href="excel">Export to Excel</a>|<a href="pdf" style="color: red">Export
				To Pdf</a>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>REF NUM</th>
					<th>QUALITY CHECK</th>
					<th>DEF STATUS</th>
					<th>DESCRIPTION</th>

					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.ordId}</td>
						<td>${ob.ordCode }</td>
						<td>${ob.refNum}</td>
						<td>${ob.qualityCheck}</td>
						<td>${ob.defStatus}</td>
						<td>${ob.desc}</td>
						<td><a href="delete?pid=${ob.ordId}">DELETE</a></td>
						<td><a href="edit?pid=${ob.ordId}">EDIT</a>
						<td><a href="view?pid=${ob.ordId}">VIEW</a>
					</tr>
				</c:forEach>
			</table>
	${message}
		</c:when>
		<c:otherwise>
			<H3>NO DATA FOUND!!!</H3>
		</c:otherwise>
	</c:choose>
</body>

</html>
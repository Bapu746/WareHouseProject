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
<%@include file="UserMenu.jsp" %>
	<div class="container">

		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<H3>WELCOME TO ORDER METHOD DATA PAGE</H3>
			</div>
			<div class="card-body">
				<c:choose>
					<c:when test="${!empty list }">
						<a href="excel" class="btn btn-link">Export to Excel</a>|<a href="pdf"
							 class="btn btn-link">Export To Pdf</a>
						<table class="table table-hover">
							<tr class="bg-success text-white">
								<th>ID</th>
								<th>MODE</th>
								<th>CODE</th>
								<th>TYPE</th>
								<th>ACCEPT</th>
								<th>DESCRIPTION</th>
								<th colspan="3">OPERATION</th>
							</tr>
							<c:forEach items="${list }" var="ob">
								<tr>
									<td>${ob.ordId}</td>
									<td>${ob.ordMode}</td>
									<td>${ob.ordCode}</td>
									<td>${ob.ordType}</td>
									<td>${ob.ordAccept}</td>
									<td>${ob.ordDesc}</td>
									<td><a class="btn btn-danger"
										href="delete?ordid=${ob.ordId}">DELETE</a></td>
									<td><a href="edit?orid=${ob.ordId }" class="btn btn-info">EDIT</a>
									<td><a href="view?orid=${ob.ordId }"
										class="btn btn-warning">VIEW</a>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<H3>NO DATA FOUND!!!</H3>
					</c:otherwise>
				</c:choose>
				<c:if test="${!empty message }">
				<c:choose>
					<c:when test="${opr eq 'DEL'}">
						<div class="card-footer bg-danger text-white text-center"><b>${message }</b></div>
					</c:when>
					<c:otherwise>
						<div class="card-footer bg-info text-white text-center"><b>${message }</b></div>
					
					</c:otherwise>
				</c:choose>
			</c:if>

			</div>
		</div>
	</div>
	<!-- container end -->
</body>

</html>
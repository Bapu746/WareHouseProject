<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-4 bg-primary">
				<a class="text-white text-center" href="excel?oid=${ob.ordId}" class="btn btn-link">Export to
					Excel</a>| <a class="text-white text-center" href="pdf?oid=${ob.ordId}" class="btn btn-link">Export
					To Pdf</a>
			</div>
			<div class="col-8"></div>
		</div>
		<div class="row">
			<div class="col-4">
				<table class="table table-hover">
					<tr class="bg-primary text-white">
						<th>ID</th>
						<td>${ob.ordId }</td>
					</tr>
					<tr class="bg-success text-white">
						<th>MODE</th>
						<td>${ob.ordMode }</td>
					</tr>
					<tr class="bg-info text-white">
						<th>CODE</th>
						<td>${ob.ordCode }</td>
					</tr>
					<tr class="bg-warning text-white">
						<th>TYPE</th>
						<td>${ob.ordType }</td>
					</tr>
					<tr class="bg-danger text-white">
						<th>ACCEPT</th>
						<td>${ob.ordAccept }</td>
					</tr>
					<tr class="bg-secondary text-white">
						<th>DESCRIPTION</th>
						<td>${ob.ordDesc }</td>
					</tr>
				</table>
			</div>
			</div>
		</div>
		<!-- container -->
</body>
</html>
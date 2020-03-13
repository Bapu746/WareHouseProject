<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GRN View</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h3 class="text-success">Order View Page</h3>
	<div class="row">
		<div class="col-1"></div>
		<div class="col-4">
			<table class="table">
				<tr>
					<th>ID</th>
					<td>${ob.grnId }</td>
				</tr>
				<tr>
					<th>CODE</th>
					<td>${ob.grnCode }</td>
				</tr>
				<tr>
					<th>TYPE</th>
					<td>${ob.grnType }</td>
				</tr>
				<tr>
					<th>DESCRIPTION</th>
					<td>${ob.grnDesc }</td>
				</tr>
			</table>
			<a href="excel?gid=${ob.grnId}">EXCEL EXPORT</a>&nbsp;|&nbsp; <a
				href="pdf?gid=${ob.grnId}">PDF EXPORT</a>
		</div>
		<div class="col-7"></div>
	</div>
</body>
</html>
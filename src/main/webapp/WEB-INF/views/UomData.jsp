<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
th, td {
	padding: 15px;
	text-align: center;
}

th {
	background-color: green;
	color: white;
	font-size: 12pt;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty list }">

			<div class="container">
				<div class="col-lg-1"></div>
				<div class="col-lg-10">
					<table class="table table-bordered table-striped table-hover">
						<thead class=”thead-light”>
							<tr class="table-info">
								<th>ID</th>
								<th>TYPE</th>
								<th>MODEL</th>
								<th>DESCRIPTION</th>
								<th colspan="3">OPERATION</th>
							</tr>
						</thead>
						<c:forEach items="${list}" var="ob">
							<tbody>
								<tr>

									<td>${ob.uomId}</td>
									<td>${ob.uomType}</td>
									<td>${ob.uomModel}</td>
									<td>${ob. uomDesc}</td>
									<td colspan="3"><a href="delete?umid=${ob.uomId}"
										class="btn btn-info">DELETE</a> <a
										href="edit?umid=${ob.uomId}" class="btn btn-info">EDIT</a> <a
										href="view?umid=${ob.uomId}" class="btn btn-info">VIEW</a></td>

								</tr>
							</tbody>
						</c:forEach>
					</table>
					<div class="row">
						<div class="col-lg-5">
							<a href="excel" class="btn btn-link">Export To Excel</a>
							<a href="pdf" class="btn btn-link">Export To PDF</a>
						</div>
					</div>
				</div>
				<div class="col-lg-1"></div>
			</div>

		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="col-lg-5">
					<H3 class="bg-danger"><b>NO DATA FOUND!!!</b></H3>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<span class="label label-success">${message}</span>
</body>
</html>
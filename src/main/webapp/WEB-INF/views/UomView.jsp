<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container ">

		<div class="row">
			<div class="col-lg-0"></div>
			<div class="col-lg-6">
				<table class="table table-bordered table-striped table-hover">

					<tr class="info">
						<th>ID</th>
						<td>${ob.uomId }</td>
					</tr>
					<tr class="warning">
						<th>TYPE</th>
						<td>${ob.uomType }</td>
					</tr>
					<tr class="danger">
						<th>MODEL</th>
						<td>${ob.uomModel }</td>
					</tr>
					<tr class="active">
						<th>DESCRIPTION</th>
						<td>${ob.uomDesc }</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="col-lg-7"></div>
	</div>
	<div class="row">
		<div class="col-lg-5">
			<a href="excel?uid=${ob.uomId}" class="btn btn-link">Export To Excel</a>|<a href="pdf?uid=${ob.uomId}" class="btn btn-link">Export To PDF</a>
		</div>
	</div>
</body>
</html>
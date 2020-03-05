<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="UserMenu.jsp"%><br>

	<div class="container">
		<div class="row">

			<div class="col-4 bg-primary text-white text-center">

				<a class="text-white" href="excel?sid=${ob.shipId }">Export to
					Excel</a>|<a class="text-white" href="pdf?sid=${ob.shipId }">Export
					to PDF</a>
			</div>
			<div class="col-8"></div>

		</div>

		<div class="row">
			<div class="col-4">
				<br><table class="table table-hover">
					<tr class="bg-success text-white">
						<th>ID</th>
						<td>${ob.shipId }</td>
					<tr class="bg-info text-white">
						<th>MODE</th>
						<td>${ob.shipMode }</td>
					</tr>
					<tr class="bg-success text-white">
						<th>CODE</th>
						<td>${ob.shipCode }</td>
					</tr>
					<tr class="bg-info text-white">
						<th>ENABLE</th>
						<td>${ob.enbShip }</td>
					</tr>
					<tr class="bg-success text-white">
						<th>GRADE</th>
						<td>${ob.shipGrade }</td>
					</tr>
					<tr class="bg-info text-white">
						<th>DESCRIPTION</th>
						<td>${ob.shipDesc }</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
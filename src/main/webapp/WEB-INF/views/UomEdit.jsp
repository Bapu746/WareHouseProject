<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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


	<H3 style='color: red; text-align: center'>EDIT UOM DETAILS!!!</H3>

	<div class="container">

		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<form:form action="update" method="post" modelAttribute="uom">
					<div class="row">

						<label for="UOM">UOM ID:</label>
						<form:input type="text" path="uomId" class="form-control"
							readOnly="true" />
					</div>
					<div class="row">

						<form:select path="uomType" class="form-control">
							<form:option value="">-select-</form:option>
							<form:option value="PACKING">PACKING</form:option>
							<form:option value="NO PACKING">NO PACKING</form:option>
							<form:option value="-NA-">-NA-</form:option>
						</form:select>
					</div>
					<br>
					<div class="row">
						<label for="UOM">Uom Model:</label>
						<form:input class="form-control" type="text" path="uomModel" />
					</div>
					<div class="row">

						<label for="Description">Description:</label>
						<form:textarea path="uomDesc" class="form-control"></form:textarea>
					</div>
					<div class="row">
						<input type="submit" class="btn btn-primary" value="Update Uom">
					</div>
				</form:form>
			</div>
		</div>
		<div class="col-lg-3"></div>
	</div>



	<span>${message}</span>
</body>

</html>
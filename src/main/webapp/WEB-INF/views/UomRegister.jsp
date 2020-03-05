<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<div class="col-lg-1"></div>
			<div class="col-lg-6">
				<form:form action="save" method="post" modelAttribute="uom">
	            <h3  class="text-success"><b>UOM REGISTRATION PAGE!!!</b></h3>

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
						<input type="submit" class="btn btn-primary" value="Create Uom">
					</div>
				</form:form>
			</div>
		</div>
		<div class="col-lg-5"></div>
	</div>



	<span class="label label-success">${message}</span>
</body>

</html>
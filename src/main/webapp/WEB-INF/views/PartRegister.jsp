<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<div class="card">
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>
					<b>WELCOME TO PART REGISTER PAGE</b>
				</h3>
			</div>
			<div class="card-body">
				<form:form class="" role="form" action="save" method="POST"
					modelAttribute="part">

					<div class="row">
						<div class="col-2">
							<label class="control-label" for="CODE"> CODE:</label>
						</div>
						<div class="col-2">
							<form:input type="text" path="partCode" />

							<div class="col-2">
								<!-- Error Message -->
							</div>
							<br>

						</div>
					</div>
					<div class="row">
						<div class="col-2">
							<b><label for="DIMENSIONS"> DIMENSIONS:</label></b>
						</div>
						<div>
							<label class="control-label" for="width"> W:</label>
						</div>
						<div class="col-2">
							<form:input type="text" path="width" />
						</div>
						<div class="col-1"></div>
						<div>
							<label class="control-label" for="length"> L:</label>
						</div>
						<div class="col-2">
							<form:input type="text" path="length" />
						</div>
						<div class="col-1"></div>
						<div>
							<label class="control-label" for="height"> H:</label>
						</div>
						<div class="col-2">
							<form:input type="text" path="height" />
						</div>

						<div class="col-2">
							<!-- Error Message -->
						</div>
					</div>
					<br>

					<div class="row">
						<div class="col-2">
							<label for="length"> BASE CURRENCY:</label>
						</div>
						<div class="col-4">
							<form:select class="form-control" path="baseCurrency">
								<form:option value="">--Select--</form:option>
								<form:option value="INR">INR</form:option>
								<form:option value="USD">USD</form:option>
								<form:option value="AUS">AUS</form:option>
								<form:option value="ERU">ERU</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-2">
							<label for="uomOb"> UOM MODEL:</label>
						</div>
						<div class="col-4">
							<form:select class="form-control" path="uomOb.uomId">
								<form:option value="">--Select--</form:option>
								<form:options items="${uomMap}"/>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-2">
							<label for="ordOb"> ORDER METHOD CODE(SALE):</label>
						</div>
						<div class="col-4">
							<form:select class="form-control" path="ordSaleOb.ordId">
								<form:option value="">--Select--</form:option>
								<form:options items="${ordSaleMap}"/>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-2">
							<label for="ordOb"> ORDER METHOD CODE(PURCHASE):</label>
						</div>
						<div class="col-4">
							<form:select class="form-control" path="ordPurOb.ordId">
								<form:option value="">--Select--</form:option>
								<form:options items="${ordPurMap}"/>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-2">
							<label class="control-label" for="DESCRIPTION">DESCRIPTION:</label>
						</div>
						<div class="col-4">
							<form:textarea class="form-control rounded-0" path="desc" />
						</div>
					</div>
					<br>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create" class="btn btn-success" /> <input
								type="reset" value="Clear" class="btn btn-danger" />
						</div>
					</div>

				</form:form>
			</div>
			<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center"><b>${message}</b></div>
			</c:if>
		</div>
	</div>


</body>
</html>
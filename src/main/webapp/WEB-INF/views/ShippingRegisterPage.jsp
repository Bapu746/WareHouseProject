<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipping Registration</title>
<style type="text/css">
.btn-lg {
	margin-left: 400px;
}
.card-body {
	background-color: #adb9cc;
}
#head, h3 {
	background-color: #a70907;
}
.form-control {
	margin-top: 20px;
	border: 5px;
	border-radius: 10px;
	border-bottom: 2px solid gray;
	font-size: 15px;
	color: green;
}
.control-label {
	font-size: 15px;
	margin-top: 20px;
	font-weight: bold;
}
</style>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card-header" id="head">
			<h3 class="text-white text-center text-uppercase">Order Method
				Registration</h3>
		</div>
		<div class="card-body">
			<form:form action="save" method="POST" modelAttribute="shipping">
				<div class="row">
					<div class="col-7">
						<div class="row">
							<div class="col-3">
								<label class="control-label">Shipping Code</label>
							</div>
							<div class="col-7">
								<form:input path="shpCode" class="form-control" />
							</div>
							<div class="col-2"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Shipping Ref Number</label>
							</div>
							<div class="col-7">
								<form:input path="shpRefNum" class="form-control" />
							</div>
							<div class="col-2"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Contact Details</label>
							</div>
							<div class="col-7">
								<form:textarea path="shpContDetails" class="form-conntrol" />
							</div>
							<div class="col-2"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Sale Order Code</label>
							</div>
							<div class="col-7">
								<form:input path="shpSaleCode" class="form-control" />
							</div>
							<div class="col-2"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Description</label>
							</div>
							<div class="col-7">
								<form:textarea path="shpDesc" class="form-control" />
							</div>
							<div class="col-2"></div>
						</div>
					</div>
					<div class="col-5">
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<label class="control-label">Billing Address</label>
								<form:textarea path="shpBillAddrs" class="form-control" />
							</div>
							<div class="col-1"></div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<label class="control-label">Shipping Address</label>
								<form:textarea path="shpShipAddrs" class="form-control" />
							</div>
							<div class="col-1"></div>
						</div>
					</div>
				</div>
				<br>
				<input type="submit" value="CREATE SHIPPING"
								class="btn btn-primary btn-lg">
			</form:form>
		</div>
		<c:if test="${!empty msg }">
			<div class="card-footer bg-info text-white text-center">
				<b>${msg}</b>
			</div>
		</c:if>

	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GRN Registration</title>
<style type="text/css">
	.btn-lg{
		margin-left: 200px;
	}
	.card-body{
		background-color:#adb9cc;
	}
	#head,h3{
		background-color: #a70907;
	}
	.form-control{
		margin-top:20px;
  		border: 5px;
  		border-radius: 10px;
  		border-bottom: 2px solid gray;
  		font-size: 15px;
  		color: green;
	}
	.control-label{
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
			<h3 class="text-white text-center text-uppercase">GRN
				Update</h3>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<form:form action="save" method="POST" modelAttribute="grn">
						<div class="row">
							<div class="col-3">
								<label class="control-label">GRN Id</label>
							</div>
							<div class="col-6">
								<form:input path="grnId" class="form-control" readonly="true"/>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">GRN Code</label>
							</div>
							<div class="col-6">
								<form:input path="grnCode" class="form-control"/>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">GRN Type</label>
							</div>
							<div class="col-6">
								<form:input path="grnType" class="form-control"/>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Order Code</label>
							</div>
							<div class="col-6">
								<form:select path="" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">--Select Type--</form:option>
								</form:select>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Descrption</label>
							</div>
							<div class="col-6">
								<form:textarea path="grnDesc" class="form-control"/>
							</div>
							<div class="col-3"></div>
						</div>
						<br>
						<input type="submit" value="UPDATE GRN"
							class="btn btn-primary btn-lg">
					</form:form>
				</div>
				<div class="col-2"></div>
			</div>
		</div>
		<c:if test="${!empty msg }">
			<div class="card-footer bg-info text-white text-center">
				<b>${msg}</b>
			</div>
		</c:if>
	</div>
</body>
</html>
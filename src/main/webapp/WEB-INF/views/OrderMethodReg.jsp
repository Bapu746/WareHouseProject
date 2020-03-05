<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">

		<div class="card">

			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>Welcome to Order Register Page</h3>
			</div>


			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="orderMethod">
					<div class="row">
						<div class="col-4">
							<label for="shipGrad">ORDER MODE :</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="ordMode" value="sale" />
							Sale
							<form:radiobutton path="ordMode" value="purchase" />
							Purchase


						</div>
						<div class="col-4"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipCode">ORDER CODE:</label>
						</div>
						<div class="col-4">
							<form:input path="ordCode" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="ordType">ORDER TYPE :</label>
						</div>
						<div class="col-4">
							<form:select class="form-control" path="ordType">
								<form:option value="">--select--</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>

					</div>
					<div class="row">
						<div class="col-4">
							<label for="ordAccept">ORDER ACCEPT :</label>
						</div>
						<div class="col-4">
							<div class="checkbox">
								<form:checkbox path="ordAccept" value="multimodel" />
								Multi-Model
								<form:checkbox path="ordAccept" value="Accept Return" />
								Accept Return <br>
							</div>
						</div>
						<div class="col-4">
							<!-- ERROR MESSAGE -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipDesc">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="ordDesc" class="form-control" />

						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create Order Method"
								class="btn btn-success" /> <input type="reset" value="Clear"
								class="btn btn-danger" />

						</div>
					</div>


				</form:form>
			</div>
			<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center">
					<b>${message}</b>
				</div>
			</c:if>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->

</body>
</html>
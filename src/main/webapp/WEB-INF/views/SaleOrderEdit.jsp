<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>
					<b>WELCOME TO SALE ORDER REGISTER PAGE</b>
				</h3>
			</div>
			<!-- card header -->
			<div class="card-body">
				<form:form class="" role="form" action="update" method="POST"
					modelAttribute="saleOrder">
					<div class="row">
						<div class="col-2">
							<label class="control-label" for="ordId"> SALE ORDER ID :</label>
						</div>
						<div class="col-2">
							<form:input type="text" path="ordId" />
                        </div>
							<div class="col-2">
								<!-- Error Message -->
							</div>
							</div> <!-- row -->
							<br>
					<div class="row">
						<div class="col-2">
							<label class="control-label" for="CODE"> ORDER CODE:</label>
						</div>
						<div class="col-2">
							<form:input type="text" path="ordCode" />
                        </div>
							<div class="col-2">
								<!-- Error Message -->
							</div>
							</div> <!-- row -->
							<br>
							<div class="row">
						<div class="col-4">
							<label for="">SHIPMENT CODE:</label>
							</div>
							<div class="col-4">
							<form:select path="" class="form-control">
							</form:select>
							</div>
							</div>
							<div class="row">
						<div class="col-4">
							<label for="">CUSTOMER:</label>
							</div>
							<div class="col-4">
							<form:select path="" class="form-control">
							</form:select>
							</div>
							</div>
							<div class="row">
						<div class="col-2">
							<label class="control-label" for="">REF. NUMBER:</label>
						</div>
						<div class="col-2">
							<form:input type="text" path="refNum" />
                        </div>
							<div class="col-2">
								<!-- Error Message -->
							</div>
							</div> <!-- row -->
							<br>
							<div class="row">
						<div class="col-4">
							<label for="">STOCK MODE:</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="stockMode" value="GRADE"  />
							GRADE
							<form:radiobutton path="stockMode" value="MARGIN" />
							MARGIN
							</div>
						<div class="col-4"><!-- Error Message --></div>
					</div>
						<div class="row">
						<div class="col-2">
							<label for=""> STOCK SOURCE:</label>
						</div>
						<div class="col-4">
							<form:select class="form-control" path="stockSource">
								<form:option value="">--Select--</form:option>
								<form:option value="OPEN">OPEN</form:option>
								<form:option value="AVAIL">AVAIL</form:option>
								<form:option value="REFUND">REFUND</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<br>	
					<div class="row">
						<div class="col-2">
							<label class="control-label" for="">DEFAULT STATUS:</label>
						</div>
						<div class="col-2">
							<form:input type="text" path="defStatus" value="SALE-OPEN" readonly="true"/>
                        </div>
							<div class="col-2">
								<!-- Error Message -->
							</div>
							</div> <!-- row -->
							<br>
							<div class="row">
						<div class="col-2">
							<label class="control-label" for="">DESCRIPTION:</label>
						</div>
						<div class="col-4">
							<form:textarea class="form-control rounded-0" path="desc" />
						</div>
					</div>
					<br>
              <div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Update Sale Order" class="btn btn-success" /> <input
								type="reset" value="Clear" class="btn btn-danger" />
						</div>
					</div>
					</form:form>
			</div>
			<!-- card body -->
			<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center"><b>${message}</b></div>
			</c:if>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->

</body>
</html>
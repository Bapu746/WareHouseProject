<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipping Data</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h2 class="text-warning bg-info text-center">Shipping Data
		Page</h2>
	<br>
	<c:choose>
		<c:when test="${!empty list}">
			<div class="row">
				<div class="col-lg-1"></div>
				<div class="col-lg-10">
					<div class="row">
						<table class="table table-dark table-hover">
							<thead class="bg-danger">
								<tr>
									<th>CODE</th>
									<th>REF NUM</th>
									<th>CONTACT DETAILS</th>
									<th>SALE CODE</th>
									<th>BILL ADDRS</th>
									<th>SHIPP ADDRS</th>
									<th>DESCRIPTION</th>
									<th colspan="3">OPERATION</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="ob">
								<tr>
									<td>${ob.shpCode }</td>
									<td>${ob.shpRefNum }</td>
									<td>${ob.shpContDetails }</td>
									<td>${ob.shpSaleCode }</td>
									<td>${ob.shpBillAddrs }</td>
									<td>${ob.shpShipAddrs }</td>
									<td>${ob.shpDesc }</td>
									<td colspan="3">
									<a href="delete?sid=${ob.shpId}"><button
												class="btn btn-danger">DELETE</button></a> <a
										href="edit?sid=${ob.shpId}"><button
												class="btn btn-success">EDIT</button></a> <a
										href="view?sid=${ob.shpId}"><button class="btn btn-info">VIEW</button></a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="row">
						<a href="excel">Export Excel</a>&nbsp;|&nbsp; <a href="pdf">Export
							PDF</a>
					</div>
					<div class="row">
						<span class="text-danger">${msg}</span>
					</div>
				</div>
				<div class="col-lg-1"></div>
			</div>
		</c:when>
		<c:otherwise>Data Not Found..!!</c:otherwise>
	</c:choose>
</body>
</html>
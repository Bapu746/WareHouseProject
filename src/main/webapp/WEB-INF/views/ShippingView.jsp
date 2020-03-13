<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipping View Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h3 class="text-success">Order View Page</h3>
	<div class="col-lg-1"></div>
	<div class="col-lg-4">
		<table class="table">
		<tr>
			<th>ID</th><td>${ob.shpId}</td>
		</tr>
		<tr>
			<th>CODE</th><td>${ob.shpCode}</td>
		</tr>
		<tr>
			<th>REF NUM</th><td>${ob.shpRefNum}</td>
		</tr>
		<tr>
			<th>CONTACT DETAILS</th><td>${ob.shpContDetails}</td>
		</tr>
		<tr>
			<th>SALE CODE</th><td>${ob.shpSaleCode}</td>
		</tr>
		<tr>
			<th>BILL ADDRS</th><td>${ob.shpBillAddrs}</td>
		</tr>
		<tr>
			<th>SHIPP ADDRS</th><td>${ob.shpShipAddrs}</td>
		</tr>
		<tr>
			<th>DESCRIPTION</th><td>${ob.shpDesc}</td>
		</tr>
		</table>
		<a href="excel?oid=${ob.shpId}">EXCEL EXPORT</a>&nbsp;|&nbsp; <a
			href="pdf?oid=${ob.shpId}">PDF EXPORT</a>
	</div>
	<div class="col-lg-7"></div>
</body>
</html>
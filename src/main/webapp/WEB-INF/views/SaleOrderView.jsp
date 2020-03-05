<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="excel?slid=${sale.ordId }">Export to Excel</a>|<a href="pdf?slid=${sale.ordId }">Export to PDF</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${sale.ordId }</td>
		<tr>
			<th>ORDER CODE</th>
			<td>${sale.ordCode }</td>
		</tr>
		<tr>
			<th>REF. NUM</th>
			<td>${sale.refNum }</td>
		</tr>
		<tr>
			<th>STOCK MODE</th>
			<td>${sale.stockMode }</td>
		</tr>
		<tr>
			<th>STOCK SOURCE</th>
			<td>${sale.stockSource}</td>
		</tr>
		<tr>
		<tr>
			<th>DEF. STATUS</th>
			<td>${sale.defStatus}</td>
		</tr>
		<tr>
			<th>DESCRIPTION</th>
			<td>${sale.desc}</td>
		</tr>
	</table>

</body>
</html>
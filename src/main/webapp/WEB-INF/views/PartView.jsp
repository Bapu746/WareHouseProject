<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="excel?prid=${part.partId }">Export to Excel</a>|<a href="pdf?prid=${part.partId }">Export to PDF</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${part.partId }</td>
		<tr>
			<th>CODE</th>
			<td>${part.partCode }</td>
		</tr>
		<tr>
			<th>WIDTH</th>
			<td>${part.width }</td>
		</tr>
		<tr>
			<th>HEIGHT</th>
			<td>${part.height }</td>
		</tr>
		<tr>
			<th>LENGTH</th>
			<td>${part.length}</td>
		</tr>
		<tr>
		<tr>
			<th>BASE CURRENCY</th>
			<td>${part.baseCurrency}</td>
		</tr>
		<tr>
			<th>DESCRIPTION</th>
			<td>${part.desc}</td>
		</tr>
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="excel?pid=${ob.ordId}">Export to Excel</a>|<a href="pdf?pid=${ob.ordId}" style="color: red">Export To Pdf</a>
	<table border="1">
		<tr>
			<th>ID</th><td>${ob.ordId }</td>
		</tr>
		<tr>
			<th>PURCHASE CODE</th><td>${ob.ordCode }</td>
		</tr>
		<tr>
			<th>REF. NUM</th><td>${ob.refNum }</td>
		</tr>
		<tr>
			<th>QUALITY CHECK</th><td>${ob.qualityCheck }</td>
		</tr>
		<tr>
			<th>DEF. STATUS</th><td>${ob.defStatus }</td>
		</tr>
		<tr>
			<th>DESCRIPTION</th><td>${ob.desc }</td>
		</tr>
	</table>

</body>
</html>
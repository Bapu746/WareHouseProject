<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="excel?uid=${ob.userId}">Export To Excel</a>|<a href="pdf?uid=${ob.userId}">Export To Pdf</a>
	<table border="1">
		<tr>
			<th>ID</th><td>${ob.userId}</td>
		</tr>
		<tr>
			<th>TYPE</th><td>${ob.userType }</td>
		</tr>
		<tr>
			<th>CODE</th><td>${ob.userCode }</td>
		</tr>
		<tr>
			<th>FOR</th><td>${ob.userFor }</td>
		</tr>
		<tr>
			<th>EMAIL</th><td>${ob.userEmail }</td>
		</tr>
		<tr>
			<th>CONTACT</th><td>${ob.userContact }</td>
		</tr>
		<tr>
			<th>ID TYPE</th><td>${ob.userIdType}</td>
		</tr>
		<tr>
			<th>IF OTHER</th><td>${ob.ifOther }</td>
		</tr>
		<tr>
			<th>USER ID NUM</th><td>${ob.userIdNum }</td>
		</tr>
	</table>

</body>
</html>
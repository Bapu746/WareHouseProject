<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
</head>
<body>
		<h3>
			<b>PURCHASE ORDER REGISTRATION PAGE!!!</b>
		</h3>
	<form:form action="update" method="post" modelAttribute="purchaseOrder">
		<pre>
		      Order ID:
                     <form:input type="text" path="ordId"  readonly="true"/>
               Order Code:     
                     <form:input type="text" path="ordCode" />
               Reference Number:
                      <form:input type="text" path="refNum" />
				Quality Check :
				       <form:radiobutton path="qualityCheck"
				value="Required" />Required
		                <form:radiobutton path="qualityCheck"
				value="Not Required" />Not Required 
			    Default Status:
			            <form:input type="text" path="defStatus" readonly="true"  value="OPEN"/>
			    Description:
			            <form:textarea path="desc" />
						<input type="submit" value="Update Order" />
	</pre>
	</form:form>
		<span class="label label-success">${message}</span>

</body>

</html>
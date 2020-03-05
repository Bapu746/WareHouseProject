<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H3 style="color: red; text-align: center">EDIT WHUSER DETAILS!!!!</H3>
	<form:form action="update" method="post" modelAttribute="whUserType">
	    User Id:<form:input type="text" path="userId" readOnly="true"/>
		User Type:<form:radiobutton path="userType" value="Vendor"/>Vendor 
		                   <form:radiobutton path="userType" value="Customer"/>Customer<br>
		 Customer User Code:<form:input type="text" path="userCode"/><br>
		 Used For:<form:input type="text" path="userFor"/><br>
         User Email:<form:input type="email" path="userEmail"/> <br>
         User Contact:<form:input type="tel" path="userContact"/> <br>
		User ID Type:<form:select  path="userIdType">
                                <form:option value="">--select--</form:option>           
                                <form:option value="PAN CARD">PAN CARD</form:option>           
                                <form:option value="AADHAR">AADHAR</form:option>           
                                <form:option value="VOTER ID">VOTER ID</form:option>           
                                <form:option value="OTHER">OTHER</form:option>           
		</form:select><br>
        *IF Other:<form:input type="text" path="ifOther"/><br>
        ID Number:<form:input type="number" path="userIdNum"/><br>
        <input type="submit" value="Update User">

	</form:form>
	${message}

</body>
</html>
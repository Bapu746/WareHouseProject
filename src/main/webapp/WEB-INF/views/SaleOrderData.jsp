<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<c:choose>
		<c:when test="${!empty list }">

			<div class="container">
				<div class="col-lg-1"></div>
				<div class="col-lg-10">
					<table class="table table-bordered table-striped table-hover">
						<thead class=”thead-light”>
							<tr class="table-info">
								<th>ID</th>
								<th>ORDERCODE</th>
								<th>REFNUM</th>
								<th>STOCK MODE</th>
								<th>STOCK SOURCE</th>
								<th>DEF. STATUS</th>
								<th>DESCRIPTION</th>
								<th colspan="4">OPERATION</th>
							</tr>
						</thead>
						<c:forEach items="${list}" var="ob">
							<tbody>
								<tr>

									<td>${ob.ordId}</td>
									<td>${ob.ordCode}</td>
									<td>${ob.refNum}</td>
									<td>${ob.stockMode}</td>
									<td>${ob. stockSource}</td>
									<td>${ob.defStatus}</td>
									<td>${ob.desc}</td>
									<td colspan="4"><a href="delete?slid=${ob.ordId}"
										class="btn btn-info">DELETE</a> <a
										href="edit?slid=${ob.ordId}" class="btn btn-info">EDIT</a> <a
										href="view?slid=${ob.ordId}" class="btn btn-info">VIEW</a></td>

								</tr>
							</tbody>
						</c:forEach>
					</table>
					<div class="row">
						<div class="col-lg-5">
							<a href="excel" class="btn btn-link">Export To Excel</a>
							<a href="pdf" class="btn btn-link">Export To PDF</a>
						</div>
					</div>
				</div>
				<div class="col-lg-1"></div>
			</div>

		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="col-lg-5">
					<H3 class="bg-danger"><b>NO DATA FOUND!!!</b></H3>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<c:if test="${!empty message }">
				<c:choose>
					<c:when test="${opr eq 'DEL'}">
						<div class="card-footer bg-danger text-white text-center"><b>${message }</b></div>
					</c:when>
					<c:otherwise>
						<div class="card-footer bg-info text-white text-center"><b>${message }</b></div>
					
					</c:otherwise>
				</c:choose>
			</c:if>
</body>
</html>
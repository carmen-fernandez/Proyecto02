<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">

<spring:url value="classes/css/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
<spring:url value="classes/css/custom.css" var="custom" />
<link href="${custom}" rel="stylesheet" />

<title>LISTADO DE PROVINCIAS</title>
</head>
<body>
	<div align="center" class="container w-25 p-3">
		<h1>LISTADO DE PROVINCIAS</h1>

		<table class="table table-striped" >
		<thead>
			<tr>
				<th scope="row">ID Provincias</th>
				<th scope="row">Provincias</th>
				
			</tr>
		 </thead>	
		 
		 <tbody>
			<c:forEach var="prov" items="${listaProvincias}">
				<tr>
					<td>${prov.idprovincia}</td>
					<td>${prov.provincia}</td>
					
				</tr>
			</c:forEach>
		</tbody>
		</table>
		
		
		<p>
			<a href="new" class="btn btn-primary"> Nueva Provincia</a> 
			
		</p>
		
		
	</div>
</body>
</html>
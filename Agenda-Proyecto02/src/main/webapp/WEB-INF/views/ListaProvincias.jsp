<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">

<spring:url value="resources/css/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
<spring:url value="resources/css/custom.css" var="custom" />
<link href="${custom}" rel="stylesheet" />

<title>LISTADO DE PROVINCIAS</title>
</head>
<body>
	<div align="center">
		<h1>LISTADO DE PROVINCIAS</h1>

		<table border="1">
			<tr>
				<th>ID Provincias</th>
				<th>Provincias</th>
			</tr>

			<c:forEach var="prov" items="${listaProvincias}">
				<tr>
					<td>${prov.idprovincia}</td>
					<td>${prov.provincia}</td>
				</tr>
			</c:forEach>
			
		</table>
		
		<p>
			<a href="new">Haz clic para crear un NUEVO USUARIO</a> 
			
		</p>
		
	</div>
</body>
</html>
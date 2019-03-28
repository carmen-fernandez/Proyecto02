<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">

<meta charset="UTF-8">



<title>LISTADO DE PERSONAS</title>
</head>
<body style='background-color: #669900;'>
   <br>
	<div align="center" class="container border border-secondary rounded p-3 mb-2 bg-light text-dark"    style="width: 700px;border-color: blue;" >
		<h1 class="font-weight-bolder">LISTADO DE PERSONAS
		&emsp;
			<a href="${pageContext.request.contextPath}/Persona/form2" class="btn btn-primary fas fa-pencil-alt"></a>
		</h1> 

		<table class="table table-striped ">
		<thead>
			<tr class="table">
				<th>ID </th>
				<th>Personas</th>
				<th></th>
				<th></th>
		</tr>
		</thead>

		<tbody>
			<c:forEach var="pers" items="${listaPersonas}">
				<tr>
					<td>${pers.idpersona}</td>
					<td>${pers.nombre}</td>
					<td>${pers.apellido1}</td>
					<td>${pers.apellido2}</td>
					<td>${pers.dni}</td>
					<td><a href="${pageContext.request.contextPath}/Persona/delete/${pers.idpersona}" class="btn btn-danger far fa-trash-alt"></a></td>
					<td><a href="/Persona/modificar?idpersona=${pers.idpersona}" class="btn btn-secondary fa fa-edit"></a></td>
					
				</tr>
			</c:forEach>
		</tbody>	
		</table>
	</div>
<footer class="footer text-light">
<hr>
<p align="center" class="font-italic"> Copyright © 2019 - Grupo 2: Estefania Alvarez, Javier Ramos, Carmen Fernández. </p>
</footer>	
</body>
</html>
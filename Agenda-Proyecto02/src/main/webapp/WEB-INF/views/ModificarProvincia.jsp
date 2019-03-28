<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<meta charset="UTF-8">



<title>MODIFICAR PROVINCIA</title>
</head>

<body style='background-color: #669900;'>
<br>

	<div align="center" class="container border border-secondary rounded p-3 mb-2 bg-light text-dark">
	<br>
		<h1 class="font-weight-bolder">MODIFICAR PROVINCIA</h1>
		<br>
		<h5>Introduce el nuevo nombre de la provincia:</h5>
		
		<table>
			<form:form action="save" modelAttribute="prov">
				<form:hidden path="idprovincia" />
				<form:input style="width: 200px;" class="form-control" path="provincia" />
				<br>
				<a href="${pageContext.request.contextPath}/Provincia" class="btn btn-secondary fas fa-arrow-left"></a>
				&emsp;
				<input type="submit" value="Guardar" class="btn btn-success fas fa-check">
			</form:form>
		</table>
	</div>
<footer class="footer text-light">
<hr>
<p align="center" class="font-italic">Copyright © 2019 - Grupo 2: Estefania Alvarez, Javier Ramos, Carmen Fernández. </p>
</footer>
</body>
</html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<p>Estas son las provincias de la tabla provincia</p>

		<table border="1">
			<tr>
				<th>ID:</th>
				<th>Nombre:</th>
			</tr>

			<c:forEach var="provincia" items="${provinciaList}" varStatus="status">
				<tr>
					<td>${provincia.idprovincia}</td>
					<td>${provincia.provincia}</td>
					<td><a href="edit?id=${user.id}">Modificar</a> | <a
						href="delete?id=${user.id}">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<a href="new">Haz clic para crear una NUEVA PROVINCIA</a> 
		</p>
	</div>
</body>
</html>
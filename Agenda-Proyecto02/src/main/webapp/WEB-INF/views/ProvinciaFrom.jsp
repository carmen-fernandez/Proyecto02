<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

        <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet" />
        <spring:url value="resources/css/custom.css" var="custom"/>
        <link href="${custom}" rel="stylesheet" />  
        
/** Formulario para mostrar provincias */
<title>FORMULARIO DE PROVINCIA</title>
</head>
<body>
	<div align="center">
		<h1>FORMULARIO DE PROVINCIA (add/edit)</h1>
		<table>
			<form:form action="save" method="post" modelAttribute="PROVINCIA">
				<form:hidden path="idprovincia" />
				<tr>
					<td>Nombre Provincia:</td>
					<td><form:input path="provincia" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Guardar Registro"></td>
				</tr>
			</form:form>
		</table>
	</div>

</body>
</html> 
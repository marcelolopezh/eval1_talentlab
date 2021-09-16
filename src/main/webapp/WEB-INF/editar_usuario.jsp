<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Productos Editar</title>
</head>
<body>
	<c:out value="${ error }"></c:out>
    <form:form action="/producto/modificar" method="post" modelAttribute="producto">
		<input type="hidden" name="_method" value="put" >
		<form:hidden path="id"/>

		<form:label path="nombre">Nombre:</form:label>
		<form:input type="text" path="nombre" /><br>

		<form:label path="descripcion">Descripcion:</form:label>
		<form:input type="text" path="descripcion" /><br>

		<form:label path="precio">Precio:</form:label>
		<form:input type="number" path="precio" /><br>

		<form:label path="categoria">Categoría:</form:label>
		<form:input type="text" path="categoria" /><br>

		<input type="submit" value="Modificar">
	</form:form>
</body>

</html>
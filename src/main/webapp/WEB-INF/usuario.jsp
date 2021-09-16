<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Usuarios</title>
</head>
<body>
	<c:out value="${ error }"></c:out>
    <form:form action="/usuario/crear" method="post" modelAttribute="usuario">
        <form:label path="nombre">Nombre:</form:label>
        <form:input type="text" path="nombre" /><br>

        <form:label path="apellido">Apellido:</form:label>
        <form:input type="text" path="apellido" /><br>

        <form:label path="edad">Edad:</form:label>
        <form:input type="number" path="edad" /><br>

        <form:label path="direccion">Dirección:</form:label>
        <form:input type="text" path="direccion" /><br>

        <form:label path="telefono">Teléfono:</form:label>
        <form:input type="text" path="telefono" /><br>

        <input type="submit" value="Crear Usuario">
    </form:form>
    <br>
    <h1>Lista Usuarios</h1>
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Edad</th>
                <th>Dirección</th>
                <th>Teléfono</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>
                        <c:out value="${usuario.nombre}" />
                    </td>
                    <td>
                        <c:out value="${usuario.apellido}" />
                    </td>
                    <td>
                        <c:out value="${usuario.edad}" />
                    </td>
                    <td>
                        <c:out value="${usuario.direccion}" />
                    </td>
                    <td>
                        <c:out value="${usuario.telefono}" />
                    </td>
                    <td> <a href="/usuario/actualizar/${usuario.id}">Editar</a>
                        <form action="/usuario/eliminar/${usuario.id}" method="POST">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>

</html>
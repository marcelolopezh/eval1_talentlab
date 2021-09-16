<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Productos</title>
</head>
<body>
	<c:out value="${ error }"></c:out>
    <form:form action="/producto/crear" method="post" modelAttribute="producto">
        <form:label path="nombre">Nombre:</form:label>
        <form:input type="text" path="nombre" /><br>

        <form:label path="descripcion">Descripcion:</form:label>
        <form:input type="text" path="descripcion" /><br>

        <form:label path="precio">Precio:</form:label>
        <form:input type="number" path="precio" /><br>

        <form:label path="categoria">Categoría:</form:label>
        <form:input type="text" path="categoria" /><br>

        <input type="submit" value="Crear Producto">
    </form:form>
    <br>
    <h1>Lista Produtos</h1>
    <table>
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Categoría</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="producto" items="${productos}">
                <tr>
                    <td>
                        <c:out value="${producto.nombre}" />
                    </td>
                    <td>
                        <c:out value="${producto.descripcion}" />
                    </td>
                    <td>
                        <c:out value="${producto.precio}" />
                    </td>
                    <td>
                        <c:out value="${producto.categoria}" />
                    </td>

                    <td> <a href="/producto/actualizar/${producto.id}">Editar</a>
                        <form action="/producto/eliminar/${producto.id}" method="POST">
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
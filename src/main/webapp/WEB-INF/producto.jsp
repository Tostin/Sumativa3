 
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>PRODUCTO</title>
	</head>
<body>
	<div>
		<form:form action="/producto/crear" method="post" modelAttribute="producto">
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="codigo">codigo:</form:label>
			<form:input type="text" path="codigo"/><br>
			
			<form:label path="valorBase">valorBase:</form:label>
			<form:input type="text" path="valorBase"/><br>

			<input type="submit" value="Crear Producto">
		</form:form>
		<br>
			<hr>
				<h2>Lista de productos</h2>
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>Nombre</th>
						<th>Codigo</th>
						<th>Valor Base</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${lista_productos}" >
					<tr>
						<td><c:out value="${producto.id}" /> </td>
						<td><c:out value="${producto.nombre}" /> </td>
						<td><c:out value="${producto.codigo}" /> </td>
						<td><c:out value="${producto.valorBase}" /> </td>
						<td>
							<a href="/producto/actualizar/${producto.id}">Editar</a>

							<form action="/producto/eliminar" method="POST">
								<input type="hidden" name="id" value="<c:out value="${producto.id}" />" >
								<input type="submit" value="Eliminar">
							</form>
							<form action="/producto/agregarCarro" method="POST">
								<input type="hidden" name="nombre" value="<c:out value="${producto.nombre}" />" >
								<input type="hidden" name="valor Base" value="<c:out value="${producto.valorBase}" />" >
								<input type="submit" value="Agregar a Carro">
							</form>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<hr>
			<a href="/home">Volver a Home</a>
		</div>
</body>
</html>
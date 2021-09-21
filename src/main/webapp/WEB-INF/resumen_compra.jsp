<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resumen de compra</title>
</head>
<body>
	<div>
			<h2>Lista de productos</h2>
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>Nombre</th>
						<th>Codigo</th>
						<th>ValorBase</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${carrito}" >
					<tr>
						<td><c:out value="${producto.id}" /> </td>
						<td><c:out value="${producto.nombre}" /> </td>
						<td><c:out value="${producto.codigo}" /> </td>
						<td><c:out value="${producto.valorBase}" /> </td>
						<td>
							<form action="/producto/eliminarCarro" method="POST">
								<input type="hidden" name="id" value="<c:out value="${producto.id}" />" >
								<input type="submit" value="Eliminar">
							</form>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<h3> <c:out value="${total}" /> </h3>
		</div>

</body>
</html>
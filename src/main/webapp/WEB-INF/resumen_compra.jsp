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
						<th>Nombre</th>
						<th>ValorBase</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${carrito}" >
					<tr>
						<td><c:out value="${producto.key}" /> </td> <!-- key es el primer valor -->
						<td><c:out value="${producto.value}" /> </td> <!--value es el segundo valor -->
						<td>
							<form action="/producto/eliminarCarro" method="POST">
								<input type="hidden" name="nombre" value="<c:out value="${producto.key}" />" >
								<input type="hidden" name="valor Base" value="<c:out value="${producto.value}" />" >
								<input type="submit" value="Eliminar">
							</form>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<br>
			
			<h3> Precio Total: $<c:out value="${Precio_Total}" />.00 </h3>
			<hr>
			<br>	
			<a href="/producto">Volver</a>
		</div>

</body>
</html>
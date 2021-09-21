<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><c:out value="${titulo}"></c:out></title>
</head>
<body>
	<div>
		<h1>Lista de Productos a seleccionar</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Acc1iones</th>
				</tr>		
			</thead>
			<tbody>
				<c:forEach var="producto" items="${lista_productos}" >		
					<tr>
						<td> <c:out value="${producto.id}" /> </td>
						<td> <c:out value="${producto.nombre}" /> </td>
						<td> <c:out value="${producto.valorBase}" /> </td>
						<td>	
							<a href="/venta/actualizar/${producto.id}">Editar</a>
							
							<form action="/producto/eliminar/${producto.id}" method="POST">
								<input type="hidden" name="_method" value="delete" >
								<input type="submit" value="Eliminar">
							</form>
						</td>
					</tr>					
				</c:forEach>		
			</tbody>		
		</table>
		
		<br>
		

		<br>
		<br>
		

	</div>
</body>
</html>
>
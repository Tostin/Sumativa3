<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto editar</title>
</head>
<body>
	<div>		
		<form:form action="/producto/modificar" method="post" modelAttribute="producto">
		
			<input type="hidden" name="_method"  value="put" >
			<form:hidden path="id"/> 
			
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="codigo">codigo:</form:label>
			<form:input type="text" path="codigo"/><br>
			
			<form:label path="valorBase">valorBase:</form:label>
			<form:input type="text" path="valorBase"/><br>
				
			<input  type="submit" value="Modificar Producto">
		</form:form>
	</div>
</body>
</html>
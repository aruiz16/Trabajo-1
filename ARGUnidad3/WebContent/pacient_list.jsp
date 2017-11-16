<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pacient</title>
</head>
<body>
	<table border= "1">
		<tr>
			<th>
			
				<form action="PacientController">
					<input type = "submit" name = "btn_new" value = "New"/>
					<br/>
					<a href="PacientReport">Imprimir Reporte</a>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Nombre</th>
			 <th>Apellidos</th>
			 <th>Sexo</th>
			 <th>Raza</th>
			
		</tr>
		<c:forEach var="pacient" items="${pacients}">
		
		<tr>
			<td>
				<form action= "PacientController">
					<input type = "hidden" name = "id" value= "${pacient.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${pacient.id}</td>
			<td> ${pacient.nombre}</td>
			<td> ${pacient.apellidos}</td>
			<td> ${pacient.sexo}</td>
			<td> ${pacient.raza}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>
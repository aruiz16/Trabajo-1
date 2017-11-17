<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Launch</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="LaunchController">
					<input type = "submit" name = "btn_new" value = "New"/>
					<br/>
					<a href="launchReport">Imprimir Reporte</a>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Name</th>
			 <th>Destination</th>
			 <th>Passengers</th>
			
		</tr>
		<c:forEach var="launch" items="${launches}">
		
		<tr>
			<td>
				<form action= "LaunchController">
					<input type = "hidden" name = "id" value= "${launch.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${launch.id}</td>
			<td> ${launch.name}</td>
			<td> ${launch.destination}</td>
			<td> ${launch.passengers}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>
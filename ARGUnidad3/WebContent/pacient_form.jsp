<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pacient Form</title>
</head>
<body>
	<form action="PacientController">
		<label>Nombre:</label><br>
		<input type = "text" name= "nombre" value = "${pacient.nombre}" /><br>
		
		<label>Apellidos:</label><br>
		<input type = "text" name= "apellidos" value = "${pacient.apellidos}" /><br>
		
		<label>Sexo:</label><br>
		<input type = "text" name= "sexo" value = "${pacient.sexo}" /><br>
		
		<label>Raza:</label><br>
		<input type = "text" name= "raza" value = "${pacient.raza}" /><br>
		
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>
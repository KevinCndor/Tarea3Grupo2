<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body style="background-color: #FAD7A0">
	<form action="informe.jsp" method="GET">
		<fieldset>
			Usuario:
			<!-- Caja de texto-->
		    <input type="text" name="usuario"/><br><br>
		    Contraseña:
		    <!-- Caja de texto tipo Password-->
		    <input type="password" name="contrasenia"/><br><br>
		    <!-- Botón para enviar el formulario-->
		    <input type="submit" name="Iniciar Sesión"/>
		</fieldset>
	</form>
</body>
</html>
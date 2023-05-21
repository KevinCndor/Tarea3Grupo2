<%@page import="java.util.*"%>
<%@page import="logica.Productos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventario</title>
</head>
<body style="background-color: #FAD7A0">
	<h2 style="text-align: center;">Lista de Productos</h2>
	<table style="margin: auto;">
		<thead>
			<tr>
				<b><th style="margin":center;>Código</th></b>
				<b><th style="margin":center;>Nombre</th></b>
				<b><th style="margin":center;>Precio</th></b>
				<b><th style="margin":center;>Distribuidor</th></b>
				<b><th style="margin":center;>Unidades</th></b>
			</tr>
		</thead>
		<tbody>
		<%
		List<Productos> listaProductos = (List) request.getSession().getAttribute("listaProductos");	
		if (listaProductos != null){
			for (Productos producto : listaProductos) {
		            String codigo = producto.getCodigo();
		            String nombre = producto.getNombre();
		            double precio = producto.getPrecio();
		            String distribuidor = producto.getDistribuidor();
		            int unidades = producto.getUnidades();
		            
		            out.println("<tr>");
		            out.println("<td style=\"text-align: center;\">" + codigo + "</td>");
		            out.println("<td style=\"text-align: center;\">" + nombre + "</td>");
		            out.println("<td style=\"text-align: center;\">" + precio + "</td>");
		            out.println("<td style=\"text-align: center;\">" + distribuidor + "</td>");
	           		out.println("<td style=\"text-align: center;\">" + unidades + "</td>");
	        	    out.println("</tr>");
	    	}
		}
		%>
		</tbody>
	</table>
	<form action="SvProductos" method="GET">
		<div align="center">
			<br><button type="submit">Actualizar</button>
		</div>
	</form>
	<br>
	<br>	
	<h2>Resgistro Nuevo Producto</h2>
	<form action="SvProductos" method="POST">
	    <label for="codigo">Código:</label>
	    <input type="text" id="codigo" name="codigo" required><br><br>
	    
	    <label for="nombre">Nombre:</label>
	    <input type="text" id="nombre" name="nombre" required><br><br>
	    
	    <label for="precio">Precio:</label>
	    <input type="number" id="precio" name="precio" step="0.01" required><br><br>
	    
	    <label for="distribuidor">Distribuidor:</label>
	    <input type="text" id="distribuidor" name="distribuidor" required><br><br>
	    
	    <label for="unidades">Unidades:</label>
	    <input type="number" id="unidades" name="unidades" required><br><br>
		<div class="center">
			<button type="submit">Registrar</button>
		</div>
	</form>
	<form action="index.jsp" method="GET">
		<div align="right">
			<button type="submit">Volver</button>
		</div>
	</form>
</body>
</html>
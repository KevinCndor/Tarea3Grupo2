<%@page import="java.util.*"%>
<%@page import="logica.Productos"%>
<%@page import="logica.DetalleVenta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Vender</title>
	<style>
    /* Estilos para el mensaje oculto */
    #mensaje {
      display: none;
      background-color: #e0e0e0;
      padding: 10px;
      margin-top: 10px;
    }
  </style>
</head>
<body style="background-color: #FAD7A0">
	<h2 style="text-align: center;">Lista de Productos</h2>
	<table style="margin: auto;">
		<thead>
			<tr>
				<b><th style="margin":center;>Nombre</th></b>
				<b><th style="margin":center;>Precio</th></b>
				<b><th style="margin":center;>Unidades</th></b>
			</tr>
		</thead>
		<tbody>
		<%
		List<Productos> listaProductos = (List) request.getSession().getAttribute("listaProductos");
		if(listaProductos != null){
			for (Productos producto : listaProductos) {
	            String nombre = producto.getNombre();
	            double precio = producto.getPrecio();
	            int unidades = producto.getUnidades();
	            
	            out.println("<tr>");
	            out.println("<td style=\"text-align: center;\">" + nombre + "</td>");
	            out.println("<td style=\"text-align: center;\">" + precio + "</td>");
	            out.println("<td style=\"text-align: center;\">" + unidades + "</td>");
	            out.println("</tr>");
	       }
		}
		%>
		</tbody>
	</table>
	<br>
	<br>	
	<h2>Agregar Producto</h2>
	<form action="SvDetalleVenta" method="POST">
	    <label for="nombre">Nombre:</label>
	    <input type="text" id="nombre" name="nombre" required><br><br>
	    
	    <label for="cantidad">Cantidad:</label>
	    <input type="text" id="cantidad" name="cantidad" required><br><br>
		<div align="center">
			<button type="submit">Agregar Producto</button>
		</div>
	</form>
	<br>
	<form action="comprobante.jsp" method="POST">
	<label for="cedula">Cedula:</label>
	    <input type="text" id="cedula" name="cedula" required><br><br>
			<div class="left">
				<br><button type="submit">Finalizar Venta</button>
			</div>
	</form>
</body>
</html>
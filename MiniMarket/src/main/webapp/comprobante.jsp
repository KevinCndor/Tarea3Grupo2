<%@page import="logica.DetalleVenta"%>
<%@page import="java.util.*"%>
<%@page import="servlets.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comprobante</title>
</head>
<body style="background-color: #FAD7A0">
	<% 
	String cedula = (String) request.getParameter("cedula");
	%>
	<h3 style="text-align: center;">Comprobante</h3>
	<p style="text-align: center;">.----------------------------------------------------------------------</p>
   	<p style="text-align: center;">Cedula: <%=cedula%></p>
    <table style="margin: auto;">
		<thead>
			<tr>
				<b><th style="margin":center;>Nombre</th></b>
				<b><th style="margin":center;>Precio</th></b>
				<b><th style="margin":center;>Cantidad</th></b>
			</tr>
		</thead>
		<tbody>
		<tr>
	            <td style="text-align: center;">Chocolate  </td>
	            <td style="text-align: center;">1.00  </td>
	            <td style="text-align: center;">2  </td>
	            
	     </tr>
	     <tr>
	            <td style="text-align: center;">Papas  </td>
	            <td style="text-align: center;">0.60  </td>
	            <td style="text-align: center;">2  </td>
	            
	     </tr>
	     <tr>
	            <td style="text-align: center;">CocaCola  </td>
	            <td style="text-align: center;">1.25  </td>
	            <td style="text-align: center;">1  </td>
	            
	     </tr>
		<%-- 
		<%
		SvDetalleVenta svdv = new SvDetalleVenta();
		double total = 0.0;
		List<DetalleVenta> listaDetalleVenta = {};
		if(listaDetalleVenta != null) {
			for (DetalleVenta detalleVenta : listaDetalleVenta) {
	            String nombre = detalleVenta.getNombre();
	            double precio = detalleVenta.getPrecio();
	            int cantidad = detalleVenta.getCantidad();  
	            out.println("<tr>");
	            out.println("<td style=\"text-align: center;\">" + nombre + "</td>");
	            out.println("<td style=\"text-align: center;\">" + precio + "</td>");
	            out.println("<td style=\"text-align: center;\">" + cantidad + "</td>");
	            out.println("</tr>");
	            total += precio * cantidad;
	       }
		}
		%>
		--%>
		</tbody>
	</table>
	<p style="text-align: center;">Total: $3.45</p>
	<!--<p style="text-align: center;">$<%--=total--%></p>-->
   	<p style="text-align: center;" >.----------------------------------------------------------------------</p>
</body>
</html>
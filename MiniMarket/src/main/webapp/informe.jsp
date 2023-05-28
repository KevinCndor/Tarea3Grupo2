<%@page import="org.eclipse.persistence.jpa.jpql.tools.ContentAssistExtension"%>
<%@page import="logica.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informe</title>
</head>
<body style="background-color: #FAD7A0">
	<% 
		Productos p = new Productos();
		Venta v = new Venta();
	    String usuario = request.getParameter("usuario");
	    String contrasena = request.getParameter("contrasenia");
		if(usuario != null && contrasena != null){
			if (usuario.equalsIgnoreCase("admin") && contrasena.equalsIgnoreCase("1234")) {
	            response.sendRedirect("informe.jsp");
	        }else{
	            response.sendRedirect("index.jsp?error=1");
	        }	
		}
	    
	%>
	<h4>REPRESENTACIÓN PORCENTUAL DE LAS VENTAS POR PRODUCTO:</h4>
	<%
		Informe informe = new Informe(p.getListaProd(),v.getListaVentas());
		for(int i = 0; i < informe.getProductosDisponibles().size(); i++){
	        out.print("<p> h" + informe.getProductosDisponibles().get(i).getNombre() + informe.getPorcentajeVentaProductos().get(i) + "</p>");
	        
	        for(int j = 1; j <= informe.getPorcentajeVentaProductos().get(i); j++){
	            if(j % 10 == 0){
	                out.print("<br>");
	            }
	        }
	        out.print("<p>" + informe.getPorcentajeVentaProductos().get(i) + "% </p>");
	    }
		out.println("<p>Total Vendido:" + informe.totalVendido+ "</p>");
	%>
</body>
</html>
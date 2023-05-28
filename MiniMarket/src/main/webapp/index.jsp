<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String error = request.getParameter("error");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SISTEMA DE GESTIÓN DE INVENTARIO PARA UN MINIMARKET</title>
</head>
<body style="background-color: #FAD7A0">
	<table style="margin: auto;">
        <tr>
            <td colspan="2" style="height: 20vh;"></td>
        </tr>
		<table style="width: 20%; margin: auto;">
			<tr>
                <td colspan="2" style="text-align: center;">
                     <h1>MiniMarket</h1>
                </td>
            </tr>
		    <tr>
		        <td>
		            <div style="margin-bottom:45px;">
		                Venta de Productos
		            </div>
		        </td>
		        <form action="venta.jsp" method="GET">
		            <td>
		            	<div style="margin-bottom: 45px;">
			            	<button>Seleccionar</button></td>
			            </div>
		        </form>
		    </tr>
		    <tr>
		        <td>
		            <div style="margin-bottom: 45px;">
		                Inventario
		            </div>
		        </td>
		        <form action="SvProductos" method="GET">
		            <td>
		            	<div style="margin-bottom: 45px;">
		            		<button>Seleccionar</button></td>
		            	</div>
		        </form>
		    </tr>
		    <tr>
		        <td>     	
		            <div style="margin-bottom: 45px;">
		                Generar Informe
		                </form>
		        		<% 
		        		if(error!=null){
		        			if (error.equalsIgnoreCase("1")){
			        			out.print("<font color = \"red\">Credenciales incorrectas</font>");
			        		}
		        		}
		       			%>
		            </div>
		        </td>
		        <form action="login.jsp" method="POST">
		            <td>
		            	<div style="margin-bottom: 45px;">
		            		<button>Seleccionar</button></td>
		            	</div>
		        
		    </tr>
		</table>
		<tr>
            <td colspan="2" style="height: 15vh;"></td>
        </tr>
    </table>
</body>
</html>
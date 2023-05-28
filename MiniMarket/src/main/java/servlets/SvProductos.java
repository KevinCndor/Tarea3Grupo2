/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.ControladoraProductos;
import logica.Productos;

@WebServlet(name = "SvProductos", urlPatterns = { "/SvProductos" })
public class SvProductos extends HttpServlet {

	ControladoraProductos controlP = new ControladoraProductos();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Productos> listaProductos = new ArrayList<>();
		listaProductos = controlP.traerProductos();

		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaProductos", listaProductos);

		response.sendRedirect("inventario.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		double precio = Double.parseDouble(request.getParameter("precio"));
		String distribuidor = request.getParameter("distribuidor");
		int unidades = Integer.parseInt(request.getParameter("unidades"));
		//

		Productos producto = new Productos();
		producto.setCodigo(codigo);
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		producto.setDistribuidor(distribuidor);
		producto.setUnidades(unidades);
		producto.setListaProd(producto);
		
		controlP.crearProducto(producto);
		response.sendRedirect("inventario.jsp");
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}

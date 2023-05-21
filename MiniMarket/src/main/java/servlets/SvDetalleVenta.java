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
import logica.DetalleVenta;
import logica.Productos;
import persistencia.DetalleVentaJpaController;

@WebServlet(name = "SvDetalleVenta", urlPatterns = { "/SvDetalleVenta" })
public class SvDetalleVenta extends HttpServlet {

	DetalleVentaJpaController controlDetVenta = new DetalleVentaJpaController();
	ControladoraProductos controlP = new ControladoraProductos();
	private List<DetalleVenta> listaDetalleVenta;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<DetalleVenta> listaDetalleVenta = new ArrayList<>();
		listaDetalleVenta = controlDetVenta.findDetalleVentaEntities();

		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaDetalleVenta", listaDetalleVenta);

		List<Productos> listaProductos = new ArrayList<>();
		listaProductos = controlP.traerProductos();

		misesion.setAttribute("listaProductos", listaProductos);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio = 0.0;
		List<Productos> listaProductos = (List) request.getSession().getAttribute("listaProductos");
		if (listaProductos != null) {
			for (Productos producto : listaProductos) {
				if (producto.getNombre().equalsIgnoreCase(nombre)) {
					precio = producto.getPrecio();
				}
			}
		}

		DetalleVenta detVenta = new DetalleVenta();
		detVenta.setNombre(nombre);
		detVenta.setPrecio(precio);
		detVenta.setCantidad(cantidad);
		listaDetalleVenta = controlDetVenta.listaDetVenta;
		controlDetVenta.create(detVenta);
		response.sendRedirect("venta.jsp");
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}

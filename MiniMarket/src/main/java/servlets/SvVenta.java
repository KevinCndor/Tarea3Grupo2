/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.*;
import persistencia.*;
import persistencia.exceptions.NonexistentEntityException;

@WebServlet(name = "SvVenta", urlPatterns = { "/SvVenta" })
public class SvVenta extends HttpServlet {

	ControladoraPersistenciaVenta controlV = new ControladoraPersistenciaVenta();
	DetalleVentaJpaController jpaDetV = new DetalleVentaJpaController();
	DetalleVenta dv = new DetalleVenta();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Venta> listaVenta = new ArrayList<>();
		listaVenta = controlV.traerVentas();

		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaVenta", listaVenta);

		List<DetalleVenta> listaDetalleVentas = new ArrayList<>();
		listaDetalleVentas = jpaDetV.findDetalleVentaEntities();

		misesion.setAttribute("listaDetalleVentas", listaDetalleVentas);
		
		response.sendRedirect("comprobante.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cedula = request.getParameter("cedula");
		

		Venta venta = new Venta();
		venta.setCiCliente(cedula);
		venta.setFecha(LocalDate.now().toString());
		venta.setListaVentas(venta);
		controlV.crearVenta(venta);
		response.sendRedirect("comprobante.jsp");
		
		/*
		if (dv.getListaDetalles() != null) {
			for (int i = 0 ; i < dv.getListaDetalles().size() ; i++) {
				try {
					jpaDetV.destroy(i);
				} catch (NonexistentEntityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}

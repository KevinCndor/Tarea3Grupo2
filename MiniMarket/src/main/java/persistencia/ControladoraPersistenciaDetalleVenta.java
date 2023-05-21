/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;

import logica.DetalleVenta;

public class ControladoraPersistenciaDetalleVenta {
	// ***
	DetalleVentaJpaController detVentaJpa = new DetalleVentaJpaController();

	// CREATE
	public void crearDetalleVenta(DetalleVenta detVenta) {
		detVentaJpa.create(detVenta);

	}

	// READ
	public List<DetalleVenta> traerDetalleVenta() {
		return detVentaJpa.findDetalleVentaEntities();
	}
}

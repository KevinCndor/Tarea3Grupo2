/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;

import logica.Venta;

public class ControladoraPersistenciaVenta {
	// ***
	VentaJpaController ventaJpa = new VentaJpaController();

	// CREATE
	public void crearVenta(Venta venta) {
		ventaJpa.create(venta);

	}

	// READ
	public List<Venta> traerVentas() {
		return ventaJpa.findVentaEntities();
	}
}

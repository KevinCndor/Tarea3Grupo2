
package logica;

import java.util.List;

import persistencia.ControladoraPersistenciaDetalleVenta;

public class ControladoraDetalleVenta {

	ControladoraPersistenciaDetalleVenta controlPersisDetVenta = new ControladoraPersistenciaDetalleVenta();

	public void crearDetalleVenta(DetalleVenta detVenta) {
		controlPersisDetVenta.crearDetalleVenta(detVenta);
	}

	public List<DetalleVenta> traerDetalleVenta() {
		return controlPersisDetVenta.traerDetalleVenta();
	}

}

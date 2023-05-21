
package logica;

import java.util.List;

import persistencia.ControladoraPersistenciaProd;

public class ControladoraProductos {

	ControladoraPersistenciaProd controlPersisP = new ControladoraPersistenciaProd();

	public void crearProducto(Productos producto) {
		controlPersisP.crearProducto(producto);
	}

	public List<Productos> traerProductos() {
		return controlPersisP.traerProductos();
	}

}

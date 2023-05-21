/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;

import logica.Productos;

public class ControladoraPersistenciaProd {
	// ***
	ProdJpaController prodJpa = new ProdJpaController();

	// CREATE
	public void crearProducto(Productos usu) {
		prodJpa.create(usu);

	}

	// READ
	public List<Productos> traerProductos() {
		return prodJpa.findProductoEntities();
	}
}

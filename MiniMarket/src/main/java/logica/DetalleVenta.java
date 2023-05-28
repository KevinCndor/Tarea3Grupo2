
package logica;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DetalleVenta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nombre;
	private double precio;
	private int cantidad;
	ArrayList<DetalleVenta> listaDetalles = new ArrayList<>();
	
	public DetalleVenta() {
	}
	
	public DetalleVenta(String nombre, double precio, int cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public DetalleVenta(int id, String nombre, double precio, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setListaDetalles(DetalleVenta detVenta) {
		this.listaDetalles.add(detVenta);
	}
	
	public ArrayList<DetalleVenta> getListaDetalles() {
		return listaDetalles;
	}

	public void calcularTotal (){
	    double total = 0;
	    for (DetalleVenta detallesVenta : listaDetalles){
	    	total += (detallesVenta.getPrecio() * detallesVenta.getCantidad());
	    }
	}

}

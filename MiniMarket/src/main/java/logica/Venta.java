
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import java.util.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String ciCliente;
	private String fecha;
	private ArrayList<Venta> listaVentas = new ArrayList<>();
	double total = 0;
	
	public Venta(int id, String ciCliente, String fecha, double total) {
		super();
		this.id = id;
		this.ciCliente = ciCliente;
		this.fecha = fecha;
		this.total = total;
	}

	public Venta() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCiCliente() {
		return ciCliente;
	}

	public void setCiCliente(String ciCliente) {
		this.ciCliente = ciCliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<Venta> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(Venta ventas) {
		this.listaVentas.add(ventas);
	}
	
}

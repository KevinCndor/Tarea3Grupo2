package logica;

import java.util.ArrayList;


public class Informe {
    public ArrayList<Double> porcentajeVentaProductos = new ArrayList<>();
    private ArrayList<Venta> ventas = new ArrayList<>();
    private DetalleVenta detalleVenta = new DetalleVenta();
    public double totalVendido;
    public ArrayList<DetalleVenta> productosDisponibles = new ArrayList<>();
    
    public Informe() {
    }
    
    public ArrayList<Double> getPorcentajeVentaProductos() {
		return porcentajeVentaProductos;
	}

	public void setPorcentajeVentaProductos(ArrayList<Double> porcentajeVentaProductos) {
		this.porcentajeVentaProductos = porcentajeVentaProductos;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public ArrayList<DetalleVenta> getProductosDisponibles() {
		return productosDisponibles;
	}

	public void setProductosDisponibles(ArrayList<DetalleVenta> productosDisponibles) {
		this.productosDisponibles = productosDisponibles;
	}

	public Informe(ArrayList<Productos> productos, ArrayList<Venta> ventas){
        this.ventas = ventas;
        for(Productos p : productos){
            this.productosDisponibles.add(new DetalleVenta(p.getNombre(), p.getPrecio(),0));
        }
    }
    
    private void almacenarDetallesVenta(){
        ArrayList<DetalleVenta> totalProductos = new ArrayList();
        
        for(Venta v : ventas){
            for(DetalleVenta dv : detalleVenta.getListaDetalles()){
                totalProductos.add(dv);
            }
        }

        actualizarCantidad(totalProductos);
    }

	private void actualizarCantidad(ArrayList<DetalleVenta> totalProductos) {
		for(int i = 0; i < productosDisponibles.size(); i++){
            for(int j = 0; j < totalProductos.size(); j++){
                if(productosDisponibles.get(i).getNombre() == totalProductos.get(j).getNombre()){
                    productosDisponibles.get(i).setCantidad(productosDisponibles.get(i).getCantidad() + totalProductos.get(j).getCantidad());
                }            
            }
        }
	}
    
    private void calcularPorcentajesVenta(){
        almacenarDetallesVenta();
        int counter = 0;
        for(DetalleVenta dv : productosDisponibles){
            porcentajeVentaProductos.add(dv.getPrecio() * dv.getCantidad());
            totalVendido += porcentajeVentaProductos.get(counter++);
        }
        
        for(int i = 0; i < porcentajeVentaProductos.size(); i++){
            porcentajeVentaProductos.set(i, porcentajeVentaProductos.get(i) / totalVendido * 100);
        }
    }
    
    public void graficoResumen(){
        calcularPorcentajesVenta();
        System.out.println("REPRESENTACIÓN PORCENTUAL DE LAS VENTAS POR PRODUCTO:");
        
        for(int i = 0; i < productosDisponibles.size(); i++){
            System.out.printf("%s(%.2f):\n", productosDisponibles.get(i).getNombre(), porcentajeVentaProductos.get(i));
            
            for(int j = 1; j <= porcentajeVentaProductos.get(i); j++){
            //    System.out.print("*");
                if(j % 10 == 0){
                    System.out.println();
                }
            }
            System.out.println("\n" + porcentajeVentaProductos.get(i) + "%.\n");
        }
        System.out.println("Total Vendido:" + totalVendido);
    }
}

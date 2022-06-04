package utn.edu.ar.redlink.dominio.productos;

import java.util.HashMap;
import java.util.Map;

import utn.edu.ar.redlink.dominio.promociones.Promocion;

public class ProductoCarrito {
	private Producto prodAsociado;
	private int cantidad;
	private Map<Promocion,Double> descuentos;
	
	//Guardo en el map la promocion usada y el resultado de aplicar la promocion al producto
	public void hacerDescuento(Promocion unaPromocion){
		this.descuentos.put(unaPromocion, unaPromocion.aplicarPromocion(prodAsociado));
	}
	
	// A partir del precio del producto asociado, resto cada uno de los descuentos
	//individuales y retorno el resultado de esas restas
	public double miCosto() {
		double resultado = prodAsociado.getPrecio();
		for(double valor : descuentos.values()) {
			resultado = resultado-valor;
		}
		return resultado*cantidad;
	}
	
	public ProductoCarrito(Producto prodAsociado, int cantidad) {
		super();
		this.prodAsociado = prodAsociado;
		this.cantidad = cantidad;
		this.descuentos = new HashMap<Promocion,Double>();
	}
	
	/*
	--------------------------------------
	  Getters y Setters
	 -------------------------------------
	*/
	public Producto getProdAsociado() {
		return prodAsociado;
	}

	public void setProdAsociado(Producto prodAsociado) {
		this.prodAsociado = prodAsociado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Map<Promocion,Double> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(Map<Promocion,Double> descuentos) {
		this.descuentos = descuentos;
	}
	
	
}

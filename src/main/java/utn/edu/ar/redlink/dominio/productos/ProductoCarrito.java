package utn.edu.ar.redlink.dominio.productos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import utn.edu.ar.redlink.dominio.promociones.Promocion;

@Entity
public class ProductoCarrito {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long idcarrito;
	@ManyToOne
	private Producto prodAsociado;
	@Min(0)
	private int cantidad;
	@ElementCollection
	private List<Double> descuentos;
	
	//Guardo en el map la promocion usada y el resultado de aplicar la promocion al producto
	public void hacerDescuento(Promocion unaPromocion){
		this.descuentos.add(unaPromocion.aplicarPromocion(prodAsociado));
	}
	
	// A partir del precio del producto asociado, resto cada uno de los descuentos
	//individuales y retorno el resultado de esas restas
	public double miCosto() {
		double resultado = prodAsociado.getPrecio();
		for(double valor : descuentos) {
			resultado = resultado-valor;
		}
		return (double)resultado*cantidad;
	}
	
	public ProductoCarrito() {
		super();
	}
	
	public ProductoCarrito(Producto prodAsociado, int cantidad) {
		super();
		this.prodAsociado = prodAsociado;
		this.cantidad = cantidad;
		this.descuentos = new ArrayList<Double>();
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
	
	
}

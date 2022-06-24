package utn.edu.ar.redlink.dominio.promociones;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import utn.edu.ar.redlink.dominio.productos.Producto;

@Entity
public class Membresia implements Promocion{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int idMemb;
	private double descuento;
	private int nivel;
	
	@Override
	public double aplicarPromocion(Producto unProducto){
		return unProducto.getPrecio() * this.descuento;
	}
	
	public Membresia() {
		super();
	}
	
	public Membresia(double d, int nivel) {
		this.descuento= d;
		this.nivel = nivel;
	}

	/*
	--------------------------------------
	  Getters y Setters
	 -------------------------------------
	*/
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
}

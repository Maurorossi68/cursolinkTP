package utn.edu.ar.redlink.dominio.promociones;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import utn.edu.ar.redlink.dominio.productos.Producto;

@Entity
public class MedioDePago implements Promocion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int idMP;
	@NotBlank
	private String nombre;
	private double descuento;
	
	@Override
	public double aplicarPromocion(Producto unProducto){
		return unProducto.getPrecio() * this.descuento;
	}
	
	public MedioDePago(){
		super();
	}
	
	public MedioDePago(String nombre,double valorDescuento) {
		this.nombre=nombre;
		this.descuento=valorDescuento;	
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

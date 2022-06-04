package utn.edu.ar.redlink.dominio.promociones;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import utn.edu.ar.redlink.dominio.productos.Producto;
import utn.edu.ar.redlink.dominio.productos.Proveedor;

@Entity
public class Cupon implements Promocion {
	@NotBlank
	private double descuento;
	@Id
	private int codigo;
	private boolean validez;
	@ManyToOne
	private Proveedor elProveedor;

	public Cupon(){
		super();
	}
	
	public Cupon(double valorDesc, int codigo, Proveedor elProveedor) {
		this.descuento = valorDesc;
		this.codigo = codigo;
		this.validez = true; //Se define como true ya que se acaba de crear
		this.elProveedor = elProveedor;
	}
	
	@Override
	public double aplicarPromocion(Producto unProducto){
		if(this.elProveedor == unProducto.getMiProveedor() && this.isValidez()) {
			this.setValidez(false);
			return unProducto.getPrecio() * this.descuento;
		}else {
			return (double) 0; //TODO agregar excepcion
		}
		
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isValidez() {
		return validez;
	}

	public void setValidez(boolean validez) {
		this.validez = validez;
	}
	
	
}

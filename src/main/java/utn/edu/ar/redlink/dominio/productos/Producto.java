package utn.edu.ar.redlink.dominio.productos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import utn.edu.ar.redlink.dominio.usuarios.Vendedor;

//Siempre usar la Entity de javax
@Entity
public class Producto {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)//Asigno el ID y lo hago autoincremental
	private Integer idProd;
	
	@NotBlank
	private String descripcion;
	
	private float precio;
	
	@Min(0)
	private int stock;
	@OneToOne
	private Proveedor miProveedor;
	@OneToOne
	private Vendedor miVendedor;
	
	public Producto() { //Es necesario para la base de datos
		super();
	}
	
	public Producto(String descripcion, float precio, int stock, 
			Proveedor miProveedor,Vendedor miVendedor) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.miProveedor = miProveedor;
		this.miVendedor = miVendedor;
	}

	/*
	--------------------------------------
	  Getters y Setters
	 -------------------------------------
	*/
	public int getCodProd() {
		return idProd;
	}

	public void setCodProd(int codProd) {
		this.idProd = codProd;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Proveedor getMiProveedor() {
		return miProveedor;
	}

	public void setMiProveedor(Proveedor miProveedor) {
		this.miProveedor = miProveedor;
	}

	public Vendedor getMiVendedor() {
		return miVendedor;
	}

	public void setMiVendedor(Vendedor miVendedor) {
		this.miVendedor = miVendedor;
	}
	
	
}

package utn.edu.ar.redlink.dominio.productos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import utn.edu.ar.redlink.dominio.usuarios.Vendedor;

//Siempre usar la Entity de javax
@Entity
@Table(name="producto")
public class Producto {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)//Asigno el ID y lo hago autoincremental
	private Integer idprod;
	
	@NotBlank
	private String descripcion;
	
	private double precio;
	
	@Min(0)
	private int stock;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_prov")
	private Proveedor miProveedor;
	@ManyToOne(cascade=CascadeType.ALL)
	private Vendedor miVendedor;
	
	public Producto() { //Es necesario para la base de datos
		super();
	}
	
	public Producto(String descripcion, double precio, int stock, 
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


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
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

	public Integer getIdprod() {
		return idprod;
	}

	public void setIdprod(Integer idprod) {
		this.idprod = idprod;
	}
	
	
}

package utn.edu.ar.redlink.dominio.usuarios;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import utn.edu.ar.redlink.dominio.productos.Producto;
import utn.edu.ar.redlink.dominio.productos.Proveedor;

@Entity
public class Vendedor implements Usuario {
	@NotBlank
	private String nombre;
	@Id
	private int dni;
	private int telefono;
	@OneToMany
	private List<Proveedor> misProveedores;
	@OneToMany
	private List<Producto> prodAlaVenta;
	
	public Vendedor() {
		super();
	}
	
	public Vendedor(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Vendedor(String nombre, int dni, int telefono, List<Proveedor> misProveedores, List<Producto> prodAlaVenta) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.misProveedores = misProveedores;
		this.prodAlaVenta = prodAlaVenta;
	}

	@Override
	public void login() {
		//TODO
	}
	
	@Override
	public void cerrarSesion() {
		//TODO
	}
	/*
	--------------------------------------
	  Getters y Setters
	 -------------------------------------
	*/
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Proveedor> getMisProveedores() {
		return misProveedores;
	}

	public void setMisProveedores(List<Proveedor> misProveedores) {
		this.misProveedores = misProveedores;
	}

	public List<Producto> getProdAlaVenta() {
		return prodAlaVenta;
	}

	public void setProdAlaVenta(List<Producto> prodAlaVenta) {
		this.prodAlaVenta = prodAlaVenta;
	}
	
	
	
}

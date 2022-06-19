package utn.edu.ar.redlink.dominio.productos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="proveedor")
public class Proveedor {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int idProv;
	@NotBlank
	private String nombre;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Producto> misProductos;
	
	public Proveedor() {
		super();
	}
	
	public Proveedor(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Proveedor(String nombre, List<Producto> misProductos) {
		super();
		this.nombre = nombre;
		this.misProductos = misProductos;
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

	public List<Producto> getMisProductos() {
		return misProductos;
	}

	public void setMisProductos(List<Producto> misProductos) {
		this.misProductos = misProductos;
	}
	
	
}

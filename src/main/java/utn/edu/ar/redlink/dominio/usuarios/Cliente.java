package utn.edu.ar.redlink.dominio.usuarios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import utn.edu.ar.redlink.dominio.productos.Orden;
import utn.edu.ar.redlink.dominio.productos.Producto;
import utn.edu.ar.redlink.dominio.productos.ProductoCarrito;
import utn.edu.ar.redlink.dominio.promociones.Cupon;
import utn.edu.ar.redlink.dominio.promociones.MedioDePago;
import utn.edu.ar.redlink.dominio.promociones.Membresia;
import utn.edu.ar.redlink.dominio.promociones.Promocion;

@Entity
public class Cliente implements Usuario {

	@NotBlank
	private String nombre;
	@Id
	private int dni;
	@JsonIgnore
	private String contrasenia;
	private int telefono;
	@OneToMany
	private List<ProductoCarrito> carrito;
	@OneToMany
	@JsonIgnore
	private List<Orden> ordenesHechas;
	@OneToMany
	private List<Cupon> misCupones;
	@ManyToOne
	private Membresia miMembresia;
	
	public Orden comprar(MedioDePago pago) {
		usarPromociones(pago);
		double total = this.obtenerCostoCarrito();
		//TODO: Agregar forma de pago
		Orden estaOrden = new Orden(carrito, this, total, pago);
		ordenesHechas.add(estaOrden);
		this.getCarrito().clear();
		return estaOrden;
	}
	//Comentario para push a heroku
	private void usarPromociones(MedioDePago pago) {
		if(!this.getMisCupones().isEmpty()) {
			for(Cupon unCupon : misCupones) {
				usarUnaPromo(unCupon);
			}
		}
		if(this.getMiMembresia() != null) {
			usarUnaPromo(this.getMiMembresia());
		}
		if(pago != null) {
			usarUnaPromo(pago);
		}
		
	}
	
	//Calculo un total a partir unicamente de los cupones activos que tengo
	private void usarUnaPromo(Promocion promo) {
		for(ProductoCarrito prod : carrito) {
				prod.hacerDescuento(promo);
		}
	}
		
	public double obtenerCostoCarrito() {
		double total = 0;
		for(ProductoCarrito prod: this.getCarrito()) {
			total = total + prod.miCosto();
		}
		System.out.print(total);
		return total;
	}
	
	public void agregarACarrito(Producto algo, int cantidad) {
		this.getCarrito().add(new ProductoCarrito(algo, cantidad));
		System.out.println(this.getCarrito().get(0).miCosto());
	}
	
	@Override
	public void login() {
		//TODO
	}
	
	@Override
	public void cerrarSesion() {
		//TODO
	}
	
	public Cliente() {
		super();
		this.carrito = new ArrayList<ProductoCarrito>();
		this.misCupones = new ArrayList<Cupon>();
		this.ordenesHechas = new ArrayList<Orden>();
	}
	
	public Cliente(int dni, String nombre, int telefono, String contrasenia) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.contrasenia = contrasenia;
		this.carrito = new ArrayList<ProductoCarrito>();
		this.misCupones = new ArrayList<Cupon>();
		this.ordenesHechas = new ArrayList<Orden>();
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

	public List<ProductoCarrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<ProductoCarrito> carrito) {
		this.carrito = carrito;
	}

	public List<Cupon> getMisCupones() {
		return misCupones;
	}

	public void setMisCupones(List<Cupon> misCupones) {
		this.misCupones = misCupones;
	}

	public List<Orden> getOrdenesHechas() {
		return ordenesHechas;
	}

	public void setOrdenesHechas(List<Orden> ordenesHechas) {
		this.ordenesHechas = ordenesHechas;
	}

	public Membresia getMiMembresia() {
		return miMembresia;
	}

	public void setMiMembresia(Membresia miMembresia) {
		this.miMembresia = miMembresia;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
}

package utn.edu.ar.redlink.dominio.productos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import utn.edu.ar.redlink.dominio.promociones.Cupon;
import utn.edu.ar.redlink.dominio.promociones.MedioDePago;
import utn.edu.ar.redlink.dominio.promociones.Membresia;
import utn.edu.ar.redlink.dominio.usuarios.Cliente;

@Entity
public class Orden {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int idOrden;
	@Transient
	private final List<ProductoCarrito> lista;
	private double precioTotal;
	@OneToOne
	private Cliente comprador;
	@OneToMany
	private List<Cupon> cupones;
	@OneToOne
	private Membresia membresiaUsada;
	@OneToOne
	private MedioDePago formaDePago;
	
	/*
	--------------------------------------
	  Constructores
	 -------------------------------------
	*/	
	
	public Orden() {
		super();
		this.lista = new ArrayList<ProductoCarrito>();
		this.cupones = new ArrayList<Cupon>();
	}
	
	public Orden(List<ProductoCarrito> lista, Cliente comprador, double total, MedioDePago pagadoCon) {
		super();
		this.lista = lista;
		this.precioTotal = total;
		this.comprador = comprador;
		this.membresiaUsada = comprador.getMiMembresia();
		this.formaDePago = pagadoCon;
	}

	/*
	--------------------------------------
	  Getters y Setters
	 -------------------------------------
	*/	
	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public List<ProductoCarrito> getLista() {
		return lista;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public List<Cupon> getCupones() {
		return cupones;
	}

	public void setCupones(List<Cupon> cupones) {
		this.cupones = cupones;
	}

	public Membresia getMembresiaUsada() {
		return membresiaUsada;
	}

	public void setMembresiaUsada(Membresia membresiaUsada) {
		this.membresiaUsada = membresiaUsada;
	}

	public MedioDePago getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(MedioDePago formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	
	
}

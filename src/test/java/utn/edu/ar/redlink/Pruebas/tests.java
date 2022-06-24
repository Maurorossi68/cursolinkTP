package utn.edu.ar.redlink.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import utn.edu.ar.redlink.dominio.productos.Producto;
import utn.edu.ar.redlink.dominio.productos.Proveedor;
import utn.edu.ar.redlink.dominio.promociones.Cupon;
import utn.edu.ar.redlink.dominio.promociones.MedioDePago;
import utn.edu.ar.redlink.dominio.promociones.Membresia;
import utn.edu.ar.redlink.dominio.usuarios.Cliente;
import utn.edu.ar.redlink.dominio.usuarios.Vendedor;

class Compra {

	Cliente unCliente = new Cliente(41835967, "Mauro", 1134213697,"root");
	Vendedor unVendedor = new Vendedor("Juan", 1157640493);
	Proveedor unProveedor = new Proveedor("CocaColaCompany");
	Producto unProducto = new Producto("Coca500ml", 140,10,unProveedor, unVendedor);

	Membresia unaMembresia = new Membresia(0.25,1);
	MedioDePago efectivo = new MedioDePago("visa",0.2);
	Cupon unCupon = new Cupon(0.3,122 ,unProveedor);

	@Before
	void unir() {
		unVendedor.getMisProveedores().add(unProveedor);
		unVendedor.getProdAlaVenta().add(unProducto);
		unProveedor.getMisProductos().add(unProducto);
	}

	@Test
	void clienteTieneProductos() {
		unCliente.agregarACarrito(unProducto, 3);
		assertEquals(1,unCliente.getCarrito().size());
	}
	@Test
	void CompraSinDescuento() {
		unCliente.agregarACarrito(unProducto, 3);
		assertEquals(420.0,unCliente.obtenerCostoCarrito());
	}

	@Test
	void ComprarConMembresia() {
		unCliente.setMiMembresia(unaMembresia);
		unCliente.agregarACarrito(unProducto, 3);
		assertEquals(315,unCliente.comprar(efectivo).getPrecioTotal());
	}

	@Test
	void ComprarConCupon() {
		unCliente.agregarACarrito(unProducto, 3);
		assertEquals(336,unCliente.comprar(efectivo).getPrecioTotal());
	}
}
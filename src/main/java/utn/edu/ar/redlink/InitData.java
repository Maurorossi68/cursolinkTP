package utn.edu.ar.redlink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import utn.edu.ar.redlink.dominio.productos.Orden;
import utn.edu.ar.redlink.dominio.productos.Producto;
import utn.edu.ar.redlink.dominio.productos.Proveedor;
import utn.edu.ar.redlink.dominio.promociones.Cupon;
import utn.edu.ar.redlink.dominio.promociones.MedioDePago;
import utn.edu.ar.redlink.dominio.promociones.Membresia;
import utn.edu.ar.redlink.dominio.usuarios.Cliente;
import utn.edu.ar.redlink.dominio.usuarios.Vendedor;
import utn.edu.ar.redlink.repositorios.RepoClientes;
import utn.edu.ar.redlink.repositorios.RepoCupones;
import utn.edu.ar.redlink.repositorios.RepoMediosDePago;
import utn.edu.ar.redlink.repositorios.RepoMembresias;
import utn.edu.ar.redlink.repositorios.RepoOrdenes;
import utn.edu.ar.redlink.repositorios.RepoProductoSpring;
import utn.edu.ar.redlink.repositorios.RepoProvSpring;
import utn.edu.ar.redlink.repositorios.RepoVendedor;

@Component
public class InitData implements CommandLineRunner {
	//Agrego todos los repos por si quiero inicializar algo
	@Autowired
	RepoClientes repoClientes;
	@Autowired
	RepoCupones repoCupones;
	@Autowired
	RepoMediosDePago repoMP;
	@Autowired
	RepoMembresias repoM;
	@Autowired
	RepoOrdenes repoOrdenes;
	@Autowired
	RepoProductoSpring repoProductos;
	@Autowired
	RepoProvSpring repoProveedores;
	@Autowired
	RepoVendedor repoVendedores;
	@Autowired
	RepositoryRestConfiguration config;
	
	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Producto.class, Proveedor.class,Cliente.class,Cupon.class,Vendedor.class,Orden.class);
		//Membresia Lv1
		repoM.save(new Membresia(0,1));
		//Membresia Lv2
		repoM.save(new Membresia(0.20,2));
	
		//Medio de Pago Visa
		repoMP.save(new MedioDePago("visa",0.2));
		//Medio De Pago MasterCard
		repoMP.save(new MedioDePago("mastercard", 0.15));
		
		//Un cliente base
		repoClientes.save(new Cliente(41835967, "root",122,"root"));
	}

}

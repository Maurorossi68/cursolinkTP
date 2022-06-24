package utn.edu.ar.redlink.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import utn.edu.ar.redlink.dominio.productos.Orden;
import utn.edu.ar.redlink.dominio.productos.Producto;
import utn.edu.ar.redlink.dominio.productos.ProductoCarrito;
import utn.edu.ar.redlink.dominio.promociones.MedioDePago;
import utn.edu.ar.redlink.dominio.usuarios.Cliente;
import utn.edu.ar.redlink.repositorios.RepoClientes;
import utn.edu.ar.redlink.repositorios.RepoMediosDePago;
import utn.edu.ar.redlink.repositorios.RepoOrdenes;
import utn.edu.ar.redlink.repositorios.RepoProdCarrito;
import utn.edu.ar.redlink.repositorios.RepoProductoSpring;

@RestController
public class ClienteController {

	@Autowired
	RepoClientes repo;
	@Autowired
	RepoProductoSpring repoProductos;
	@Autowired
	RepoOrdenes repoOrdenes;
	@Autowired
	RepoMediosDePago repoMDP;
	@Autowired
	RepoProdCarrito repoUnidadCarrito;
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	@PostMapping(path="/comprar")
	public Orden comprar(@RequestBody String body) throws JsonMappingException, JsonProcessingException {
		final JsonNode todoElJSON = mapper.readTree(body);
		int dni = todoElJSON.findValue("dni").asInt();
		String tipoPago = todoElJSON.findValue("tipoPago").asText();
		Cliente elCliente = repo.findByDni(dni);
		MedioDePago unMedioDePago = repoMDP.findByNombre(tipoPago);
		Orden nuevaOrden = elCliente.comprar(unMedioDePago);
		repoOrdenes.save(nuevaOrden);
		return nuevaOrden;
	}
	
	@PostMapping(path="/agregarAlCarrito")
	public String agregarACarrito(@RequestBody String body) throws JsonMappingException, JsonProcessingException {
		final JsonNode todoElJSON = mapper.readTree(body);
		int dni = todoElJSON.findValue("dni").asInt();
		int idProducto = todoElJSON.findValue("id_producto").asInt();
		int cantidad = todoElJSON.findValue("cantidad").asInt();
		
		
		Producto elProducto = repoProductos.findByIdprod(idProducto);
		Cliente unCliente = repo.findByDni(dni);
		unCliente.agregarACarrito(elProducto, cantidad);
		for(ProductoCarrito unProd : unCliente.getCarrito()) {
			repoUnidadCarrito.save(unProd);
		}
		
		return "1";
	}
}

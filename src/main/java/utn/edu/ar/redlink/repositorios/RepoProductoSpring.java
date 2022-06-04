package utn.edu.ar.redlink.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import utn.edu.ar.redlink.dominio.productos.Producto;

public interface RepoProductoSpring extends CrudRepository<Producto, Integer> {

	List<Producto> findAll();

	Producto findByDescripcion(String nombre);
	
	Producto findById(int id);
	
}
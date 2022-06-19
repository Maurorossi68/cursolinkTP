package utn.edu.ar.redlink.repositorios;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import utn.edu.ar.redlink.dominio.productos.Producto;

@RepositoryRestResource(path="productos")
public interface RepoProductoSpring extends PagingAndSortingRepository<Producto, Integer> {

	List<Producto> findAll();

	Producto findByDescripcion(String nombre);
	
	Producto findById(int id);
	
	
	
}
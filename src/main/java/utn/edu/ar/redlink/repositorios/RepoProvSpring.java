package utn.edu.ar.redlink.repositorios;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import utn.edu.ar.redlink.dominio.productos.Proveedor;

@RepositoryRestResource(path="proveedores")
public interface RepoProvSpring extends PagingAndSortingRepository<Proveedor, Integer> {

	List<Proveedor> findAll();

	Proveedor findByNombre(String nombre);
	
	Proveedor findById(int id);
	
}
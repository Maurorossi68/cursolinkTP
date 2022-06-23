package utn.edu.ar.redlink.repositorios;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import utn.edu.ar.redlink.dominio.productos.Proveedor;

@CrossOrigin
@RepositoryRestResource(path="proveedores")
public interface RepoProvSpring extends PagingAndSortingRepository<Proveedor, Integer> {

	List<Proveedor> findAll();

	Proveedor findByNombre(String nombre);
	
	Proveedor findById(int id);
	
}
package utn.edu.ar.redlink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import utn.edu.ar.redlink.dominio.productos.Producto;

@CrossOrigin
@RepositoryRestResource(path="productos")
public interface RepoProductoSpring extends PagingAndSortingRepository<Producto, Integer> {

	Producto findByDescripcion(String descripcion);
	
	Producto findByIdprod(int idprod);
	
}
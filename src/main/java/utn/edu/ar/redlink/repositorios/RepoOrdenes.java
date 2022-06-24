package utn.edu.ar.redlink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import utn.edu.ar.redlink.dominio.productos.Orden;

@CrossOrigin
@RepositoryRestResource(path="ordenes")
public interface RepoOrdenes extends PagingAndSortingRepository<Orden, Integer> {
	
	Orden findByIdOrden(int idOrden);
}

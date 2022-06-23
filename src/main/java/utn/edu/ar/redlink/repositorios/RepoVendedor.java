package utn.edu.ar.redlink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import utn.edu.ar.redlink.dominio.usuarios.Vendedor;

@CrossOrigin
@RepositoryRestResource
public interface RepoVendedor extends PagingAndSortingRepository<Vendedor, Integer> {

	Vendedor findById(int id);
}

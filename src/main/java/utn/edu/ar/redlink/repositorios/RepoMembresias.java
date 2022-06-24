package utn.edu.ar.redlink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import utn.edu.ar.redlink.dominio.promociones.Membresia;

@CrossOrigin
@RepositoryRestResource(path="membresias")
public interface RepoMembresias extends PagingAndSortingRepository<Membresia, Integer> {

	Membresia findByIdMemb(int IdMemb);
}

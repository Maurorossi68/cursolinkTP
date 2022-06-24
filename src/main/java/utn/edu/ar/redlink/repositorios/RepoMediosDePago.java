package utn.edu.ar.redlink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import utn.edu.ar.redlink.dominio.promociones.MedioDePago;

@CrossOrigin
@RepositoryRestResource(path="mediosdepago")
public interface RepoMediosDePago extends PagingAndSortingRepository<MedioDePago, Integer> {

	MedioDePago findByIdMP(int idMP);
	
	MedioDePago findByNombre(String nombre);
}

package utn.edu.ar.redlink.repositorios;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import utn.edu.ar.redlink.dominio.promociones.Cupon;
@CrossOrigin
@RepositoryRestResource(path="cupones")
public interface RepoCupones extends PagingAndSortingRepository<Cupon, Integer> {

	Optional<Cupon> findById(Integer id);
}

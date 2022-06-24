package utn.edu.ar.redlink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import utn.edu.ar.redlink.dominio.productos.ProductoCarrito;

@CrossOrigin
@RepositoryRestResource(path="carritos")
public interface RepoProdCarrito extends PagingAndSortingRepository<ProductoCarrito, Integer> {

	ProductoCarrito findByIdcarrito(int idcarrito);
}

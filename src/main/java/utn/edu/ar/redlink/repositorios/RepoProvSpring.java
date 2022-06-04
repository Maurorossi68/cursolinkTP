package utn.edu.ar.redlink.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import utn.edu.ar.redlink.dominio.productos.Proveedor;

public interface RepoProvSpring extends CrudRepository<Proveedor, Integer> {

	List<Proveedor> findAll();

	Proveedor findByNombre(String nombre);
	
	Proveedor findById(int id);
	
}
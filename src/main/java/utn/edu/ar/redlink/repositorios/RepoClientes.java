package utn.edu.ar.redlink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import utn.edu.ar.redlink.dominio.usuarios.Cliente;

public interface RepoClientes extends PagingAndSortingRepository<Cliente, Integer> {

	Cliente findByDni(int dni);
}

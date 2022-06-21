package utn.edu.ar.redlink.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.edu.ar.redlink.dominio.productos.Proveedor;
import utn.edu.ar.redlink.repositorios.RepoProvSpring;
/*
@RestController
public class ProveedoresController {
	
	@Autowired
	private RepoProvSpring repo;
	
	@GetMapping(path="/proveedores",params = {"page"})
	public Page<Proveedor> findPaginated(@RequestParam(value="page", required=true) Integer page, 
	  @RequestParam(value="size", required=false) Integer size,
	  @RequestParam(value="sort", required=false) String sort) {
		Pageable pageRequest;
		if(size == null) { size=0;}
		if(sort == null ) {
			 pageRequest = PageRequest.of(page, size, Sort.unsorted());
		}else{
			 pageRequest = PageRequest.of(page, size, Sort.by(sort));
		}
		
		return repo.findAll(pageRequest);
	}
	
	@GetMapping("/proveedores")
	public List<Proveedor> findAll(){
		return repo.findAll();
	}
	
	@GetMapping("/proveedores/{id}")
	public Proveedor obtenerUnProveedor(@PathVariable("id") int idProv) {
		return repo.findById(idProv);
	}

	@PostMapping("/proveedores")
	public Proveedor agregarProveedor(@RequestBody @Valid Proveedor proveedor,			
			BindingResult bindingResult) {
		repo.save(proveedor);
		return  proveedor;
	}
}*/
